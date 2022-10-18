package com.inacioalves.auth.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inacioalves.auth.exception.objectNotFoundException;
import com.inacioalves.auth.model.User;
import com.inacioalves.auth.repository.UserRepository;
import com.inacioalves.auth.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements Serializable,UserService {

	private static final long serialVersionUID = -1339402540922449458L;

	private final UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;


	@Override
	public User create(User obj) {
		obj.setPassword(encoder.encode(obj.getPassword()));
		return userRepository.save(obj);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		Optional<User> opt = userRepository.findById(id);
		return NotFoundException(id, opt);
	}

	@Override
	public User Update(User obj) {
		final Optional<User> optUser = userRepository.findById(obj.getId());

		if (!optUser.isPresent()) {
			return NotFoundException(obj.getId(), optUser);
		}
		
		if(!optUser.get().getPassword().equals(obj.getPassword())) {
			obj.setPassword(encoder.encode(obj.getPassword()));
			
		}
		
		return userRepository.save(obj);
	}
	
	@Override
	public void Deletar(Long id) {
		var entity = userRepository.findById(id)
				.orElseThrow(() -> new objectNotFoundException("Usuário não encontrado com Id:" + id));

		userRepository.delete(entity);
	}
	
	private User NotFoundException(Long id, Optional<User> opt) {
		return opt.orElseThrow(() -> new objectNotFoundException("Usuário não encontrado com Id:" + id));
	}
	

}
