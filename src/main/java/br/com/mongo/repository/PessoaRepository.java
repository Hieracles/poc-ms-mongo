package br.com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mongo.domain.PessoaDomain;

public interface PessoaRepository extends MongoRepository<PessoaDomain, String> {

}
