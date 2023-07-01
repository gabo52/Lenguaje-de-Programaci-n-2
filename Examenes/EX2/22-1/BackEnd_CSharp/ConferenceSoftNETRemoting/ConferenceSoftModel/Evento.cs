using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConferenceSoftModel
{
    public class Evento
    {
        private int _idEvento;
        private BindingList<Ponencia> _ponencias;
        private string _nombre;
        private DateTime _fecha;
        private string _descripcion;
        private byte[] _portada;
        private bool _activo;

        public int IdEvento { get => _idEvento; set => _idEvento = value; }
        public BindingList<Ponencia> Ponencias { get => _ponencias; set => _ponencias = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public DateTime Fecha { get => _fecha; set => _fecha = value; }
        public string Descripcion { get => _descripcion; set => _descripcion = value; }
        public byte[] Portada { get => _portada; set => _portada = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}
