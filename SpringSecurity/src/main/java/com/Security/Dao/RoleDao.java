package com.Security.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Security.Entity.Role;


public interface RoleDao extends CrudRepository<Role, String> {

}
