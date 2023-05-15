using EduSoftLP2Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Controller.DAO
{
    public interface CursoDAO
    {
        int insertar(Curso curso);
        BindingList<Curso> listarPorNombreClave(string cadena);
    }
}
