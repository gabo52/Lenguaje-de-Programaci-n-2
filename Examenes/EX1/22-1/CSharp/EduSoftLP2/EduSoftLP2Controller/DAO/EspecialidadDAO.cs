using EduSoftLP2Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftDBManager.DAO
{
    public interface EspecialidadDAO
    {
        BindingList<Especialidad> listarTodos();
    }
}
