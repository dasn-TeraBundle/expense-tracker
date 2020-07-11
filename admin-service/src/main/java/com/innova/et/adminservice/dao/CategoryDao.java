package com.innova.et.adminservice.dao;

import com.innova.et.adminservice.beans.Category;
import com.innova.et.common.dao.GenericDao;

import java.util.List;

public interface CategoryDao extends GenericDao<Category, String> {

    Category findById_Name(String id);
    Category findByName(String name);
    List<Category> findAllById_Name();
}
