package com.finnegans.crisalis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.finnegans.crisalis.exception.custom.EmptyElementException;
import com.finnegans.crisalis.exception.custom.NotCreatedException;
import com.finnegans.crisalis.exception.custom.UnauthorizedException;
import com.finnegans.crisalis.model.User;
import com.finnegans.crisalis.model.dto.UserDTO;
import com.finnegans.crisalis.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(UserDTO userDTO) {
		if (checkUserDTO(userDTO, Boolean.FALSE)) {
			return this.userRepository.save(new User(userDTO));
		}
		throw new NotCreatedException("Error in save new User");
	}

	public UserDTO loginUserWithCredentials(String username, String password) {
		if (this.checkUserDTO(UserDTO.builder().username(username).password(password).build(), Boolean.TRUE)

		) {
			return this.userRepository.findByUsernameAndPassword(username, password)
					.orElseThrow(() -> new UnauthorizedException("invalid credentials")).toUserDTO();

		}
		throw new UnauthorizedException("invalid credentials");

	}
	public List<UserDTO> getListAllUsersToBD(){
		return	this.userRepository
							.findAll()
							.stream()
							.map(User::toUserDTO)
							.collect(Collectors.toList());
		
	}
	
	
	private Boolean checkUserDTO(UserDTO userDTO, Boolean isForLogin) {
		if (isForLogin) {
			if (StringUtils.isEmpty(userDTO.getName())) {
				throw new EmptyElementException("Name is empty");
			}
			if(userDTO.getUserRol()==null) {
				throw new EmptyElementException("Rol is empty");
			}

		}
		if (StringUtils.isEmpty(userDTO.getUsername())) {
			throw new EmptyElementException("Username is empty");
		}
		if (StringUtils.isEmpty(userDTO.getPassword())) {
			throw new EmptyElementException("Password is empty");
		}
		return Boolean.TRUE;
	}
}
