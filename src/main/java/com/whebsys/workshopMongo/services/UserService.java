package com.whebsys.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whebsys.workshopMongo.domain.User;
import com.whebsys.workshopMongo.repository.UserRepository;
import com.whebsys.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findById (String id) {
		Optional<User> obj = userRepository.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")));
	}
}
