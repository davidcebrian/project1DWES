package com.rpgame.repositorys;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rpgame.entity.Ataque;


@Repository(value = "ataqueRepository")
public interface AtaqueRepository extends CrudRepository<Ataque, Long>{
	@Modifying(clearAutomatically = true)
	
	public Ataque findAtaqueByNombre(String nombre);
	
	public Ataque findAtaqueByIdAtaque(Long id);
	
	@Query(value="update Ataque a set a.nombre = :newNombre where a.idAtaque = :idAtaque")
	public Ataque updateAtaque(Long idAtaque, String newNombre);
}
