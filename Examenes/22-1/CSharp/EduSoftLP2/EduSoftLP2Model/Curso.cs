using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Model
{
    public class Curso
    {
        private int _idCurso;
        private Especialidad _especialidad;
        private Modalidad _modalidad;
        private BindingList<Docente> _docentes;
        private string _nombre;
        private string _clave;
        private string _semestre;
        private bool _reqComputadora;
        private bool _reqDispMovil;
        private bool _reqDispEspecial;
        private string _sumilla;
        private byte[] _foto;
        private byte[] _silabo;
        public int IdCurso { get => _idCurso; set => _idCurso = value; }
        public Especialidad Especialidad { get => _especialidad; set => _especialidad = value; }
        public Modalidad Modalidad { get => _modalidad; set => _modalidad = value; }
        public BindingList<Docente> Docentes { get => _docentes; set => _docentes = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public string Clave { get => _clave; set => _clave = value; }
        public string Semestre { get => _semestre; set => _semestre = value; }
        public bool ReqComputadora { get => _reqComputadora; set => _reqComputadora = value; }
        public bool ReqDispMovil { get => _reqDispMovil; set => _reqDispMovil = value; }
        public bool ReqDispEspecial { get => _reqDispEspecial; set => _reqDispEspecial = value; }
        public string Sumilla { get => _sumilla; set => _sumilla = value; }
        public byte[] Foto { get => _foto; set => _foto = value; }
        public byte[] Silabo { get => _silabo; set => _silabo = value; }
    }
}
