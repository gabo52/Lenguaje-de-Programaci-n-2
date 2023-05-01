using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameSoftModel
{
    public class Desarrolladora
    {
        private int _idDesarrolladora;
        private string _nombre;
        private bool _activo;
        public int IdDesarrolladora { get => _idDesarrolladora; set => _idDesarrolladora = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}