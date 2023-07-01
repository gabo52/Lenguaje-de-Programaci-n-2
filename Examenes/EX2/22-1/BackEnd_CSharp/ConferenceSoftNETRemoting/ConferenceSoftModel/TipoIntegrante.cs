using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConferenceSoftModel
{
    public class TipoIntegrante
    {
        private int _idTipoIntegrante;
        private String _descripcion;

        public int IdTipoIntegrante { get => _idTipoIntegrante; set => _idTipoIntegrante = value; }
        public string Descripcion { get => _descripcion; set => _descripcion = value; }
    }
}
