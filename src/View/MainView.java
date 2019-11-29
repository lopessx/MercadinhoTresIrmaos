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
		
		ArrayList<Produto> produto = estoque.getEstoque();

		/*
		 * To do
		 * 
		 * compra funcionando normalmente, strategy funcionando, falta testar o observer
		 * revisar a classe de estoque que não está salvando
		 * terminar de fazer a view, falta implementar a consulta
		 * remoção e adição estão parcialmente implementadas precisando só rever os métodos da classe Estoque
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
				
				 
				
				compra.setPrecoTotal(produto.get(temp).getPreco_unitario() * qtd);
				System.out.println("Insira o valor que será pago");
				double valor = scn.nextDouble();
				System.out.println("1 para Dinheiro || 2 para Débito || 3 para Crédito");
				int tipoPagamento = scn.nextInt();
				compra.setPagamento(tipoPagamento);
				
				compra.pagar(valor, compra);
				break;
				
			case 2:
				System.out.println("Digite o codigo de barras");
				int codBarras = scn.nextInt();
				System.out.println("Digite o nome do produto");
				String nome = scn.next();
				System.out.println("Digite a descrição do produto");
				String desc = scn.next();
				System.out.println("Digite o preço unitário do produto");
				float prec = scn.nextFloat();
				System.out.println("Digite a quantidade em estoque");
				int qtdEstq = scn.nextInt();
				//possível problema na classe Estoque, talvez o add e o remove precisem ser implementados de forma diferente?
				estoque.addDoEstoque(new Produto(codBarras,nome,desc,prec,qtdEstq));
				System.out.println("Produto adicionado com sucesso");
				break;
			
			case 3:
				System.out.println("Digite o codigo de barras do produto que deseja retirar do estoque");
				codBarras = scn.nextInt();
				ArrayList<Produto> pr = estoque.getEstoque();
				pr.remove(codBarras);
				break;
			
			case 4:
				int c =0;
				pr = estoque.getEstoque();
				System.out.println("cod_barras || nome || desc || preco_unit || estoque");
				//Fazer uma forma de printar todos os produtos do estoque
				while(pr.size() > c) {
					System.out.println(pr.get(c).toString());
				}
				break;
			

			}
			
				
			
		}while(aux != 6);

	}

}
