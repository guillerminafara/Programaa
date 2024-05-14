FARA SANTEYANA, María Guillermina


[LINK GITHUB](https://gitlab.com/guillerminafara/db-profe/-/tree/main/DDL?ref_type=heads)

### Query 1 
De esta manera estamos buscando toda la información de la tabla cliente (Customer) donde el país coincida con "France".
```sql
SELECT * FROM Customer where Country ="France";
```
### Query 2 
Muestra las facturas del primer trimestre de este año.
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
Muestra todas las canciones compuestas por AC/DC.
Buscamos dentro de la Tabla Track los resultados que en la columna composer coincidan con "AC/DC".
```sql
use Chinook;
SELECT * 
FROM Track
where Composer like 'AC/DC';
```
### Query 4 
Muestra las 10 canciones que más tamaño ocupan.
Dentro de la tabla Track ordenaremos por bytes de mayor a menor poniendole como límite 10 resultados.
```sql
SELECT *
FROM Track
ORDER BY Bytes Desc limit 10;

```
### Query 5 
Muestra el nombre de aquellos países en los que tenemos clientes.
Dentro de la tabla Customer buscaremos los paises. Como esta opción muestra los resultados repetidos, con el distinct eliminamos del resultado aquellas filas repetidas. 
```sql
SELECT distinct Country as "Paises con clientes"
FROM Customer;
```
### Query 6 
Muestra todos los géneros musicales.
DEsde la tabla Genre solicitamos todos las filas.
```sql
select * from Genre;
```
### Query 7
Muestra todos los artistas junto a sus álbumes.
En esta ocasión hacemos la unión de las tablas Artist con Album, lo hacemos mediante una clave tienen en comun ``ArtistId``, de esta manera podemos mostrar los artistatas con el título del álbum.
```sql
select Artist.Name, Album.Title 
from Artist
join Album on (Artist.ArtistId= Album.ArtistId);
```
### Query 8
Muestra los nombres de los 15 empleados más jóvenes junto a los nombres de
sus supervisores, si los tienen.
Haremos la unión de la tabla empleado consigo misma, donde coincida el id de empleado con el id de ReportsTo, de esta forma podremos conseguir tanto los empleados como sus supervisores. Luego ordenaremos de forma descendente las filas recibidas según la fecha de nacimiento (las fechas mayores son las personas màs jóvenes). He limitados a 3 resultados ya que no hay 15 empleados.
```sql
SELECT A.FirstName as Empleado, S.FirstName as Supervisor, A.BirthDate
FROM Employee as A JOIN Employee as S on (A.ReportsTo = S.EmployeeId)
order by A.BirthDate desc limit 3;
```
### Query 9
Muestra todas las facturas de los clientes berlineses. Deberán mostrarse las columnas:
fecha de la factura, nombre completo del cliente, dirección de facturación,
código postal, país, importe (en este orden).
En esta ocasión tomaremos de las tablas factura en unión con cliebte dando la condición de que la ciudad del cliente deba ser Berlín. Es necesaria la unión de ambas tablas para encontrar los atributos como código postal, país, ciudad,  importe ya que esta información de encuentran en ambas tablas.
```sql
select Invoice.InvoiceDate, Customer.FirstName, Customer.LastName, Invoice.BillingAddress, Customer.PostalCode, Customer.Country, Invoice.Total
from Invoice join Customer 
on (Invoice.CustomerId= Customer.CustomerId)
where Customer.City like "Berlin";
```
### Query 10
En esta ocasión necesitaremos de la unión de de la tabla PlayList con PlayListTrack y está última conTrack mediante Join. dando la condición de que el nombre de la PlayList comience con letra c al resultado lo ordenaremos Album y por milisegundos de forma ascendente. de la tabla PlayList mostraremos 
Muestra las listas de reproducción cuyo nombre comienza por C, junto a todas
sus canciones, ordenadas por álbum y por duración.
```sql
select * 
from Playlist join PlaylistTrack on(Playlist.PlaylistId= PlaylistTrack.PlaylistId)
join Track on(PlaylistTrack.TrackId=Track.TrackId)
where Playlist.Name like "c%" order by Track.AlbumId  and Track.Milliseconds asc ;

```

### Query 11
Para esta query necesitamos también trabajar con lqs claves que coinciden en las tablas Customer y tabla Invoice. Buscaremos dentro de estás tablas aquellas totales que superen los 10 euros y los ordenaremos por el apellido de Customer de a-z.
```sql
select Customer.CustomerId, Customer.LastName, Invoice.Total
from Customer join Invoice on (Customer.CustomerId =Invoice.CustomerId)
where Invoice.Total > 10
order by Customer.LastName asc;
```
### Query 12
```sql
Con la siguiente query estamos obteniendo el pago más bajo, el más alto y un promedio de pagos que se encuentran en la tabla Invoice. 

SELECT min(total), max(total), avg(total) 
FROM invoice;
```
### Query 13
En la siguiente query hacemos un conteo de los artistas  que aparecen 
```sql
select count(*)
from Artist;
```
### Query 14

```sql
select count(Track.Name)
from Album join Track 
on(Album.AlbumId= Track.AlbumId)
where Album.Title like "Out Of Time";
```
### Query 15
Trabajando cona tabla Customer realizaremos un conteo evitando repeticiones de los países que en este caso son clientes. 
```sql
select count( DISTINCT Country)
from Customer 
```
### Query 16
realizaremos un conteo de Nombre de Track 
```sql
select count(Track.Name)
from Track join Genre on (Track.GenreId=Genre.GenreId)
where (select * from Genre where id)

```
### Query 17
```sql
use Chinook;
select count(Track.TrackId), Album.Title
from Album join Track on (Album.AlbumId = Track.AlbumId)
group by Title order by count(Track.TrackId) desc;
```

### Query 18

```sql
select Genre.GenreId, Genre.Name, count(*)
from Track join InvoiceLine
on (Track.TrackId = InvoiceLine.TrackId)
join Genre on (Track.GenreId=Genre.GenreId)
group by Genre.Name, Genre.GenreId order by count( *) desc;
```
### Query 19

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
Mostraremos 
Haremos la unión en esta ocasión de las tablas Customer con la tabla Invoice y está última con la tabla InvoiceLine lo haremos mediante los idCustomer propio en Customer y foráneo en Invoice, así como idIvoice siendo primario en tabla Invoice y foráneo en InvoiceLine. De esta manera limitaremos el resultado obtenido a aquellos quienes coinciden los ID nombrados. Posteriormente agruparemos el resultado según los países que han comprado. Realizaremos además, un conteo del idCliente para saber cuántos clientes hay sin que se repitan. Finalmente los ordenaremos de forma descendente y limitaremos el resultado a 5 filas 
```sql
SELECT Customer.Country, COUNT(DISTINCT Customer.CustomerId) AS "Número de clientes"
FROM Customer 
JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId
JOIN InvoiceLine ON Invoice.InvoiceId = InvoiceLine.InvoiceId
GROUP BY customer.Country
ORDER BY COUNT(DISTINCT Customer.CustomerId) DESC, Customer.Country limit 5;
```

