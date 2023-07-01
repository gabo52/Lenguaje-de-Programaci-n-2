using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConferenceSoftModel
{
    public class Integrante
    {
        private int _idIntegrante;
        private TipoIntegrante _tipoIntegrante;
        private String _codigoPUCP;
        private String _nombre;
        private String _apellidoPaterno;
        private bool _activo;

        public int IdIntegrante { get => _idIntegrante; set => _idIntegrante = value; }
        public TipoIntegrante TipoIntegrante { get => _tipoIntegrante; set => _tipoIntegrante = value; }
        public string CodigoPUCP { get => _codigoPUCP; set => _codigoPUCP = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public string ApellidoPaterno { get => _apellidoPaterno; set => _apellidoPaterno = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}
