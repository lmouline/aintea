using Microsoft.ML.Probabilistic.Models;
using Microsoft.ML.Probabilistic.Distributions;
using System.Collections.Generic;
using System;

namespace ExpressivenessCSharp
{
    namespace SmartGrid
    {
        public class Substation
        {
            public Variable<double> Load { get; set; }
            public List<Fuse> Fuses { get; set; }

            public Substation(Variable<double> load, params Fuse[] fuses)
            {
                Load = load;
                Fuses = new List<Fuse>(fuses);
            }

            public override string ToString()
            {
                return "Substation(load=" + Load + ", fuses=" + String.Join<Fuse>(", ", Fuses) + ")";
            }

            public Variable<bool> IsDisconnected()
            {
                Variable<bool> isConn;
                if (Fuses.Count == 0)
                {
                    return Variable.Bernoulli(1);
                }
                isConn = Fuses[0].IsClosed;

                for (int i=1; i<Fuses.Count; i++)
                {
                    isConn = isConn | Fuses[i].IsClosed;
                }

                return !isConn;
            }
        }

        public class Fuse
        {
            public Variable<bool> IsClosed { get; set; }
            public Cable Cable { get; set; }

            public Fuse(Variable<bool> isClosed)
            {
                IsClosed = isClosed;
            }

            public override string ToString()
            {
                return "Fuse(isClosed=" + IsClosed + ")";
            }
        }

        public class Cable
        {
            public Variable<double> Load { get; set; }
        }

        public class LoadComputer
        {
            public readonly InferenceEngine InferenceEngine;

            public LoadComputer()
            {
                InferenceEngine = new InferenceEngine();
            }

            public void ComputeLoadNoCable(Substation substation)
            {
                Variable<bool> noCableConn = Variable.Bernoulli(1);
                if(substation.Fuses.Count > 0)
                {
                    noCableConn = substation.Fuses[0].IsClosed;
                }
                else
                {
                    substation.Load = Variable.GaussianFromMeanAndVariance(0, 0.001);
                    return;
                }

                for(int i=1; i<substation.Fuses.Count; i++)
                {
                    noCableConn = noCableConn & substation.Fuses[i].IsClosed;
                }

                Bernoulli bernoulli = (Bernoulli) InferenceEngine.Infer(noCableConn);
                substation.Load = Variable.GaussianFromMeanAndVariance(0, bernoulli.GetVariance());
            }

            public void ComputeLoad(Substation substation)
            {
                Variable<bool> isDisco = substation.IsDisconnected();
                Bernoulli bern = (Bernoulli) InferenceEngine.Infer(isDisco);

                if(bern.GetProbTrue() >= 0.95)
                {
                    ComputeLoadNoCable(substation);
                    return;
                }

                Variable<double> load = Variable.GaussianFromMeanAndVariance(0, 0.001);
                foreach(Fuse fuse in substation.Fuses)
                {
                    Bernoulli isClosedBern = (Bernoulli) InferenceEngine.Infer(fuse.IsClosed);
                    load = load + (fuse.Cable.Load * isClosedBern.GetProbTrue());
                }

                substation.Load = load;

            }

        }


    }
}
