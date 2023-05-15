using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Model
{
    public class Docente
    {
        private int _idDocente;
        private string _codigoPUCP;
        private string _nombre;
        private string _apellidoPaterno;
        private TipoDocumento _tipoDocumento;
        private string _numeroDocumento;
        private string _maximoGradoAlcanzado;
        public int IdDocente { get => _idDocente; set => _idDocente = value; }
        public string CodigoPUCP { get => _codigoPUCP; set => _codigoPUCP = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public string ApellidoPaterno { get => _apellidoPaterno; set => _apellidoPaterno = value; }
        public TipoDocumento TipoDocumento { get => _tipoDocumento; set => _tipoDocumento = value; }
        public string NumeroDocumento { get => _numeroDocumento; set => _numeroDocumento = value; }
        public string MaximoGradoAlcanzado { get => _maximoGradoAlcanzado; set => _maximoGradoAlcanzado = value; }
    }
}
