package com.innova.et.adminservice.dao;

import com.innova.et.adminservice.beans.Category;
import com.innova.et.common.dao.GenericDao;

public interface CategoryDao extends GenericDao<Category, String> {
    Category findByName(String name);
}
