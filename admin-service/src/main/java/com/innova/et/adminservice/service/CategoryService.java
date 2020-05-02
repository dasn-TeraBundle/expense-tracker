package com.innova.et.adminservice.service;

import com.innova.et.adminservice.beans.Category;

public interface CategoryService extends GenericService<Category, String> {
    Category findByName(String name);
}
