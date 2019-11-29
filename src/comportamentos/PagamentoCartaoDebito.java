package comportamentos;

import java.util.Scanner;

import Models.Compra;
import interfaces.Pagamento;

public class PagamentoCartaoDebito implements Pagamento {

	public PagamentoCartaoDebito() {
		// TODO Auto-generated constructor stub
	}
	
public void pagar(double valor, Compra compra) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Por favor insira o número do cartão");
		int numCartao = scn.nextInt();
		
		
		double troco = valor - compra.getPrecoTotal();
		if(troco < 0) {
			System.out.println("Compra recusada cartão número: " + numCartao );
		}else {
			System.out.println("Compra aceita no valor de " + troco);
		}
		
	}
	
}
