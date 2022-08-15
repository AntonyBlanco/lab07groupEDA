package Propuestos;

public class Node{
	String key;
	Object value;
	Node next;
	
	public Node(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public Node() {
		next=null;
	}

	public String getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}
}

