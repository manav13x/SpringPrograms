package com.verizon.cassendraDemo.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.verizon.cassendraDemo.model.Item;
@Repository
public interface CassendraRepo extends CassandraRepository<Item, Integer>{

}
