package com.techleads.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MULTI_USERS")
public class Users {
	@Id
	private Integer id;
	private String name;
	private String location;
	private String role;
	

	
	

}
