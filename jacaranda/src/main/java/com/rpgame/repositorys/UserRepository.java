package com.rpgame.repositorys;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rpgame.entity.User;


@Repository(value = "userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

}
