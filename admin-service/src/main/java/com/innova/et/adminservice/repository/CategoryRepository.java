package com.innova.et.adminservice.repository;

import com.innova.et.adminservice.beans.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByName(String name);
}
