package com.Security.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Security.Dao.RoleDao;
import com.Security.Dao.UserDao;
import com.Security.Entity.Role;
import com.Security.Entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerNewUser(User user)
	{
		Role role=roleDao.findById("User").get();
		
		Set<Role>roles =new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		user.setUserPassword(getEncodedPassword( user.getUserPassword()));
		return userDao.save(user);
	}
	
	public User registerNewAdminUser(User user)
	{
		Role roleAdmin=roleDao.findById("Admin").get();
		
		Set<Role>rolesAdmin =new HashSet<>();
		rolesAdmin.add(roleAdmin);
		user.setRole(rolesAdmin);
		user.setUserPassword(getEncodedPassword( user.getUserPassword()));
		return userDao.save(user);
	}
	
	
	public void initRolesAndUser()
	{
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleDao.save(adminRole);
	
		
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default Role");
		roleDao.save(userRole);
		
		/* 
		User adminUser=new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		Set<Role>adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);
		
		
		
		User user=new User();
		user.setUserFirstName("abhi");
		user.setUserLastName("charwad");
		user.setUserName("abhi123");
		user.setUserPassword(getEncodedPassword("abhi@pass")) ;
		Set<Role>userRoles=new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userDao.save(user);
		*/
		
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
