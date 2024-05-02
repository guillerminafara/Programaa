# Proyecto gimnasio#
Se plantea hacer un aplicación web de un gimnasio para la autogestión del cliente sobre su registro como cliente, renovación de la mensualidad, reserva de horarios en los que va a asistir para evitar la saturación del espacio. Se plantea también que la página tenga la posibilidad de registrar el estado y rendimiento que el cliente tiene en su rutina de entrenamiento. 

## Base de datos ## 
Necesidad de creación de una base de datos para el manejo de información. Necesitaremos de al menos, 4 tablas.
# Tabla Clientes# 
Columnas: 
**idCliente** con manejo de informacion númerica 
**Nombre:** manejo de datos alfanuméricos, no nulo, 
**Apellido:** manejo de datos alfanuméricos 
**Dni**: manejo de datos alfanuméricos 
**Teléfono**: número entero
**Estado**: tinyint para control de informacion de estado activo e inactivo. 

## Tabla pago de cuota##
**Mes:** de tipo LocalDate
**Promoción:** Tinyint si tiene alguna promoción vigente.
**Pago:** Tinyint para registrar el pago según el mes. El estado de este dato determinará el estado de la persona como cliente en el gimnasio. Es decir estará vinculada con la ``tabla cliente``. 

## Tabla Reserva de horario ## 
A determinar. 
**Dia**
**Hora**
**estado**

#Interfaz Gráfica#
 




