package vn.its.dao;

import vn.its.domain.Category;
import java.util.List;

public interface CategoryDAO {

    List<Category> findAll();
    
    Category findOne(int id);
    
    Category findOne(String name);
    
    int count();
    
    void create(Category category);

    void update(Category category);

    void delete(Category category);
    
}
