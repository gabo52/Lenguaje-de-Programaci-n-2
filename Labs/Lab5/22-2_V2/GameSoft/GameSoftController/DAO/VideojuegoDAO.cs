using GameSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameSoftController.DAO
{
    public interface VideojuegoDAO
    {
        int insertar(Videojuego videojuego);
        BindingList<Videojuego> listarVideojuegosNombre(string nombre);
    }
}
