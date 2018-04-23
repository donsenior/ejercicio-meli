# Instrucciones

## Construir el proyecto

`~/ejercicio-meli $ mvn clean install`

## Deploy

Deployar el war generado que se encuentra en la capeta `target`, en cualquier servlet container.

## API Rest

Se puede encontrar la api rest deployada en los siguientes endpoints:

http://localhost:8080/mutant

http://localhost:8080/stats

## Cloud API Rest

En la nube se puede encontrar la api rest deployada en los siguientes endpoints:

http://mutant-detector-meli.193b.starter-ca-central-1.openshiftapps.com/mutant

http://mutant-detector-meli.193b.starter-ca-central-1.openshiftapps.com/stats

# Notas de implementación

Con respecto a la base de datos de registros de ADN, siguiendo los principios [KISS](https://es.wikipedia.org/wiki/Principio_KISS) y [YAGNI](https://es.wikipedia.org/wiki/YAGNI), y para evitar sobre ingeniería sobre un requerimiento que no se presenta del todo claro, se optó por realizar ** la cosa más simple que pudiera funcionar**. Por lo tanto se implementó utilizando un `Map` y se dejó de lado la opción de utilizar una base de datos SQL o NoSql.