package controle;

public class Carro {
	
	String link;
	String descricao;
	Double valor;
	
	public Carro(String link, String descricao, Double valor) {
		super();
		this.link = link;
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
