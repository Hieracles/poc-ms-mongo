package br.com.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mongo.domain.PessoaDomain;
import br.com.mongo.repository.PessoaRepository;

@Service
public class PessoaService {
	
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<PessoaDomain> listar(){
		
		return pessoaRepository.findAll(); 
		
	}
	
	public PessoaDomain inserir(PessoaDomain p){
		pessoaRepository.insert(p);			
		return p;
	}
	
	public PessoaDomain alterar(PessoaDomain p){
		pessoaRepository.save(p);			
		return p;
	}
	
	public void excluir(String codigo){
		pessoaRepository.deleteById(codigo);			
	}	
	
}
