using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectSoftModel
{
    public class Proyecto
    {
        private int _idProyecto;
        private Area _area;
        private Estudiante _estudiante;
        private BindingList<Docente> _jurados;
        private string _titulo;
        private string _descripcion;
        private byte[] _foto;
        private byte[] _archivoTemaTesis;
        private bool _activo;
        public int IdProyecto { get => _idProyecto; set => _idProyecto = value; }
        public Area Area { get => _area; set => _area = value; }
        public Estudiante Estudiante { get => _estudiante; set => _estudiante = value; }
        public string Titulo { get => _titulo; set => _titulo = value; }
        public string Descripcion { get => _descripcion; set => _descripcion = value; }
        public byte[] Foto { get => _foto; set => _foto = value; }
        public byte[] ArchivoTemaTesis { get => _archivoTemaTesis; set => _archivoTemaTesis = value; }
        public bool Activo { get => _activo; set => _activo = value; }
        public BindingList<Docente> Jurados { get => _jurados; set => _jurados = value; }
    }
}