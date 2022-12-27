package com.finnegans.crisalis.model.dto;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.finnegans.crisalis.model.UserRol;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDTO {

	@JsonProperty("usuario")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("name")
	private String name;
	@JsonProperty("rol")
	private UserRol userRol;
}
