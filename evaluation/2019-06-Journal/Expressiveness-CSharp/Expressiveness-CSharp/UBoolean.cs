using Microsoft.ML.Probabilistic.Models;

namespace ExpressivenessCSharp
{
    public class UBoolean
    {
        public bool Value { get; set; }
        public Variable<bool> Confidence { get; set; }

        public UBoolean(bool value=false, float confidence=0)
        {
            Value = value;
            if(Value)
            {
                Confidence = Variable.Bernoulli(confidence);
            }
            else
            {
                Confidence = Variable.Bernoulli(1 - confidence);
            }
        }

        public UBoolean(bool value, Variable<bool> confidence)
        {
            Value = value;
            Confidence = confidence;
        }

        public override string ToString()
        {
            return "UBoolean(value=" + Value + ", confidence=" + Confidence + ")";
        }

        public static UBoolean operator &(UBoolean left, UBoolean right)
        {
            return new UBoolean(left.Value && right.Value, left.Confidence & right.Confidence);
        }

        public static UBoolean operator |(UBoolean left, UBoolean right)
        {
            return new UBoolean(left.Value || right.Value, left.Confidence | right.Confidence);
        }
    }
}
