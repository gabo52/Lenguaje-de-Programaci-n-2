using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Model
{
    public class DocenteExtranjero : Docente
    {
        private Filiacion _filiacion;
        private bool _dominaEspanhol;
        private bool _dominaIngles;
        private bool _gradoRevalidadoSUNEDU;
        private bool _activo;

        public Filiacion Filiacion { get => _filiacion; set => _filiacion = value; }
        public bool DominaEspanhol { get => _dominaEspanhol; set => _dominaEspanhol = value; }
        public bool DominaIngles { get => _dominaIngles; set => _dominaIngles = value; }
        public bool GradoRevalidadoSUNEDU { get => _gradoRevalidadoSUNEDU; set => _gradoRevalidadoSUNEDU = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}
