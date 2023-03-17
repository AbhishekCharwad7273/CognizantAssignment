package com.Security.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Security.Entity.User;


public interface UserDao extends CrudRepository<User, String> {

}
