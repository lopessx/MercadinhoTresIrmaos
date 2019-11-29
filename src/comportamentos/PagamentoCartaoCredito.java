package comportamentos;

import java.util.Scanner;

import Models.Compra;
import interfaces.Pagamento;

public class PagamentoCartaoCredito implements Pagamento {
	
	public PagamentoCartaoCredito() {
		// TODO Auto-generated constructor stub
	}
	
public void pagar(double valor, Compra compra) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Por favor insira o número do cartão");
		int numCartao = scn.nextInt();
		


			System.out.println("Compra aceita no valor de " + compra.getPrecoTotal() + " Cartão numero " + numCartao);
		
		
	}
	
}
