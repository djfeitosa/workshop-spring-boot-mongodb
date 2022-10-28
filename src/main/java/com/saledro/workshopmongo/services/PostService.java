package com.saledro.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saledro.workshopmongo.domain.Post;
import com.saledro.workshopmongo.repository.PostRepository;
import com.saledro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Post post = repository.findById(id).get();
		
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return post;
	}	
}
