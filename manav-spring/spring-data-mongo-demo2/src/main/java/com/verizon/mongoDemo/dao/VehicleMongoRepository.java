package com.verizon.mongoDemo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.verizon.mongoDemo.model.Vehicles;

@Repository
public interface VehicleMongoRepository  extends MongoRepository<Vehicles, Integer>{

}
