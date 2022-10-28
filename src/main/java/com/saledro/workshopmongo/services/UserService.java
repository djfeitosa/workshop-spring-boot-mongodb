package com.saledro.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saledro.workshopmongo.domain.User;
import com.saledro.workshopmongo.dto.UserDTO;
import com.saledro.workshopmongo.repository.UserRepository;
import com.saledro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		User user = repository.findById(id).get();
		
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user;
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(User user) {
		repository.delete(user);
	}
	
	
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
