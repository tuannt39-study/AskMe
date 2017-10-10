package vn.its.service;

import vn.its.domain.Category;
import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    
    Category findOne(int id);
    
    Category findOne(String name);

    int count();
    
    void create(Category category);

    void update(Category category);

    void delete(Category category);
    
}
