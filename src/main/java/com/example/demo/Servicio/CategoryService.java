/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Category;
import com.example.demo.Repositorio.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
       return categoryRepository.getAll();    
       
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
       
    }
    
    public Category save(Category category){
       if (category.getId() == null ){
           return categoryRepository.save(category);
       } else {
           Optional<Category> category1 = categoryRepository.getCategory(category.getId());
           if (category1.isEmpty()){
               return categoryRepository.save(category);
           } else {
              return category;
           }
       
       }
    }
}
