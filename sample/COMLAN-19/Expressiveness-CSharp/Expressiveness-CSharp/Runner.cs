using System;
using ExpressivenessCSharp.SmartGrid;
using Microsoft.ML.Probabilistic.Models;
using Microsoft.ML.Probabilistic.Distributions;

namespace ExpressivenessCSharp
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            LoadComputer loadComputer = new LoadComputer();

            var var1 = Variable.GaussianFromMeanAndVariance(1, 4);
            var var2 = Variable.GaussianFromMeanAndVariance(1, 9);

            Fuse fuse1 = new Fuse(Variable.Bernoulli(1));
            Fuse fuse2 = new Fuse(Variable.Bernoulli(1));
            Fuse fuse3 = new Fuse(Variable.Bernoulli(1));

            Cable cable1 = new Cable();
            cable1.Load = Variable.GaussianFromMeanAndVariance(10, 0.64);
            fuse1.Cable = cable1;

            Cable cable2 = new Cable();
            cable2.Load = Variable.GaussianFromMeanAndVariance(10, 0.64);
            fuse2.Cable = cable2;

            Cable cable3 = new Cable();
            cable3.Load = Variable.GaussianFromMeanAndVariance(10, 0.64);
            fuse3.Cable = cable3;
            PointMass<double> d = new PointMass<double>(0);


            Substation substation = new Substation(Variable.GaussianFromMeanAndVariance(0,0.001), fuse1, fuse2, fuse3);
            loadComputer.ComputeLoad(substation);

            var loadValue = (Gaussian) loadComputer.InferenceEngine.Infer(substation.Load);
            Console.WriteLine("Load: " + loadValue);

        }
    }
}
