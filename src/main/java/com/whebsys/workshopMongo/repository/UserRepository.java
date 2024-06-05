package com.whebsys.workshopMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.whebsys.workshopMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
