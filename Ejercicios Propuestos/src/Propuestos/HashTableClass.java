package Propuestos;

import java.util.ArrayList;

public class HashTableClass  implements HashTable{
	
	Node [] arrayHash;
	int sizeTable;
	int spaceCompleted=0;
	
	
	public HashTableClass(int sizeTable) {
		this.sizeTable=sizeTable;
		arrayHash = new Node[sizeTable];
		for (int i = 0; i < sizeTable; i++) {
			arrayHash[i]=new Node();
			
		}
	}

	@Override
	public int size() {
		if (spaceCompleted==0) {
			return 0;
		}
		return spaceCompleted;
	}

	@Override
	public boolean isEmpty() {
		if (this.sizeTable==0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

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

	@Override
	public Integer remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		for (int i = 0; i < arrayHash.length; i++) {
			arrayHash[i].next=null;
			spaceCompleted--;
		}
		
	}
	
	@Override
    public int hashCode() {
		final int prime = this.sizeTable;
		
		int resultado= 0;
		return resultado;
	}
    

    public String toString() {
		return null;
	}
    
//    public int GetHash(int key) {
//    	return key%sizeTable;
//    }
 
    
}