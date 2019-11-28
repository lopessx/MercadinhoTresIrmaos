package Models;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import interators.ArrayListInterator;
import interfaces.Iterator;

public class Estoque  {
	
	private static Estoque instancia = new Estoque();
	private ArrayList<Produto> estoque = null;
			
	private Estoque() {
		this.estoque  = new ArrayList<Produto>();
	}

	public static Estoque getInstancia() {
		return instancia;
	}

	public ArrayList<Produto> getEstoque() {
		return estoque;
	}
	
	public void addDoEstoque(Produto object) {
		
		Produto aux = null;
		
		Iterator<Produto> iterator = new ArrayListInterator<Produto>(estoque);
		
		while (iterator.hasNext()) {
			aux = iterator.next();
			
			if (aux.equals(object)) {
				aux.setQuantidade(aux.getQuantidade() + object.getQuantidade());
			} else {
				estoque.add(object);
			}
		}
	}
	
	public void removeDoEstoque(Produto object) {
		
		Produto aux = null;
		
		Iterator<Produto> iterator = new ArrayListInterator<Produto>(estoque);
		
		while (iterator.hasNext()) {
			aux = iterator.next();
			
			if (aux.equals(object)) {
				if(aux.getQuantidade() == object.getQuantidade()) {
					estoque.remove(object);
				} else {
					aux.setQuantidade(aux.getQuantidade() - object.getQuantidade());
				}
			} else {
				throw new NoSuchElementException("N�o h� esse Produto no Estoque");
			}
		}
		
		
	}
	

}
