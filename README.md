# Notas de implementación

Con respecto a la base de datos de registros de ADN, siguiendo los principios [KISS](https://es.wikipedia.org/wiki/Principio_KISS) y [YAGNI](https://es.wikipedia.org/wiki/YAGNI), y para evitar sobre ingeniería sobre un requerimiento que no se presenta del todo claro, se optó por realizar **la cosa más simple que pudiera funcionar**. Por lo tanto se implementó utilizando un `Map` y se dejó de lado la opción de utilizar una base de datos SQL o NoSql.

# Instrucciones

## Cloud API Rest

En la nube se puede encontrar la api rest deployada en los siguientes endpoints:

http://mutant-detector-meli.193b.starter-ca-central-1.openshiftapps.com/mutant

http://mutant-detector-meli.193b.starter-ca-central-1.openshiftapps.com/stats

## Construir el proyecto

`~/ejercicio-meli $ mvn clean install`

## Ejecución del servicio en modo standalone

Ejecutar el comando `java -jar ejercicio-meli-controller-1.0.0-SNAPSHOT-exec.war`

El war se encuentra en `/ejercicio-meli/ejercicio-meli-controller/target/`

## Ejecución en servlet container

Deployar el war generado que se encuentra en la capeta `target`, en cualquier servlet container.

## API Rest

Se puede encontrar la api rest deployada en los siguientes endpoints:

http://localhost:8080/mutant

http://localhost:8080/stats

