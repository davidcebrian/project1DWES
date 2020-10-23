package com.rpgame.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rpgame.entity.Ataque;

@Repository(value = "ataqueRepository")
public interface AtaqueRepository extends CrudRepository<Ataque, Long>{

}
