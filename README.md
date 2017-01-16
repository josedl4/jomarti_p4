# Practica 4 de Tecnologias para el Desarrollo de Software

#### Autor:
* Jose Luis Martín Martín  -    _jomarti_

#### Built With:
* [Maven](https://maven.apache.org/) - Dependency Management
* [Ant](http://ant.apache.org/) -  Automating software build processes
* [Eclipse](https://eclipse.org/) - IDE

#### Targets de Ant:
* **_ant compilar_** - Obtención de las dependencias y generación de los ficheros .class para la realización de los test.
* **_ant ejecutarTodo_** - Realizaremos la ejecución de todos los test.
* **_ant ejecutarTestsTDD_** - Ejecutar solo test de TDD y de caja negra (No valido en este caso, al no mantenerse los test de TDD en las siguientes fases).
* **_ant ejecutarTestEnAislamiento_** - Ejecutar test en asilamiento y de caja blanca.
* **_ant ejecutarPruebasSecuencia_** - Ejecutar test de secuencia.
* **_ant obtenerInformeCobertura_** - Obtener informe de cobertura
* **_ant medidas_** - Obtener complejidad ciclomática y ratio _code to test_.
* **_ant documentar_** - Generar documentación.
* **_ant limpiar_** - Limpiar el directorio del proyecto.

#### Estructura del proyecto:
* **_src_** - Fuentes del proyecto.
* **_lib_** - Dependencias de Maven.
* **_target_**
  * **_class_** - .class de las clases _Noticia_ y _Boletin_.
  * **_class-test_** - .class de los test.
  * **_site_** - Informes generados de cobertura y medidas.
    * _javancss_ - Informe de complejidad ciclomática.
    * _jacoco_ - Code To Test Ratio.
    * _cobertura_ - Informe de cobertura.
    
#### Otras aclaraciones:
* Los test TDD y de caja negra realizados en las fase Red del ciclo Red - Green - Refactor, no aparecen en la cabeza del repositorio ya que se eliminaron en la fase Green ya que todos los test que empleamos son en aislamiento debido al que estamos desarrollando solo una parte del problema y las pruebas están obligadas a depender de Mock Objects.
* El estado final de las fases correspondientes del ciclo Red - Green - Refactor, pueden verse en el ultimo commit de la rama correspondiente a dicha fase.
