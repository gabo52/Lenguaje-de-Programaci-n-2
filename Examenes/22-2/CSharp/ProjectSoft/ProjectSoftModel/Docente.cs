using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectSoftModel
{
    public class Docente : Persona
    {
        private string _categoria;
        public string Categoria { get => _categoria; set => _categoria = value; }
    }
}