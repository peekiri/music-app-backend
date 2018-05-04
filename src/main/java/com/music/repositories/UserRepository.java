package com.music.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.music.entities.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long>{

	public int countByEmailAddress(String emailAddress);

	public int countByUserName(String userName);

}
