package com.finnegans.crisalis.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.finnegans.crisalis.model.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="userCrisalis")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	@Column(name="pass")
	private String password;
	@Column(name="name")
	private String name;
	@Column(name="rol")
	private UserRol rol;
	
	public User(UserDTO userDTO) {
		this.name=userDTO.getName();
		this.username=userDTO.getUsername();
		this.password=userDTO.getPassword();
		this.rol =userDTO.getUserRol();
	}
	
	public UserDTO toUserDTO() { 
		return  UserDTO
						.builder()
						.name(this.name)
						.username(this.username)
						.password(this.password)
						.userRol(this.rol)
						.build();
	}
}
