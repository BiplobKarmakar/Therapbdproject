package com.Threapbd.Main;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.Threapbd.Main.Entity.Role;
import com.Threapbd.Main.Repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	
	@Autowired
	private RoleRepository repo;
	
	@Test
	
	public void testCreateRoles()
	{
		Role user =new Role("User");
		Role admin =new Role("Admin");
		Role patients =new Role("Patients");
		Role doctors =new Role("Doctors");
		
	repo.saveAll(List.of(user,admin,patients,doctors));	
	
	List<Role> listRoles = repo.findAll();
	assertThat(listRoles.size()).isEqualTo(4);
	}

}
