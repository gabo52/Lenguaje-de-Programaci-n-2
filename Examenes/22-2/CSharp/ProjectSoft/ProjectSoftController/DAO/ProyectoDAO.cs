using ProjectSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectSoftController.DAO
{
    public interface ProyectoDAO
    {
        BindingList<Proyecto> listarXTituloCodigoPUCPNombre(string cadena);
        int insertar(Proyecto proyecto);
    }
}
