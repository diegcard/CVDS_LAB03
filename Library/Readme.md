# Laboratorio 3

# Integrantes

## Sebastian Cardona
## Diego Alexander

Este es el laboratorio 3 de la asignatura CVDS. En este laboratorio, los estudiantes Sebastian Cardona Parra y Diego Alexander trabajaron juntos para implementar y probar casos de prueba en una libreria.

## Implementación

Hasta el momento, se han creado los casos de prueba para el código de la clase Library, pero aún no se ha implementado la funcionalidad completa. Durante las pruebas, se ha identificado que el código actual presenta fallos.

![alt text](image.png)

Continuaremos trabajando en la implementación y solución de los errores encontrados.


### Una vez hecha la implementación del código

Ya realizamos la implementacion de los métodos de la clase Library, una vez compilado de nuevo el codigo, los testeos pasaron sin problema

![alt text](image-1.png)

### Luego vamos a implemantar Jacoco 

Relizamos la instaalcion en el pom.xml para que se integre como plugin y hacemos unas pequeñas correciones, despues lo que se hace es ejecutar mvn package y luego mvn test, despues ejecutamos el codigo mvn jacoco:resport y esto nos dara una carpeta llamada site en target y la agrimos y nos da los siguientes datos

![img.png](img.png)

Como se puede apreciar en la imagen la cobertura de los testeos respecto a todas la clases que tenemos esta por encima de un 80% lo cual es lo solicitado en el respectivo laboratorio

Como se puede apreciar en la imagen anterior, el unico metodo que no tiene testeos es la Clase App.java la cual no se el implementa ningun metodo por el momento

