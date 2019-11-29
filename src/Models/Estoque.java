package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import interators.ArrayListInterator;
import interfaces.Iterator;
import interfaces.Observer;
import interfaces.Subject;

public class Estoque implements Subject   {
	
	private static Estoque instancia = new Estoque();
	private ArrayList<Produto> estoque = new ArrayList<Produto>();
	private List<Observer> observers = new ArrayList<>();
			
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
				throw new NoSuchElementException("Não há esse Produto no Estoque");
			}
		}
		
		
	}

	@Override
	public void registrarObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removerObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notificar() {
		for (Observer observer : observers) {
			observer.atualizar(this);
		}
	}
	





}
