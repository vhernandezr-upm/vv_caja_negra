# Verificación y Validación del Software 2021
GRUPO IWT-41 ``<- Modificar``

## Instrucciones para importar este proyecto en INTELLIJ
* Primero hay que clonar este repositorio, ya sea mediante el propio IntelliJ o con la terminal.
* Una vez abierto el proyecto, nos vamos al menú **Run > Run... > Edit Configurations**.
* Si no existe ya, en el botón + de arriba a la izquierda añadimos una configuración Maven.
* En la caja de texto "Command line" tenemos que escribir la configuración que necesita Maven para localizar la biblioteca SingleList.jar:
  `install:install-file -Dfile=lib/SingleList.jar -DgroupId=com.singleList -DartifactId=SingleList -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar`
* Es posible que en sistemas operativos Windows haya que cambiar las barras de ruta "/" de -Dfile por barras invertidas "\". 
* A continuación, le damos al botón **Run** para aplicar la configuración.
* El proyecto ya está listo para ser utilizado.

## Instrucciones para utilizar este proyecto

* Cada alumno debe crearse un usuario de Github
* Un miembro del grupo debe hacer fork a este proyecto y añadir al repositorio forkeado a sus compañeros de grupo y al profesor como colaboradores.
* Descargar el proyecto utilizando git clone desde el terminal o desde el IDE.
* Seguir las indicaciones del enunciado para añadir las dependencias necesarias para empezar a realizar las pruebas
* Modificar este fichero añadiendo el número de grupo correspondiente y las instrucciones para ejecutar la práctica
