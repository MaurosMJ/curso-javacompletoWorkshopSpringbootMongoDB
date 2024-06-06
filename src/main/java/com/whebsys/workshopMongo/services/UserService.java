package com.whebsys.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whebsys.workshopMongo.domain.User;
import com.whebsys.workshopMongo.dto.UserDTO;
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
	
	public User insert (User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete (String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update (User obj) {
		Optional<User> newObj = userRepository.findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj.get());
	}
	
	public void updateData (Optional<User> newObj, User obj) {
		newObj.get().setName(obj.getName());
		newObj.get().setEmail(obj.getEmail());
		
	}
	
	public User fromDTO (UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
