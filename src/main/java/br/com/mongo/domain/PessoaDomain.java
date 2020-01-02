package br.com.mongo.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document(collection = "pessoa")
@Getter
public class PessoaDomain {
	
	@Id
	private String _id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	
	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PessoaDomain(String _id, String nome, Date dataNascimento, String cpf) {
		super();
		this._id = _id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}
	
	public PessoaDomain() {
		
	}
	
}
