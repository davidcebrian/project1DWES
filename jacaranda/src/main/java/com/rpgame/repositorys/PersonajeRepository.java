package com.rpgame.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rpgame.entity.Personaje;

@Repository(value = "personajeRepository")
public interface PersonajeRepository extends CrudRepository<Personaje, Long>{

}
