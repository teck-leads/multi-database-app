package com.techleads.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Users;
import com.techleads.app.repository.h2.H2UserRepository;
import com.techleads.app.repository.ora.OraUserRepository;

@Component
public class UserRunner implements CommandLineRunner {

	private OraUserRepository oraUserRepository;
	private H2UserRepository h2UserRepository;
	@Autowired
	public UserRunner(OraUserRepository oraUserRepository, H2UserRepository h2UserRepository) {
		this.h2UserRepository = h2UserRepository;
		this.oraUserRepository = oraUserRepository;
	}

	
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Users user=new Users();
		user.setId(101);
		user.setName("MultiDbUser");
		user.setLocation("Hyderabad");
		user.setRole("DBAdmin");
		oraUserRepository.save(user);
		System.out.println("saved ora");
		h2UserRepository.save(user);
		System.out.println("saved h2");

	}

}
