package com.rpgame.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.rpgame.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

	public Document findDocumentById(Long id);

}
