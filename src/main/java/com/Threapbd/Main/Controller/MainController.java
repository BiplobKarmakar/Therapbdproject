package com.Threapbd.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Threapbd.Main.Entity.Role;
import com.Threapbd.Main.Entity.User;
import com.Threapbd.Main.Repository.UserRepository;
import com.Threapbd.Main.Service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService service;
    
	@GetMapping("")
	public String viewHomePage()
	{
		return "index";
	}
	@Transactional
	@GetMapping ("/register")
	public String showSignUpform(  Model model)
	{
		model.addAttribute("user", new User());

		return "signup_form";
	}
	
	


	@PostMapping("/process_register")
	public String processRegistration(User user)
	{
		//BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		//String encodedPassword=encoder.encode(user.getPassword());
		//user.setPassword(encodedPassword);
		service.saveUserWithDefaultRole(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
		
		return "register_success";
		
	}
	@GetMapping("/users")
	public String viewUsersList(Model model)
	{
		List<User> listusers=service.listAll();
		model.addAttribute("listusers", listusers);
		return "users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id,Model model )
	{
		User user= service.get(id);
		List<Role> listRoles= service.getRoles();
		model.addAttribute("listRoles",listRoles);
		model.addAttribute("user",user);
		return "user_form";
	}
	@PostMapping("/user/save")
	public String saveUser(User user)
	{
		service.save(user);
		return "redirect:/users";
	}
	
	
}
