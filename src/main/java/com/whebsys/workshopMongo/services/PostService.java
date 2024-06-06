package com.whebsys.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whebsys.workshopMongo.domain.Post;
import com.whebsys.workshopMongo.repository.PostRepository;
import com.whebsys.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	
	@Autowired
	private PostRepository postRepository;
	
	public Optional<Post> findById (String id) {
		Optional<Post> obj = postRepository.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")));
	}
	
	public List<Post> findByTitle (String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
}