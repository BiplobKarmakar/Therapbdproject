package com.Threapbd.Main;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.Threapbd.Main.Entity.User;
import com.Threapbd.Main.Entity.Role;
import com.Threapbd.Main.Repository.RoleRepository;
import com.Threapbd.Main.Repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired 
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	/*
	 * @Test public void testCreateUser() { User user=new User();
	 * 
	 * user.setEmail("kalam@gmail.com"); user.setPassword("kalam123456");
	 * user.setFirstName("kalam"); user.setLastName("Ahmed"); User savedUser=
	 * repo.save(user); User existUser= entityManager.find(user.getClass(),
	 * savedUser.getId());
	 * 
	 * assertThat(existUser.getEmail()).isEqualTo(user.getEmail()); }
	 */
	 
    
	
		/*
		 * @Test public void testFindUserByEmail() { String email="biplob@gmail.com";
		 * User user =repo.findByEmail(email);
		 * 
		 * assertThat(user).isNotNull();
		 * 
		 * }
		 */
	  
		
		/*
		 * @Test public void testAddRoleToNewUser() { User user= new User();
		 * user.setEmail("ravi.kumar@gmail.com"); user.setPassword("ravi2008");
		 * user.setFirstName("Ravi"); user.setLastName("kumar");
		 * 
		 * 
		 * Role roleuser=roleRepo.findByName("User"); user.addRole(roleuser);
		 * 
		 * User savedUser=repo.save(user);
		 * 
		 * assertThat(savedUser.getRoles().size()).isEqualTo(1); }
		 */
		   
		
		  @Test 
		  public void testAddRoleToExistingUser()
		  { 
			  User user=repo.findById(3L).get();
		  
		  Role roleUser=roleRepo.findByName("Admin"); 
		  user.addRole(roleUser); Role
		  roleAdmin=new Role(2L);
		  user.addRole(roleAdmin);
		  
		  User savedUser=repo.save(user);
		  assertThat(savedUser.getRoles().size()).isEqualTo(1);
		  
		  
		  }
		 
}
