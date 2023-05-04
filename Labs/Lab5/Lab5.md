# Laboratorio 5:
# 1. Creación del proyecto DB Manager:

Creamos el proyecto DBManager como .NETFramework y creamos la clase 
DBManager para crear la cadena que tendrá los datos de conexión.
# 2 Programación de los DAO y MySQL
Se crean las variables con, comando y lector. Para establecer la conexión, realizar comandos y leer al hacer las consultas.
Se implementan los DAO y MySQL ya sea para listar, insertar, eliminar, actualizar. Es importante tomar en cuenta 
el nombre de los campos y ver cómo se han desarrollado las tablas, por lo que ver el diagrama y los scripts usados en la BD es importante.

No olvidar colocar los DAO y MySQL en public y crear las clases DAO como interface.

# 3 Programación de la interfaz:
Esta programación es para la pantalla principal donde se tendrán los botones nuevo, buscar y cancelar.
No debemos olvidar inicializar el objeto con el que vamos a trabajar apenas cambiamos el estado a nuevo.
Igualmente debemos tener variables de los DAO e inicializarlas en el constructor.

## 3.1 Para pantallas de registro:
----

En la declaración de las variables del forms debemos ver el estado, las clases a usar y los DAOs que vamos a emplear.
igualmente debemos ver los comboBox existentes para programar las posibles opciones a escoger, usando los listar todos de la BD.

No olvidar inicializar las clases creadas dentro de otra clase.


Para los combo box:
Usar el DisplayMember y ValueMember para configurar los valores a mostrar y el valor que va a retornar.
Se usan los getters respectivos y se asigna el DataSource con la función DAO que devuelve una lista de clases.

Si se realiza una búsqueda en un formulario emergente:
crear el formulario a abrir e inicializarlo al usar el boton correspondiente.
Luego crear el:

	if(frm.ShowDialog() == DialogResult.OK){
		objeto = frm.ObjetoSeleccionado //Para recoger los datos del objeto seleccionado en el formulario.
		txtCorrespondiente.Text = objeto.Nombre;
	}

Si vamos a guardar en la base de Datos:

Llenamos los valores con los textLabel, formularios de búsqueda, combo box, radio button, checkbox, subida de archivos, etc.

Luego igualamos el objeto principal con sus atributos obtenidos en la interfaz gráfica, no olvidar de realizar las inicializaciones correspondientes y asignar los valores obtenidos del formulario.
		

Luego llamamos al dao para insertar y realizamos la validación correspondiente.

	int resultado = dao.insertar(videojuego);
	if (resultado != 0)
	{
		MessageBox.Show("Se ha registrado con éxito",
				"Mensaje de confirmación", MessageBoxButtons.OK,
				MessageBoxIcon.Information);
		txtIdVideojuego.Text = resultado.ToString();
	}
	else
	{
		MessageBox.Show("Ha ocurrido un error con el registro",
				"Mensaje de error", MessageBoxButtons.OK,
				MessageBoxIcon.Error);
	}

## 3.2 Para las pantallas de busqueda:
------
No olvidar poner el AutoGenerateColumns en false.


No olvidar editar las columnas del formulario para mostrar los valores correspondientes, se pone el Getter en el DataPropertyName

Para el boton buscar:

	dgv.Datasource = dao.listar();
Para el boton seleccionar:

	if(dgv.CurrentRow != null)
	{
		ObjetoSeleccionado = (TipoObj)dgv.CurrentRow.DataBoundItem;
		this.DialogResult = DialogResult.OK;
	}

Además debemos crear su respectivo getter y setter del objeto seleccionado a retornar.

Para las dataGrill, se debe poner el nombre del getter en el DataProperyName

Si es para una busqueda que no retorna valor a otro formulario, es decir, va a buscar un dato y lo va a mostrar completo en el formulario como función principal del sistema:

En el botón buscar creamos un formulario del tipo correspondiene y lo inicializamos, luego:

	if(frm.ShowDialog() == DialogResult.OK)
	{
		obj = frmBusqVid.objSeleccinado;
		/*Se asignan los valores del objeto para que se muestren en los objetos gráficos*/
		//cbo.SelectedValue -> Nos vuelve el valor obtenido en el combo box
		_estado = Estado.Buscar;
	}

La programación del formulario es el mismo que el mencionado anteriormente.


				
				
				
Anexo:

Para nombrar los objetos:
-	TextBox -> txt
-	Label -> lbl
-	DataGrillView ->dgv
-	CheckBox -> cb

		