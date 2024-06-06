package com.whebsys.workshopMongo.Resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whebsys.workshopMongo.Resources.util.URL;
import com.whebsys.workshopMongo.domain.Post;
import com.whebsys.workshopMongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Post>> findById(@PathVariable String id){
		Optional<Post> obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTittle(@RequestParam(value="text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List <Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
}
