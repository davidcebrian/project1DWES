package com.rpgame.repositorys;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rpgame.entity.Personaje;


@Repository(value = "personajeRepository")
public interface PersonajeRepository extends CrudRepository<Personaje, Long>{
	public  Personaje findPersonajeByName(String Name);
	
	public Personaje findPersonajeByIdPersonaje(Long idPersonaje);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update Personaje p set p.name = :newPjName where p.idPersonaje = :idPersonaje")
	public void updatePersonaje(Long idPersonaje, String newPjName);

	@Modifying(clearAutomatically = true)
	@Query(value="select personajes from User u  where u.idUsuario = :user")
	public List<Personaje> getPersonajesUser(Long user);
	
	@Query(value = "select * from Personaje order by poder", nativeQuery = true)
	public List<Personaje> findAllOrderedByPoder();
}
