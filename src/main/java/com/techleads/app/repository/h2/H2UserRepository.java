package com.techleads.app.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techleads.app.model.Users;

public interface H2UserRepository extends JpaRepository<Users, Integer> {

}
