package interators;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import interfaces.Iterator;


public class ArrayListInterator<T> implements Iterator<T> {
	
	protected ArrayList<T> lista;
	private int count;
	
	public ArrayListInterator(ArrayList<T> list) {
		this.lista = list;
		this.count = 0;
	}

	@Override
	public boolean hasNext() {
		return count < lista.size();
	}

	@Override
	public T next() {
		T obj = null;
		try {
			obj = lista.get(count);
			count++;
		
			return obj;
			
		} catch (IndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
	}

}
