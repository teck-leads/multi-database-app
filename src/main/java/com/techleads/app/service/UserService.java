package com.techleads.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleads.app.model.Users;
import com.techleads.app.repository.h2.H2UserRepository;
import com.techleads.app.repository.ora.OraUserRepository;

@Service
public class UserService {
	
	private OraUserRepository oraUserRepository;
	private H2UserRepository h2UserRepository;
	@Autowired
	public UserService(OraUserRepository oraUserRepository, H2UserRepository h2UserRepository) {
		this.h2UserRepository = h2UserRepository;
		this.oraUserRepository = oraUserRepository;
	}
	
	
	public List<Users> findAllOraUsers(){
		List<Users> oraUsers = oraUserRepository.findAll();
		return oraUsers;
	}
	
	public List<Users> findAllH2Users(){
		List<Users> h2Users = h2UserRepository.findAll();
		return h2Users;
	}

}
