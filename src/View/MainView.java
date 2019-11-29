package View;

import java.util.Scanner;

import Models.Compra;
import Models.Estoque;
import Models.Produto;

public class MainView {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		Estoque estoque = Estoque.getInstancia();
		Compra compra = new Compra();
		int aux = 0;
		Produto p1 = new Produto(1,"Fuba","Flocao",1,13);
		estoque.addDoEstoque(p1);
		estoque.getEstoque().get(0).getCod_barras();
		
		do {
			
			System.out.println("1 para fazer uma compra");
			System.out.println("2 para adicionar um produto ao estoque");
			System.out.println("3 para remover um produto do estoque");
			System.out.println("4 para consultar o estoque");
			System.out.println("6 para sair");
			aux = scn.nextInt();
			
			switch(aux) {
			
			case 1:
				System.out.println("Digite o codigo de barras do produto");
				int temp = scn.nextInt();
				System.out.println("Digite a quantidade de produtos que irá ser comprado");
				int qtd = scn.nextInt();
				
				Produto produto = new Produto(0,"-1","-1",0,0);
				produto = estoque.getEstoque().get(temp);
				compra.setPrecoTotal(produto.getPreco_unitario() * qtd);
				System.out.println("Insira o valor que será pago");
				double valor = scn.nextDouble();
				System.out.println("1 para Dinheiro || 2 para Débito || 3 para Crédito");
				int tipoPagamento = scn.nextInt();
				compra.setPagamento(tipoPagamento);
				
				compra.pagar(valor, compra);
				break;
			
			
			}
			
		}while(aux != 6);

	}

}
