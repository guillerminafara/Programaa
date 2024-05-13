FARA SANTEYANA, María Guillermina

# Proyecto gimnasio 
Se plantea hacer un aplicación web de un gimnasio para la autogestión del cliente sobre su registro, renovación de la mensualidad, reserva de horarios en los que va a asistir para evitar la saturación del espacio. Se plantea también que la página tenga la posibilidad de registrar el estado y rendimiento que el cliente tiene en su rutina de entrenamiento, pero veremos.

## Base de datos 
Necesidad de creación de una base de datos para el manejo de información. Necesitaremos de al menos, 4 tablas.
## Tabla Clientes 
**Columnas:**

**idCliente** con manejo de informacion númerica.

**Nombre:** manejo de datos alfanuméricos, no nulo, .

**Apellido:** manejo de datos alfanuméricos.

**Dni**: manejo de datos alfanuméricos.

**Teléfono**: número entero.

**Estado**: tinyint para control de informacion de estado activo e inactivo. 

## Tabla pago de cuota 
**columnas**

**Pago:** Tinyint para registrar el pago según el mes. El estado de este dato determinará el estado de la persona como cliente en el gimnasio. Es decir estará vinculada con la ``tabla cliente``. 

## Tabla Reserva de horario 
Tengo en mente realizar la reserva de horarios registrando la informacion en una base de  datos

**Dia y Hora**

**estado**

# Interfaz Gráfica 
 Plantemos un web con 5 escenas al menos

**Página Principal:** Contendrá botones que nos redireccionan a las siguientes escenas. Imagenes y labels 

**Registro de Usuario:** Contendrá TextFields que reciben la información que registraremos para la creación de Clientes.

**Pago de cuota:** Contendrá TextFields que reciben el pago. No lo gestionaremos desde Java al pago, solo nos sirve para tener el estado del cliente.

**Reserva de Horario:** una tabla que nos presente la semana en curso con horarios disponibles y ocupados 
los horarios disponibles podran seleccionarse, mientras que los ocupados no 


**La quinta depende**

# JAVA 

Trabajaremos con 5 clases para el manejo de objetos.

**Usuario:**

**Pago de cuota:**

**Reserva de Horario:**

**La quinta depende**






