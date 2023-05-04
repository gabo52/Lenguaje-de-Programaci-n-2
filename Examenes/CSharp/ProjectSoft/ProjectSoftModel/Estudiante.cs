using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectSoftModel
{
    public class Estudiante : Persona
    {
        private double _CRAEST;
        public double CRAEST { get => _CRAEST; set => _CRAEST = value; }
    }
}