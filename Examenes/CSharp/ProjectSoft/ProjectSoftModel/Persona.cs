using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectSoftModel
{
    public class Persona
    {
        private int _idPersona;
        private string _codigoPUCP;
        private string _nombre;
        private string _apellidoPaterno;
        public int IdPersona { get => _idPersona; set => _idPersona = value; }
        public string CodigoPUCP { get => _codigoPUCP; set => _codigoPUCP = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public string ApellidoPaterno { get => _apellidoPaterno; set => _apellidoPaterno = value; }
    }
}