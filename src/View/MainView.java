package View;

import java.util.ArrayList;
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
		
		estoque.registrarObserver(compra);
		
		Produto p1 = new Produto(0,"fuba","flocao",1,10);
		Produto p2 = new Produto(1,"arroz","ruim",2,5);
		
		estoque.addDoEstoque(p1);
		estoque.addDoEstoque(p1);
		estoque.addDoEstoque(p2);

		/*
		 * To do
		 * 
		 * 
		 * revisar a classe de estoque que está salvando de maneira errada
		 * 
		 * */
		
		do {
			System.out.println("========================================================================");
			System.out.println("1 para fazer uma compra");
			System.out.println("2 para adicionar um produto ao estoque");
			System.out.println("3 para remover um produto do estoque");
			System.out.println("4 para consultar o estoque");
			System.out.println("6 para sair");
			System.out.println("========================================================================");
			aux = scn.nextInt();
			
			switch(aux) {
			
			
			
			case 1:
				System.out.println("Digite o codigo de barras do produto");
				int temp = scn.nextInt();
				System.out.println("Digite a quantidade de produtos que irá ser comprado");
				int qtd = scn.nextInt();
				
				Produto produto = estoque.getEstoque().get(temp);
				
				compra.setPrecoTotal(produto.getPreco_unitario() * qtd);
				System.out.println("Insira o valor que será pago");
				double valor = scn.nextDouble();
				System.out.println("1 para Dinheiro || 2 para Débito || 3 para Crédito");
				int tipoPagamento = scn.nextInt();
				compra.setPagamento(tipoPagamento);
				
				compra.pagar(valor, compra);
				
				produto.setQuantidade(produto.getQuantidade() - qtd);
				compra.atualizar(estoque);
				break;
				
			case 2:
				System.out.println("Digite o nome do produto");
				String nome = scn.next();
				System.out.println("Digite a descrição do produto");
				String desc = scn.next();
				System.out.println("Digite o preço unitário do produto");
				float prec = scn.nextFloat();
				System.out.println("Digite a quantidade em estoque");
				int qtdEstq = scn.nextInt();
				//possível a partir do terceiro produto adicionado o estoque adiciona 2 produtos de uma vez, além da quantidade estar sendo maior que a colocada
				estoque.addDoEstoque(new Produto(estoque.getEstoque().size(),nome,desc,prec,qtdEstq));
				System.out.println("Produto adicionado com sucesso");
				break;
			
			case 3:
				System.out.println("digite o codigo de barras"); 
				int codBarras = scn.nextInt();
				Produto pTemp = estoque.getEstoque().get(codBarras);
				estoque.removeDoEstoque(pTemp);
				System.out.println("Produto removido com sucesso " + estoque.getEstoque().size());
				break;
			
			case 4:
				int c =0;
				 
				System.out.println("cod_barras || nome || desc || preco_unit || estoque");
				 
				while(estoque.getEstoque().size() > c) {
					System.out.println( estoque.getEstoque().get(c).getCod_barras() + " || " +estoque.getEstoque().get(c).getNome() + " || " + estoque.getEstoque().get(c).getDescricao() + " || " + estoque.getEstoque().get(c).getPreco_unitario() + " || " + estoque.getEstoque().get(c).getQuantidade());
					c++;
				}
				break;
			

			}
			
				
			
		}while(aux != 6);

	}

}
