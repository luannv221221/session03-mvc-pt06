package com.ra.service;

import com.ra.model.dao.CategoryDAO;
import com.ra.model.dao.CategoryDAOImp;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    // private final CategoryDAO categoryDAO = new CategoryDAOImp();
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Boolean create(Category category) {
        return categoryDAO.create(category);
    }
}
