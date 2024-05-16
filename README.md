FARA SANTEYANA, María Guillermina


[LINK GITHUB](https://gitlab.com/guillerminafara/db-profe/-/tree/main/DDL?ref_type=heads)

### Query 1 
De esta manera estamos buscando toda la información de la tabla cliente (Customer) donde el país coincida con "France".
```sql
SELECT * FROM Customer where Country ="France";
```
### Query 2 
``Muestra las facturas del primer trimestre de este año.``
Buscaremos en la tabla factura toda la información de estas dando la condición de que las facturas sean del año en curso y que los meses sean entre enero(01) y marzo(03).
En la segunda variante se da de similar forma la condición del año, en este caso solicitamos que los meses coincidan con los números 1, 2 y 3.
```sql
SELECT * 
FROM Invoice
where year(InvoiceDate) like year(now()) 
and month(InvoiceDate) between 01 and 03;

SELECT * 
FROM Invoice
where year(InvoiceDate) like year(now()) 
and month(InvoiceDate) in (1,2,3);
```
### Query 3 
``Muestra todas las canciones compuestas por AC/DC.``
Buscamos dentro de la Tabla Track los resultados que en la columna composer coincidan con "AC/DC".
```sql
use Chinook;
SELECT * 
FROM Track
where Composer like 'AC/DC';
```
### Query 4 
``Muestra las 10 canciones que más tamaño ocupan.``
Dentro de la tabla Track ordenaremos por bytes de mayor a menor poniendole como límite 10 resultados.
```sql
SELECT *
FROM Track
ORDER BY Bytes Desc limit 10;

```
### Query 5 
``Muestra el nombre de aquellos países en los que tenemos clientes.``
Dentro de la tabla Customer buscaremos los paises. Como esta opción muestra los resultados repetidos, con el distinct eliminamos del resultado aquellas filas repetidas. 
```sql
SELECT distinct Country as "Paises con clientes"
FROM Customer;
```
### Query 6 
``Muestra todos los géneros musicales.``
DEsde la tabla Genre solicitamos todos las filas.
```sql
select * from Genre;
```
### Query 7
``Muestra todos los artistas junto a sus álbumes.``
En esta ocasión hacemos la unión de las tablas Artist con Album, lo hacemos mediante una clave tienen en comun ``ArtistId``, de esta manera podemos mostrar los artistatas con el título del álbum.
```sql
select Artist.Name, Album.Title 
from Artist
join Album on (Artist.ArtistId= Album.ArtistId);
```
### Query 8
``Muestra los nombres de los 15 empleados más jóvenes junto a los nombres de sus supervisores, si los tienen.``
Haremos la unión de la tabla empleado consigo misma, donde coincida el id de empleado con el id de ReportsTo, de esta forma podremos conseguir tanto los empleados como sus supervisores. Luego ordenaremos de forma descendente las filas recibidas según la fecha de nacimiento (las fechas mayores son las personas màs jóvenes). He limitados a 3 resultados ya que no hay 15 empleados.
```sql
SELECT A.FirstName as Empleado, S.FirstName as Supervisor, A.BirthDate
FROM Employee as A JOIN Employee as S on (A.ReportsTo = S.EmployeeId)
order by A.BirthDate desc limit 3;
```
### Query 9
``Muestra todas las facturas de los clientes berlineses. Deberán mostrarse las columnas: fecha de la factura, nombre completo del cliente, dirección de facturación, código postal, país, importe (en este orden).``
En este caso tomaremos de las tablas factura en unión con cliebte mediante la clave primaria CustomerId primaria en Customer y foránea en Factura, dando la condición de que la ciudad del cliente deba ser Berlín. Es necesaria la unión de ambas tablas para encontrar los atributos como código postal, país, ciudad,  importe ya que esta información de encuentran en ambas tablas.
```sql
select Invoice.InvoiceDate, Customer.FirstName, Customer.LastName, Invoice.BillingAddress, Customer.PostalCode, Customer.Country, Invoice.Total
from Invoice join Customer 
on (Invoice.CustomerId= Customer.CustomerId)
where Customer.City like "Berlin";
```
### Query 10
``Muestra las listas de reproducción cuyo nombre comienza por C, junto a todas sus canciones, ordenadas por álbum y por duración.``
Para esta query necesitaremos de la unión de de la tabla PlayList con PlayListTrack y está última conTrack mediante Join, estas tablas cuentan con claves que las interrelacionan. DAremos la condición de que el nombre de la PlayList comience con letra `c` y al resultado lo ordenaremos por milisegundos de forma ascendente. de la tabla PlayList mostraremos el nombre de la Playlist, de Track también mostremos su nombre y por último mostraremos la duración de las canciones 

```sql

select Playlist.Name, Track.Name, Track.Milliseconds
from Playlist join PlaylistTrack on(Playlist.PlaylistId= PlaylistTrack.PlaylistId)
join Track on(PlaylistTrack.TrackId=Track.TrackId)
where Playlist.Name like "c%" order by Track.Milliseconds asc;


```

### Query 11
``Muestra qué clientes han realizado compras por valores superiores a 10€, ordenados por apellido.``
Para esta query necesitamos también trabajar con lqs claves que coinciden en las tablas Customer y tabla Invoice. Buscaremos dentro de estás tablas aquellos totales que superen los 10 euros y los ordenaremos por el apellido de Customer, es decir del cliente, de a-z.
```sql
select Customer.CustomerId, Customer.LastName, Invoice.Total
from Customer join Invoice on (Customer.CustomerId =Invoice.CustomerId)
where Invoice.Total > 10
order by Customer.LastName asc;
```
### Query 12
``Muestra el importe medio, mínimo y máximo de cada factura.``
Con la siguiente consulta estamos obteniendo el monto total más bajo, el más alto y un promedio del total que se encuentran en la tabla Invoice.
```sql

SELECT min(total), max(total), avg(total) 
FROM invoice;
```
### Query 13
``Muestra el número total de artistas.``
En la siguiente query hacemos un conteo de los artistas  que aparecen en la tabla Artist. 
```sql
select count(*)
from Artist;
```
### Query 14
``Muestra el número de canciones del álbum “Out Of Time”.``

```sql
select count(Track.Name)
from Album join Track 
on(Album.AlbumId= Track.AlbumId)
where Album.Title like "Out Of Time";
```
### Query 15
``Muestra el número de países donde tenemos clientes.``
Trabajando con la tabla Customer realizaremos un conteo evitando repeticiones con un count (DISTINCT)de los países que en este caso son clientes. 
```sql
select count( DISTINCT Country)
from Customer 
```
### Query 16
``Muestra el número de canciones de cada género (deberá mostrarse el nombre del género).``
```sql
select Genre.Name ,count(Track.Name) as "numero de canciones" 
from Track 
join Genre on (Track.GenreId=Genre.GenreId) 
group by Genre.Name 
ORDER BY `numero de canciones` DESC;

```
### Query 17
``Muestra los álbumes ordenados por el número de canciones que tiene cada uno.``
```sql
use Chinook;
select count(Track.TrackId), Album.Title
from Album join Track on (Album.AlbumId = Track.AlbumId)
group by Title order by count(Track.TrackId) desc;
```

### Query 18
``Encuentra los géneros musicales más populares (los más comprados).``
```sql
select Genre.GenreId, Genre.Name, count(*)
from Track join InvoiceLine
on (Track.TrackId = InvoiceLine.TrackId)
join Genre on (Track.GenreId=Genre.GenreId)
group by Genre.Name, Genre.GenreId order by count( *) desc;
```
### Query 19
`` Lista los 6 álbumes que acumulan más compras.``
Haremos la unión en esta ocasión de las tablas Customer con la tabla Invoice y está última con la tabla InvoiceLine lo haremos mediante los idCustomer propio en Customer y foráneo en Invoice, así como idIvoice siendo primario en tabla Invoice y foráneo en InvoiceLine. De esta manera limitaremos el resultado obtenido a aquellos quienes coinciden los ID nombrados.
```sql
select Album.AlbumId, Album.Title, Track.Composer, count(*)
from Album join Track on(Album.AlbumId = Track.AlbumId)
join InvoiceLine on (Track.TrackId = InvoiceLine.TrackId)
group by Album.AlbumId, Album.Title, Track.Composer order by count(*) desc limit 6;

select Album.AlbumId, Album.Title, Artist.Name, count(*)
from Album join Track on(Album.AlbumId = Track.AlbumId)
join InvoiceLine on (Track.TrackId = InvoiceLine.TrackId) 
join Artist on (Artist.ArtistId= Album.ArtistId)
group by Album.AlbumId, Album.Title, Artist.Name order by count(*) desc limit 6;

```
### Query 20

`` Muestra los países en los que tenemos al menos 5 clientes.``
Mostraremos los paises y el número de compradores. Posteriormente agruparemos el resultado según los países que han comprado. Realizaremos además, un conteo del idCliente para saber cuántos clientes hay sin que se repitan, el having en esta ocasión delimita los resultados a ese último conteo y finalmente lo ordenaremos siguiente ese conteo de mayor a menor.  
```sql
SELECT Customer.Country, COUNT(DISTINCT Customer.CustomerId) AS "Número de clientes"
FROM Customer 
GROUP BY Customer.Country
HAVING COUNT(DISTINCT Customer.CustomerId) >= 5
ORDER BY "Número de clientes" DESC;

```

