package org.practice.project.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.practice.project.entity.Role;
import org.practice.project.entity.User;
import org.practice.project.global.GlobalData;
import org.practice.project.repository.RoleRepository;
import org.practice.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userrepository;
	@Autowired
	RoleRepository roleRepository;
	@GetMapping("/login")
	public String login() {
		GlobalData.cart.clear();
		return"login";
	
	}
	@GetMapping("/register")
	public String register() {
		return"register";
	
	}
	@PostMapping("/register")
	public String doregister(@ModelAttribute("user")User user,HttpServletRequest request) throws ServletException{
		String password=user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role>role=new ArrayList<>();
		role.add(roleRepository.findById(2).get());
		user.setRole(role);
		userrepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
	}

}
