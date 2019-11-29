package Models;

import comportamentos.PagamentoCartaoCredito;
import comportamentos.PagamentoCartaoDebito;
import comportamentos.PagamentoDinheiro;
import interfaces.Observer;
import interfaces.Pagamento;
import interfaces.Subject;

public class Compra implements Observer {

	
	private double precoTotal;
	private Pagamento pagamento;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	
	public double getPrecoTotal() {
		return precoTotal;
	}
	
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	public void pagar(double valor, Compra compra) {
		pagamento.pagar(valor, compra);
	}
	
	public void setPagamento(int tipoPagamento) {
		if(tipoPagamento == 1) {
			this.pagamento = new PagamentoDinheiro();
		}
		if(tipoPagamento == 2) {
			this.pagamento = new PagamentoCartaoDebito();
		}
		if(tipoPagamento == 3) {
			this.pagamento = new PagamentoCartaoCredito();
		}
	}

	@Override
	public void atualizar(Subject subject) {
		if(subject instanceof Estoque) {
			int aux = 0;
			Estoque estoque = (Estoque) subject;
			while(estoque.getEstoque().size() >  aux) {
				
			if(estoque.getEstoque().get(aux).getQuantidade() == 0){
				System.out.println("Estoque do produto " + estoque.getEstoque().get(aux).getNome() + " está em falta " + " codigo: " + estoque.getEstoque().get(aux).getCod_barras());
			}else if(estoque.getEstoque().get(aux).getQuantidade() < 10) {
				System.out.println("Estoque baixo do produto " + estoque.getEstoque().get(aux).getNome() + " codigo: " + estoque.getEstoque().get(aux).getCod_barras());
			}
			aux++;
			}
			
		}
		
	}
	
}
