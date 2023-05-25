# Lab 9

Paso 1:

Crear DBManager con los datos de conexión y copiar el jdbc en el proyecto.
Se copia en el proyecto principal y se añade a las librerias de el proyecto principal.

Paso 2:

Si necesitamos guardar o listar debemos crear los respectivos DAO y MySQL.

Para guardar:

Cargamos todos los datos en un objeto y luego usamos el insertar.

Para listar:

Creamos los DAO correspondientes y un ArrayList donde guardaremos la lista recogida de la BD. Luego creamos el completar tabla y usamos un DefaultTableModel para obtener referencia del modelo de la tabla.

modeloEmpleados = (DefaultTableModel) tblEmpleados.getModel();

Paso 3:
Para usar los comboBox.
Creamos la variable DAO correspondiente al listado y creamos una variable DefaultComboBoxModel del modelo, la inicializamos con un array y enlazamos la parte gráfica de la siguiente forma:

    modeloAreas = new DefaultComboBoxModel(daoArea.listarTodas().toArray());
    cboArea.setModel(modeloAreas);

Para obtener el nombre en pantalla podemos sobreescribir el método toString de la clase retornando el nombre o la cadena que queramos.

La otra forma es con el setRenderer.
``` java
    cboArea.setRenderer( new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Area){
                    setText(((Area)value).getNombre());
                }
                return this;
                }
            });
```
Paso 5: 

Para guardar con información obtenida de otro formulario.
Se debe crear un constructor con el Dialog para luego realizar el close con el visible = false;
``` java
    public frmBusquedaEstudiantes(JDialog dialogo) {
        initComponents();
        daoEstudiante = new EstudianteMySQL();
        modeloEstudiantes = (DefaultTableModel) dgvEstudiantes.getModel();
        this.dialogo = dialogo;
    }

        JDialog formModal = new JDialog();
    frmBusquedaEstudiantes panelBusqEst = new frmBusquedaEstudiantes(formModal);
    formModal.add(panelBusqEst);
    formModal.pack();
    formModal.setResizable(false);
    formModal.setTitle("Formulario de Búsqueda de Empleados");
    formModal.setModal(true);
    formModal.setVisible(true);
    if(panelBusqEst.getEstudianteSeleccionado()!=null){
        estudiante = panelBusqEst.getEstudianteSeleccionado();
        txtEstudiante.setText(estudiante.getNombre()+" "+estudiante.getApellidoPaterno());
        //estado = Estado.Buscar;
        //establecerEstadoComponentes();
    }
```
# Notas
Click -> action performed

Para el casteo usar String.valueOf o el parse.

Para pasar de enum a String: 
``` java
    cs.setString("_categoria", cliente.getCategoria().toString());
```

Para pasar de String a enum:
``` java
    cliente.setCategoria(Categoria.valueOf(rs.getString("categoria")));
```
Para "descargar" archivos:

``` java
FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG","PNG","jpg","png");
ofdArchivo.setFileFilter(filtro);

int resultado = ofdArchivo.showSaveDialog(null);

if(resultado == JFileChooser.APPROVE_OPTION){
    try{
        File archivoSeleccionado = ofdArchivo.getSelectedFile();
        FileOutputStream fos = new FileOutputStream(archivoSeleccionado);
        fos.write(this.proyecto.getArchivoTemaTesis());
        fos.flush();
        fos.close();
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
}

```

Para poner el valor respectivo del cbo:

``` java
proyecto.setArea((Area)cboArea.getSelectedItem());
```

Para el Calendar:

Ponemos el jar en la carpeta lib del proyecto principal.
Añadimos el JAR/FOLDER
Click derecho en la paleta le damos a palette manager.
Creamos un nuevo componente y agregamos el jar.


Datos conexión:
user: admin
password:inf282lp220231
nombre de la BD: lp2newbd
hostname: database-lp2-newbd.cipfleuw5pam.us-east-1.rds.amazonaws.com
Identificador del clúster de base de datos: database-lp2-newBD