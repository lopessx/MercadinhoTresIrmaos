package Models;

import java.util.Calendar;

public class Compra {

	private Cliente cliente[];
	private Produto produto[];
	private float precoTotal;
	private Calendar dataVenda;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}


	
	

	public Cliente[] getCliente() {
		return cliente;
	}





	public void setCliente(Cliente[] cliente) {
		this.cliente = cliente;
	}





	public Produto[] getProduto() {
		return produto;
	}





	public void setProduto(Produto[] produto) {
		this.produto = produto;
	}





	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	
}
