using EduSoftLP2Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Controller.DAO
{
    public interface DocenteDAO
    {
        BindingList<Docente> listarPorNombreCodigo(string cadena);
        BindingList<Docente> listarPorIdCurso(int idCurso);
    }
}
