package com.rpgame.repositorys;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rpgame.entity.User;


@Repository(value = "userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

	public  User findUserByUserName(String userName);
	

	public User findUserByName(String name);
	
	
	public User findUserByIdUsuario(Long idUsuario);
	
	@Modifying(clearAutomatically = true)
	@Query(value="update User u set u.userName = :newUserName where u.idUsuario = :idUsuario")
	public User updateUser(Long idUsuario, String newUserName);
	
	@Query(value = "select * from User order by name", nativeQuery = true)
	public List<User> findAllOrderedByName();
}

