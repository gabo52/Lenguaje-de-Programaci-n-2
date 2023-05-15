using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Model
{
    public class Filiacion
    {
        private int _idFiliacion;
        private string _nombre;
        private string _siglas;

        public int IdFiliacion { get => _idFiliacion; set => _idFiliacion = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public string Siglas { get => _siglas; set => _siglas = value; }
    }
}
