using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameSoftModel
{
    public class Videojuego
    {
        private int _idVideojuego;
        private Desarrolladora _desarrolladora;
        private Genero _genero;
        private char _plataforma;
        private string _nombre;
        private int _maxJugadores;
        private bool _cooperativo;
        private bool _multiplayer;
        private bool _edicionEspecial;
        private double _precio;
        private string _descripcion;
        private byte[] _portada;
        private bool _activo;
        public int IdVideojuego { get => _idVideojuego; set => _idVideojuego = value; }
        public Desarrolladora Desarrolladora { get => _desarrolladora; set => _desarrolladora = value; }
        public Genero Genero { get => _genero; set => _genero = value; }
        public char Plataforma { get => _plataforma; set => _plataforma = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public int MaxJugadores { get => _maxJugadores; set => _maxJugadores = value; }
        public bool Cooperativo { get => _cooperativo; set => _cooperativo = value; }
        public bool Multiplayer { get => _multiplayer; set => _multiplayer = value; }
        public bool EdicionEspecial { get => _edicionEspecial; set => _edicionEspecial = value; }
        public double Precio { get => _precio; set => _precio = value; }
        public string Descripcion { get => _descripcion; set => _descripcion = value; }
        public byte[] Portada { get => _portada; set => _portada = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}