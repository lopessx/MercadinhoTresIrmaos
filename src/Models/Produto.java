package Models;

public class Produto {

	private int cod_barras;
	private String nome, descricao;
	private float preco_unitario;
	private int quantidade;
	
	
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

	
	public Object getNome1() {
		return nome;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_barras;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto outro = (Produto) obj;
		if (cod_barras != outro.cod_barras)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return this.getCod_barras() + this.getNome() + this.getDescricao() + this.getPreco_unitario() + this.getQuantidade();
	}
	
	
}
