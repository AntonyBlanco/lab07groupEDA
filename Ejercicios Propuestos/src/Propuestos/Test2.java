package Propuestos;
public class Test2 {
	public static void main(String[] args) {
		System.out.println("Pruebas de Implementación de HashTable");
		HashTableClass tabla = new HashTableClass(10);
		System.out.println(tabla.size());
		String cad ="dos";
		int prueba= cad.hashCode();
		System.out.println(prueba%10);
		System.out.println(tabla.put("uno", 1));
		System.out.println(tabla.put("dos", 2));
		System.out.println(tabla.put("tres", 3));
		System.out.println(tabla.get("uno"));
		System.out.println(tabla.get("dos"));
		System.out.println(tabla.size());
		tabla.clear();
		System.out.println(tabla.get("uno"));
		System.out.println(tabla.get("dos"));
		System.out.println(tabla.size());
	
	}
	
}