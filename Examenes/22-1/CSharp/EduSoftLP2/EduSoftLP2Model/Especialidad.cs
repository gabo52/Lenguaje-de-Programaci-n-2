using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Model
{
    public class Especialidad
    {
        private int _idEspecialidad;
        private string _nombre;
        private bool _activo;

        public int IdEspecialidad { get => _idEspecialidad; set => _idEspecialidad = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}
