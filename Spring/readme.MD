# Spring boot services y config server

Config server y servicios en spring boot

## Requirements

For building and running the application you need:

- [JDK 17](https://www.azul.com/downloads/?package=jdk)
- [Maven 3](https://maven.apache.org)

## Levantando los servicios de manera local

Para correr los servicios localmente es necesario levantar primero el configserver.

Actualmente utilizan las siguientes DB:

- [Prices](https://github.com/LeanBaier/backend-matrix/tree/main/Spring/prices): Utiliza una base en memoria MongoDB
- [Products](https://github.com/LeanBaier/backend-matrix/tree/main/Spring/products): Utiliza una base H2, la generacion de las tablas se hacen desde las entidades.

El config server esta levantando los archivos de configuracion desde [aca](https://github.com/LeanBaier/backend-matrix/tree/main/Spring/config.server.files).

* 