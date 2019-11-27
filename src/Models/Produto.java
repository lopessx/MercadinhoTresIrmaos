package Models;

import java.util.ArrayList;

public class Produto {

	private int cod_barras;
	private String nome, descricao;
	private float preco_unitario;
	private int quantidade;
	
	ArrayList<Produto> Estoque;
	
	public Produto() {
		Estoque = new ArrayList();
	}
	
	
	
	public Produto(int cod_barras, String nome, String descricao, float preco_unitario, int quantidade) {
		super();
		this.cod_barras = cod_barras;
		this.descricao = descricao;
		this.preco_unitario = preco_unitario;
		this.quantidade = quantidade;
		this.nome = nome;
	}


	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCod_barras() {
		return cod_barras;
	}
	public void setCod_barras(int id) {
		this.cod_barras = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(float preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void addProdEstoque (Produto p){
		
		Estoque.add(p);
	}



	
	public Object getNome1() {
		return nome;
	}
	
	
	
}
