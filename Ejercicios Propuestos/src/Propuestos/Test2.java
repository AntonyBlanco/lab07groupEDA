package Propuestos;
<<<<<<< HEAD
//pruebas de la implememtacion de HasTable
public class Test2 {
	public static void main(String[] args) {
	System.out.println("pruebas de Implementación");
=======
public class Test2 {
	public static void main(String[] args) {
		System.out.println("Pruebas de Implementación de HashTable");
		HashTableClass tabla = new HashTableClass(10);
		System.out.println("Numero de elementos antes de agregar elementos: " + tabla.size());
		//String cad ="dos";
		//int prueba= cad.hashCode();
		//System.out.println(prueba%10);
		tabla.put("uno", 1);
		tabla.put("dos", 2);
		tabla.put("tres", 3);
		System.out.println(tabla.get("uno"));
		System.out.println(tabla.get("dos"));
		System.out.println(tabla.get("tres"));
		System.out.println("Numero de elementos despues de agregar elementos: " +tabla.size());
		tabla.clear();
		System.out.println(tabla.get("uno"));
		System.out.println(tabla.get("dos"));
		System.out.println("Numero de elementos despues de quitar todos los elementos de la tabla:  " +tabla.size());
>>>>>>> echecalla
	}
}
