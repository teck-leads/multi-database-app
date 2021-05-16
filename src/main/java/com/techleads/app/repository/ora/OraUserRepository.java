package com.techleads.app.repository.ora;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techleads.app.model.Users;

public interface OraUserRepository extends JpaRepository<Users, Integer> {

}
