package todo.repositorii;

import todo.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DbTodo {
    private Map<Integer, Category> categoryMap;
    private Integer categoryIndex = 0;
    private Integer noteIndex = 0;

    public DbTodo(Map<Integer, Category> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public DbTodo() {
    }

    public List<Category> getAllCategories() {
        List<Category> allCategoriesFromDb = new ArrayList<>();
        allCategoriesFromDb.addAll(categoryMap.values());
        return allCategoriesFromDb;
    }

    public Integer incrementCategoryIndexAndGet(){
        incrementCategoryIndex();
        return getCategoryIndex();
    }

    public Integer getCategoryIndex() {
        return categoryIndex;
    }

    public void incrementCategoryIndex(){
        categoryIndex++;
    }

    public Integer incrementNoteIndexAndGet(){
        incrementNoteIndex();
        return getNoteIndex();
    }

    public Integer getNoteIndex() {
        return noteIndex;
    }

    public void incrementNoteIndex(){
        noteIndex++;
    }

    public Map<Integer, Category> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<Integer, Category> cotegoryMap) {
        this.categoryMap = cotegoryMap;
    }
}
