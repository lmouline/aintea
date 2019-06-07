using Microsoft.ML.Probabilistic.Models;

namespace ErrorHandling
{
    public class Substation
    {
        public Fuse[] Fuses { get; set; }
        public Cable[] Cables { get; set; }
        public Variable<double> Load { get; set; }
    }
}

