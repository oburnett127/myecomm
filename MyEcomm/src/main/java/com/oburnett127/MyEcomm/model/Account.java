package com.oburnett127.MyEcomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
	private int accountId;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private boolean isAdmin;
}