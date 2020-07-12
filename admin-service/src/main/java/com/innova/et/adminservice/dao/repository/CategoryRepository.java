package com.innova.et.adminservice.dao.repository;

import com.innova.et.adminservice.beans.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.stream.Stream;

public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query(value = "{id: ?0}", fields = "{name: 1}")
    Category findById_Name(String id);

    Category findByName(String name);

    @Query(value = "{}", fields = "{name: 1}")
    Stream<Category> findAllById_Name();
}
