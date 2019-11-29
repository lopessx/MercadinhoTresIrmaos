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
		
		//Precisei colocar esse verificador se não ele não adiciona o primeiro produto
		while (iterator.hasNext()) {
			aux = iterator.next();
			
			if (aux.equals(object)) {
				if(aux.getCod_barras() == object.getCod_barras()) {
					object.setQuantidade(aux.getQuantidade() + object.getQuantidade());
					estoque.remove(object);
				}
				
			
			
			} 
		}
		if(iterator.hasNext() == false) {
			estoque.add(object);
		}else {
			estoque.add(object);
		}

		

		

	}
	
	
	public void removeDoEstoque(Produto object) {
		
		Produto aux = null;
		
		Iterator<Produto> iterator = new ArrayListInterator<Produto>(estoque);
		
		if(iterator.hasNext() == false) {
			estoque.remove(object);
		}
		
		while (iterator.hasNext()) {
			aux = iterator.next();
			
			if (aux.equals(object)) {
				estoque.remove(object);
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
