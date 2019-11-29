package comportamentos;

import Models.Compra;
import interfaces.Pagamento;

public class PagamentoDinheiro implements Pagamento {

	public PagamentoDinheiro() {
		// TODO Auto-generated constructor stub
	}
	
	public void pagar(double valor, Compra compra) {
		
		double troco = valor - compra.getPrecoTotal();
		if(troco < 0) {
			System.out.println("Valor insuficiente");
		}else {
			System.out.println("Troco = " + troco);
		}
		
	}
	
}
