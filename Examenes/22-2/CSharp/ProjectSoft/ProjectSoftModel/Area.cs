﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectSoftModel
{
    public class Area
    {
        private int _idArea;
        private string _nombre;
        private bool _activo;
        public int IdArea { get => _idArea; set => _idArea = value; }
        public string Nombre { get => _nombre; set => _nombre = value; }
        public bool Activo { get => _activo; set => _activo = value; }
    }
}