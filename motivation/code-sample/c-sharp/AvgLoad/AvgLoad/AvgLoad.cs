using System;
using Microsoft.ML.Probabilistic.Models;
using Microsoft.ML.Probabilistic.Distributions;
using System.Collections.Generic;

namespace AvgLoad
{
    public class Constants {
        internal const int NB_CABLES = 2;
        internal const int MIN_LOAD = 0;
        internal const int MAX_LAOD = 150;
    }

    public class SmartGrid {
        public List<Cable> cables { get; private set; }
        private readonly InferenceEngine inference;

        public SmartGrid(InferenceEngine ie) {
            this.cables = new List<Cable>();
            this.inference = ie;
        }

        public Gaussian computeAvgLoad() {
            Variable<double> sum = Variable.GaussianFromMeanAndVariance(0,0).Named("sum");

            int i = 0;
            foreach(Cable c in cables) {
                sum = (sum + c.load).Named("sum" + i);
                i++;
            }

            Variable<double> result = (sum / cables.Capacity).Named("AvgLoad");
            return (Gaussian) this.inference.Infer(result);
        }
    }

    public class Cable {
        public String Id { get; private set; }
        public Variable<double> load { get; set; }
        private readonly InferenceEngine inference;

        public Cable(String id, Variable<double> load, InferenceEngine ie) {
            this.Id = id;
            this.load = load;
            this.inference = ie;
        }

        public Cable(String id, InferenceEngine ie): this(id, Variable.GaussianFromMeanAndVariance(0,0).Named("load"), ie) {}


        public override string ToString() {
            return String.Format("Cable({0}, {1})", Id, inference.Infer(load));
        }

    }

    public class Runner
    {
        public static void Main() {
            Random random = new Random();
            InferenceEngine ie = new InferenceEngine();
            SmartGrid grid = new SmartGrid(ie);

            for (int i = 0; i < Constants.NB_CABLES; i++) {
                double load = random.NextDouble() * (Constants.MAX_LAOD - Constants.MIN_LOAD) + Constants.MIN_LOAD;
                double maxVar = load / 2;
                double variance = random.NextDouble() * maxVar;
                String id = String.Format("Cable_{0}", i);
                Cable c = new Cable(id, Variable.GaussianFromMeanAndVariance(load, variance).Named(id), ie);
                grid.cables.Add(c);
            }

            foreach (Cable c in grid.cables) {
                Console.WriteLine(c);
            }

            Gaussian meanLoad = grid.computeAvgLoad();
            Console.WriteLine("Grid load is equal to " + meanLoad);

        }
    }
}
