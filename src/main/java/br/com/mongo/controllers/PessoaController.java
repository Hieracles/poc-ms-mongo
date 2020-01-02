package br.com.mongo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.mongo.domain.PessoaDomain;
import br.com.mongo.service.PessoaService;

@RestController
@RequestMapping(path = "mongo/pessoas", produces = "application/json")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping()
	public ResponseEntity<List<PessoaDomain>> listar() throws TimeoutException, JsonParseException, JsonMappingException, IOException{
		return ResponseEntity.ok().body(pessoaService.listar());		
	}
	
	@PostMapping
	public ResponseEntity<PessoaDomain> inserir(@RequestBody PessoaDomain p){
		
		PessoaDomain retorno = pessoaService.inserir(p);		
		return ResponseEntity.ok().body(retorno);
		
	}
	
	@PutMapping(path="/{codigo}") 
	public ResponseEntity<PessoaDomain> alterar(@PathVariable("codigo") String codigo, @RequestBody PessoaDomain p) throws TimeoutException, JsonParseException, JsonMappingException, IOException{
		
		p.set_id(codigo);
		PessoaDomain retorno = pessoaService.alterar(p);		
		
		return ResponseEntity.ok().body(retorno);
		
	}
	
	@DeleteMapping(path="/{codigo}")
	public ResponseEntity<String> excluir(@PathVariable("codigo") String codigo) throws TimeoutException, JsonParseException, JsonMappingException, IOException{
		pessoaService.excluir(codigo);
		return ResponseEntity.ok().body("{\"mensagem\" : \"Pessoa excluída com sucesso!\"}");
	}

}
