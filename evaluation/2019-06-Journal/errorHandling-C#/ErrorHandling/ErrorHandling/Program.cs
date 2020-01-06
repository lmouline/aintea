using System;
using Microsoft.ML.Probabilistic.Models;

namespace ErrorHandling
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            //Substation s1 = new Substation();
            //Cable c1 = new Cable
            //{
            //Load = Variable.GaussianFromMeanAndVariance(10, 0.5).Named("Load_Cable_1")
            //};
            //Cable c2 = new Cable
            //{
            //    Load = Variable.GammaFromMeanAndVariance(10, 0.5).Named("Load_Cable_2")
            //};
            //s1.Load = (c1.Load + 5).Named("Load_Substation_1");
            //InferenceEngine ie = new InferenceEngine();
            //ie.Infer(s1.Load);
            //Console.WriteLine(c1.Load);

            Variable<double> v1 = Variable.GaussianFromMeanAndVariance(10, 0.5).Named("Load_Cable_1");
            Variable<double> v2 = Variable.GaussianFromMeanAndVariance(10, 0.5).Named("Load_Cable_2");
            Variable<bool> v3 = (v1 > v2).Named("jjj");


           

            InferenceEngine ie = new InferenceEngine();
        
            Console.WriteLine(ie.Infer(v3));
        }
    }
}
