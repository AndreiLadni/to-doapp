package todo.service;

import todo.model.Category;
import todo.model.Note;
import todo.model.NotePriority;
import todo.repositorii.DbTodo;
import todo.service.filter.NoteFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * x: need to add filed "description" String
 * x: need to add filed "deadline" LocalDate
 * FILTER:
 * x: filter by containsNoteName
 * TODO: get all notes witch deadline is done
 * SORTING:
 * TODO: get all notes sorted by priority
 * CRUD:
 * TODO: update Note by Note id
 * TODO: update Category by Category id
 * TODO: delete Note by Note id
 * TODO: delete Category by Category id
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
        List<Category> categories = new ArrayList<>(db.getCategoryMap().values());

        List<Note> allNotesByPriority = new ArrayList<>();
        for (Category category : categories) {
            List<Note> notesFromCurrentCategory = category.getNotesList();

            List<Note> filteredNotesFromCurrantCategory = filterNotes(notesFromCurrentCategory, (List<Note> notes) -> {
                List<Note> filteredNotes = new ArrayList<>();
                for (Note note : notes) {
                    if (note.getPriority() == null) {
                        continue;
                    }
                    if (note.getPriority().equals(priority)) {
                        filteredNotes.add(note);
                    }
                }
                return filteredNotes;
            });

            allNotesByPriority.addAll(filteredNotesFromCurrantCategory);
        }

        return allNotesByPriority;
    }

    public List<Note> getAllNotesByContainsNoteName(String noteName) {
        List<Category> categoriesFromDb = new ArrayList<>(db.getCategoryMap().values());

        List<Note> notesThatContainsNoteName = new ArrayList<>();
        for (Category category : categoriesFromDb) {
            List<Note> noteListFromDb = category.getNotesList();

            List<Note> filteredNoteWithTargetNoteName = filterNotes(
                    noteListFromDb, notes -> {
                        List<Note> result = new ArrayList<>();
                        for (Note note : notes) {
                            if (note.getName().contains(noteName)) {
                                result.add(note);
                            }
                        }
                        return result;
                    }
            );
            notesThatContainsNoteName.addAll(filteredNoteWithTargetNoteName);
        }
        return notesThatContainsNoteName;
    }

    private List<Note> filterNotes(List<Note> notes, NoteFilter noteFilter) {
        return noteFilter.applyFilter(notes);
    }
}
