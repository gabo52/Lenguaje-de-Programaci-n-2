using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConferenceSoftModel
{
    public class Ponencia
    {
        private int _idPonencia;
        private Integrante _ponente;
        private String _titulo;
        private TimeSpan _horaInicio;
        private TimeSpan _horaFin;
        private bool _activo;
        public int IdPonencia { get => _idPonencia; set => _idPonencia = value; }
        public Integrante Ponente { get => _ponente; set => _ponente = value; }
        public string Titulo { get => _titulo; set => _titulo = value; }
        public TimeSpan HoraInicio { get => _horaInicio; set => _horaInicio = value; }
        public TimeSpan HoraFin { get => _horaFin; set => _horaFin = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}
