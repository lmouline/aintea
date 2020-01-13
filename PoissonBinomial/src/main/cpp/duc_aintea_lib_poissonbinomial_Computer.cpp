#include <jni.h>
#include <fftw3.h>
#include <complex>
#include "duc_aintea_lib_poissonbinomial_Computer.h"

using namespace std;

void dft_pmf(fftw_complex* out, int m, jdouble* pp);

JNIEXPORT jdoubleArray JNICALL Java_duc_aintea_lib_poissonbinomial_Computer_compute(JNIEnv *env, jclass, jdoubleArray probs) {
    // Convert jdoubleArray into jdouble*
    if(probs == NULL) return NULL;
    jsize size_array_res = env->GetArrayLength(probs) + 1;
    if(size_array_res == 1) return NULL; // empty input
    jdouble* array_probs = env->GetDoubleArrayElements(probs, NULL);
    if(array_probs == NULL) return NULL;


    // Compute PoissonBinomial
    fftw_complex* out;
    out = (fftw_complex*) fftw_malloc(sizeof(fftw_complex) * size_array_res);
    dft_pmf(out, size_array_res, array_probs);

    jdouble res[size_array_res];
    for(int k = 0; k < size_array_res; ++k)
    {
        res[k] = out[k][0] / size_array_res;
    }
    fftw_free(out);

    // Convert jdouble* into jdoubleArray
    jdoubleArray outJNI = env->NewDoubleArray(size_array_res);
    if(outJNI == NULL) return NULL;
    env->SetDoubleArrayRegion(outJNI, 0 , size_array_res, res);
    return outJNI;
}

void dft_pmf(fftw_complex* out, int m, jdouble* pp) {
    int n = m - 1;
    fftw_complex* in;
    fftw_plan p;
    in = (fftw_complex*) fftw_malloc(sizeof(fftw_complex) * m);
    complex<double> C(0.0,2);
    C = exp(C * 3.1415926535897 / ((double)m));
    double C_real = C.real();
    double C_imag = C.imag();


    //build input vector
    double tmp_real;
    double tmp_imag;
    std::complex<double> temp;
    std::complex<double> f(1.,0.0);
    in[0][0] = 1.0;
    in[0][1] = 0.0;


    int halfn = n / 2 + 1;
    for (int i = 1; i <= halfn; ++i){
        temp = 1.;
        tmp_real = f.real();
        tmp_imag = f.imag();
        f.real(tmp_real * C_real - tmp_imag * C_imag);
        f.imag(tmp_imag * C_real + tmp_real * C_imag);
        for(int j = 0; j < n; ++j){
            temp *= (1. + (f - 1.) * pp[j]);
        }

        in[i][0] = temp.real();
        in[i][1] = temp.imag();
        in[m-i][0] = temp.real();
        in[m-i][1] = - temp.imag();
    }


    //dft
    p = fftw_plan_dft_1d(m, in, out, FFTW_FORWARD, FFTW_ESTIMATE);
    fftw_execute(p);
    fftw_destroy_plan(p);
    fftw_free(in);
}