# lab04groupEDA
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Guía de Práctica de Laboratorio / Talleres / Centros de Simulación</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>
<div align="center">
    <span style="font-weight:bold;"><h2>INFORME DE LABORATORIO 7</h2></span>
</div>


<table>
<theader>
    <tr><th colspan="6" style="width:50%; height:auto; text-align:center">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
    <tr>
        <td>ASIGNATURA:</td><td colspan="5">Estructuras de Datos y Algoritmos</td>
    </tr>
    <tr>
        <td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Hashing</td>
    </tr>
    <tr>
        <td>NÚMERO DE PRÁCTICA:</td><td>07</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
    </tr>
    <tr>
        <td colspan="2">FECHA DE PRESENTACIÓN:</td><td>07-Agosto-2022</td><td colspan="2">HORA DE PRESENTACIÓN:</td><td>11:55</td>
    </tr>
    <tr>
        <td colspan="3">INTEGRANTES:
        <ol>
        <li>Blanco Trujillo, Antony Jacob</li>
        <li>Checalla Soto, Edisson Franklin</li>
        <li>Vilca Suelo, Gionvanni Gabriel</li>
        </ol>
        </td>
        <td colspan="2"> NOTA:</td>
        <td>     </td>
    </tr>
    <tr>
        <td colspan="6">DOCENTE:<br>
        Mg. Richart Smith Escobedo Quispe
        </td>
    </tr>
</table>

#
<div align="center">
    <span style="font-weight:bold;"><h2>I. SOLUCIÓN Y RESULTADOS </h2></span>
</div>

#
## EJERCICIO

Implementar una tabla hash en base a los métodos definidos en la interfaz del archivo HashTable.java. - Enlace a código en GitHub : [Ver Código HashTable.java](https://github.com/AntonyBlanco/lab07groupEDA/blob/echecalla/Ejercicios%20Propuestos/src/Propuestos/HashTable.java)

-   Deben contemplar como mínimo el desarrollo de todos los métodos en su clase.
-   Deben manejar las colisiones por Encadenamiento (Lista enlazada) y Sondeo Lineal.
-   Es posible agregar otros métodos que les ayuden a su resolución.
-   Crear un archivo de test donde incluyen casos de prueba.

#

## ¿Como puedo compilar correctamente este ejercicio?

Despúes de clonar este repositorio, para poder ejecutar el código sin dificultad es recomendable que se ejecute desde el IDE eclipse, pues su desarrollo se dio en este,y por ello mismo es que se subieron tambien los archivos necesarios para ejecutarse ahí. Tenemos 2 clases principales, la primera es la proporcionada por el docente.
Tenemos tambien clases (Test1, Test2, Test3) para probar los códigos implementados (Implementaciones asigandas a cada miembro del grupo).


- Enlace a código en GitHub : [Ver Código clase HashTableClass ](https://github.com/AntonyBlanco/lab07groupEDA/blob/echecalla/Ejercicios%20Propuestos/src/Propuestos/HashTableClass.java)


- Enlace a código en GitHub : [Ver Código Test](https://github.com/AntonyBlanco/lab07groupEDA/blob/echecalla/Ejercicios%20Propuestos/src/Propuestos/Test2.java)

## ¿Como lo hicimos?

Tras un analisis de como abordar el ejercicio es que obtuvimos como primera premisa, añadir una clase  [HashTableClass.java ](https://github.com/AntonyBlanco/lab07groupEDA/blob/echecalla/Ejercicios%20Propuestos/src/Propuestos/HashTableClass.java) como solución obvia a la implementacion de la interface [hashTable.java](https://github.com/AntonyBlanco/lab07groupEDA/blob/echecalla/Ejercicios%20Propuestos/src/Propuestos/HashTable.java).

Añadimos tambien la clase  [Nodo.java](https://github.com/AntonyBlanco/lab07groupEDA/blob/echecalla/Ejercicios%20Propuestos/src/Propuestos/Node.java), esto a modo de dar solución a almacenar un objeto con una clave y valores. En sus atributos notamos lo propuesto:

```sh 
    String key;
	Object value;
	Node next;
```

Añadimos tambien los correspondientes getters.

La idea es que mediante un arreglo de nodos (que será atributo de la clase HashTableClass.java) se pueda ir almacenando las claves y valores. A fin de facilitar un poco la tarea usamos un arreglo, y con ello damos pie a que el usuario pueda definir el  tamaño de la tablaHash.

```sh 
	Node [] arrayHash;
	int sizeTable;
	int spaceCompleted=0;
```
	
El atributo sizeTable almacenara el tamaño del arreglo (tamaño de la tabla de Hash)

el atributo spaceCompleted será usado como contador de cuan lleno esta la tabla de hash.

El constructor de la tabla Hash tiene la caracteristica de solicitar en su argumento el tamaño de la tabla. Además mediante un bucle for vamos a ir rellenando los espacios del arreglo en los nodos de alamacenaje, asi tenemos:

```sh 
	public HashTableClass(int sizeTable) {
		this.sizeTable=sizeTable;
		arrayHash = new Node[sizeTable];
		for (int i = 0; i < sizeTable; i++) {
			arrayHash[i]=new Node();
			
		}
	}
```

## Empezamos a implementar los metodos propuestos:

#
##  Método:    int size();

-   Implementación

Este metodo requiere de poder saber cuantos espacios de la tabla estan rellenos, por ello vamos a hacer uso del contador spaceCompleted (el que va acrecentandoce al usar el metodo Put() que se detallará más adelante.


```sh 
		if (spaceCompleted==0) {
			return 0;
		}
		return spaceCompleted
```
Vemos que hacemos uso de una estructura condicional simple de entender.
#
## Método: boolean isEmpty();

-   Implementación

Este metodo requiere poder determinar si una tabla esta vacia o no, para ello y ya que limitamos el constructor de HashTable solo necescitamos comprobar si el atributo sizeTable es igual a 0. Entonces:

```sh 
		if (this.sizeTable==0) {
			return true;
		}
		return false;
```


#
## Método: Integer get(String key);

   Implementación

```sh 
	@Override
	public Integer get(String key) {
		Integer value=null;
		int hashIndex= key.hashCode()&sizeTable;
		Node ArrayValue= arrayHash[hashIndex];
		while(ArrayValue!=null) {
			if(ArrayValue.getKey()==key) {
				value= (Integer) ArrayValue.getValue();
				break;
			}
			ArrayValue=ArrayValue.next;
		}
		
		return value;
	}
```

#
## Método: Integer put(String key, Integer value);

   Implementación


```sh 
	@Override
	public Integer put(String key, Integer value) {
		int hashIndex= key.hashCode()&sizeTable;
		Node ArrayValue= arrayHash[hashIndex];
		Node newItem= new Node(key, value);
		newItem.next=ArrayValue.next;
		ArrayValue.next=newItem;
		spaceCompleted++;
		return null;
	}
```


#
## Método: void clear();

   Implementación

```sh 
	@Override
	public void clear() {
		for (int i = 0; i < arrayHash.length; i++) {
			arrayHash[i].next=null;
			
		}
		spaceCompleted=0;
	}
```

#
## Método:  int hashCode();

   Implementación

```sh 
	
	@Override
    public int hashCode() {
		int suma=0;
		for (int i = 0; i < arrayHash.length; i++) {
			if(arrayHash[i].next!=null) {
				suma=suma+i;
			}else {
				continue;
			}
				
		}
		return suma;
	}
```
#
## Ejecucion:

Para la ejecución hacemos uso de una clase extra denominada Test. ahi es donde probaremos las implementaciones.

Primero intanciamos un objeto de tipo HastTableClass. de tamaño 10

```sh 
	HashTableClass tabla = new HashTableClass(10);
```

Posteriormente agregamos elementos y sus respectivas claves:

```sh 
		tabla.put("uno", 1);
		tabla.put("dos", 2);
		tabla.put("tres", 3);
```

ahora tambien podemos buscar y/o mostrar el contenido de una determinada clave. asi:

```sh 
		System.out.println(tabla.get("uno"));
		System.out.println(tabla.get("dos"));
		System.out.println(tabla.get("tres"));
```
El resto de metodos(size, clear y isEmpty) tambien seran implementados:

```sh 
		System.out.println("Numero de elementos despues de agregar elementos: " +tabla.size());
		System.out.println(tabla.hashCode());
		tabla.clear();
		System.out.println(tabla.get("uno"));
		System.out.println(tabla.get("dos"));
		System.out.println("Numero de elementos despues de quitar todos los elementos de la tabla:  " +tabla.size());
```


## En la Consola:


<div align="center">

![Ejecucion](Capturas%20de%20Resolucion/consola.png)
</div>

#
<div align="center">
    <span style="font-weight:bold;"><h2>CONCLUSIONES </h2></span>
</div>

-   Es factible poder implementar una tabla de hash con los conocimientos previos que teniamos. 
-   la funcion de hashing para cadenas resultó compleja, pero con un poco de imaginación logramos reducirlo a una propuesta más simple, pero eficaz.   


#
<div align="center">
    <span style="font-weight:bold;"><h2>RETROALIMENTACIÓN </h2></span>
</div>

#

-   

#
<div align="center">
    <span style="font-weight:bold;"><h2>REFERENCIAS Y BIBLIOGRAFÍA </h2></span>
</div>

#

-   https://www.w3schools.com/java/
-   https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers
-   https://lineadecodigo.com/java/usar-una-hashtable-java/
-   https://es.frwiki.wiki/wiki/Java_hashCode()
