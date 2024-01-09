package todo.service;

import todo.model.Category;
import todo.model.Note;
import todo.model.NotePriority;
import todo.repositorii.DbTodo;

import java.util.ArrayList;
import java.util.List;

/**
 * ====> Classwork <====
 *
 * FIELDS:
 * TODO: need to add filed "description" to Note class
 * TODO: need to add filed "deadline" to Note class
 *
 * FILTER:
 * TODO: create method that filter by priority with Stream
 * TODO: create method that filter by containsNoteName
 * TODO: create method that filter by containsNoteName with Stream
 *
 * ====> Homework <====
 * TODO: create method that filter by date with Stream
 *
 * SORTING:
 * TODO: create method that get all notes sorted by priority
 */
public class TodoService {
    private final DbTodo db;

    public TodoService(DbTodo db) {
        this.db = db;
    }

    public void printNotesToConsole(List<Note> notes) {

        for (Note note : notes) {
            String categoryName = getCategory(note.getCategoryId()).getName();
            System.out.println("[Category=" + categoryName + "] [" + note + "]");
        }
    }

    public void addCategory(Category category){
        db.getCategoryMap().put(category.getId(), category);
    }

    public Category getCategory(Integer categoryId){
        return db.getCategoryMap().get(categoryId);
    }

    public Category getCategoryByName(String name) {
        Category foundCategory = null;

        for (Category category : db.getCategoryMap().values()) {
            if (category.getName().equals(name)){
                foundCategory = category;
            }
        }

        if (foundCategory == null) {
            throw new IllegalArgumentException("Category with name " + name + " not found");
        } else {
            return foundCategory;
        }
    }

    public void addNoteToCategory(Integer categoryId, Note newNote) {
        Category category = getCategory(categoryId);

        if (category == null) {
            throw new IllegalArgumentException("Category with id " + categoryId + " not found");
        }

        category.getNotesList().add(newNote);
    }

    public List<Note> getAllNotes() {
        List<Note> allNotes = new ArrayList<>();

        for (Category category : db.getCategoryMap().values()) {
            allNotes.addAll(category.getNotesList());
        }

        return allNotes;
    }

    public List<Note> getAllNotesByPriority(NotePriority priority) {
        List<Category> categoriesFromDb = db.getAllCategories();

        List<Note> filteredNotesByPriority = new ArrayList<>();
        for (Category category : categoriesFromDb) {
            List<Note> notesFromCategory = category.getNotesList();

            for (Note note : notesFromCategory) {
                if (note.getPriority() != null && note.getPriority().equals(priority)) {
                    filteredNotesByPriority.add(note);
                }
            }
        }
        return filteredNotesByPriority;
    }

    /**
     * getAllNotesByPriority with Stream
     */
//    public List<Note> getAllNotesByPriorityUsingStream(NotePriority priority) {
//        List<Category> categoriesFromDb = db.getAllCategories();
//
//        return categoriesFromDb.stream()
//                .flatMap(category -> category.getNotesList().stream())
//                .filter(note -> note.getPriority() != null)
//                .filter(note -> note.getPriority().equals(priority))
//                .toList();
//    }

    /**
     * getAllNotesByContainsNoteName with Stream
     */
//    public List<Note> getAllNotesByContainsNoteNameUsingUsingStream(String noteName) {
//        List<Category> categoriesFromDb = new ArrayList<>(db.getCategoryMap().values());
//
//        return categoriesFromDb.stream()
//                .flatMap(category -> category.getNotesList().stream())
//                .filter(note -> note.getName() != null)
//                .filter(note -> note.getName().contains(noteName))
//                .toList();
//    }
}
