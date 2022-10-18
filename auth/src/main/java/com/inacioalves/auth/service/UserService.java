package com.inacioalves.auth.service;

import java.util.List;

import com.inacioalves.auth.model.User;

public interface UserService {
	
	 User create(User obj);
	 List<User> findAll();
	 User findById(Long id);
	 User Update(User obj);
	 void Deletar(Long id);

}
