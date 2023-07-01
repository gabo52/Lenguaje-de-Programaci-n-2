using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Model
{
    public class DocentePUCP : Docente
    {
        private string _categoria;
        private bool _activo;

        public string Categoria { get => _categoria; set => _categoria = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}
