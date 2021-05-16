package com.techleads.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Users;
import com.techleads.app.repository.UserRepository;
@Component
public class UserRunner implements CommandLineRunner {

	private UserRepository userRepository;

	@Autowired
	public UserRunner(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Users user=new Users();
		user.setId(101);
		user.setName("MultiDbUser");
		user.setLocation("Hyderabad");
		user.setRole("DBAdmin");
		userRepository.save(user);
		System.out.println("saved");

	}

}
