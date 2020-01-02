package br.com.mongo.dto;

public class Erro {
	
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Erro(String mensagem) {
		super();
		this.mensagem = mensagem;
	}
	
	public Erro() {
		
	}
	
	
	

}
