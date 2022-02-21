## title: Prueba tecnica Certicamara
## author: Angela Monsalve
## date: [2022-02-21]

Este proyecto es una aplicación en Spring Boot que se conecta al siguiente servicio externo REST.
https://ghibliapi.herokuapp.com/people

Este servicio devuelve una lista de personajes de Anime con sus respectivos datos.

Esta aplicación manipula los datos recibidos del servicio externo y los retorna ya depurados al usuario, como respuesta a una petición Get que este realiza.

Además cada vez que realiza esta consulta, guarda en una tabla de una base de datos un registro con fecha y hora de la consulta.

Las tecnologías revisadas y que se usaron para este proyecto son:

- IDE  - IntelliJ
- lenguaje de Programación  -Java
- Motor de base de datos - PostgresQL
- Infraestructura -SpringBoot
- PAAS - Heroku

## Configuración de la base de datos

La base de datos se encuentra desplegada en heroku.


## Ejecutando el proyecto

Para probar la funcionalidad de la aplicación se debe acceder al siguiente enlace:

