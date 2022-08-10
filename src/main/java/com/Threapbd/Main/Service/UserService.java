package com.Threapbd.Main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Threapbd.Main.Entity.Role;
import com.Threapbd.Main.Entity.User;
import com.Threapbd.Main.Repository.RoleRepository;
import com.Threapbd.Main.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
    @Autowired 
    private RoleRepository roleRepo;
    
    
	
	public UserService() {
		super();
	}
	

	public UserService(UserRepository repo, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepo) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
		this.roleRepo = roleRepo;
	}


	public void saveUserWithDefaultRole(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Role roleuser=roleRepo.findByName("User");
		user.addRole(roleuser);
		repo.save(user);
	}
	
	public List<User> listAll()
	{
		return repo.findAll();
		
	}
	public User get (Long id)
	{
		return repo.findById(id).get();
		
	}
	public List<Role> getRoles()
	{
		return roleRepo.findAll();
	}
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
			
		repo.save(user);
	}
}
