package todo.controller;

import todo.model.Category;
import todo.model.Note;
import todo.model.NotePriority;
import todo.repositorii.DbTodo;
import todo.service.TodoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoController {

    public static void main(String[] args) {
        DbTodo dbTodo = initMockDataForTodoApp();
        TodoService todoService = new TodoService(dbTodo);

        Note attendToYogaNote = new Note(
                dbTodo.incrementNoteIndexAndGet(),
                "Attend Yoga Classes",
                todoService.getCategoryByName("Gym").getId()
        );
        todoService.addNoteToCategory(todoService.getCategoryByName("Gym").getId(), attendToYogaNote);

        List<Note> notesList = todoService.getAllNotesByPriority(NotePriority.HIGH);

        todoService.printNotesToConsole(notesList);

        System.out.println("End of program");
    }

    private static DbTodo initMockDataForTodoApp() {
        DbTodo dbTodo = new DbTodo();
        Map<Integer, Category> mapForDb = new HashMap<>();

        Category germanLanguageLearningCategory = initMockGermanLanguageLearningCategoryWithNotes(dbTodo);
        mapForDb.put(germanLanguageLearningCategory.getId(), germanLanguageLearningCategory);

        Category programmingStudyCategory = initMockProgrammingStudyCategoryWithNotes(dbTodo);
        mapForDb.put(programmingStudyCategory.getId(), programmingStudyCategory);

        Category gymCategory = initMockGymCategoryWithNotes(dbTodo);
        mapForDb.put(gymCategory.getId(), gymCategory);

        dbTodo.setCategoryMap(mapForDb);

        return dbTodo;
    }

    private static Category initMockGermanLanguageLearningCategoryWithNotes(DbTodo dbTodo) {
        Category germanLanguageLearningCategory = new Category(
                dbTodo.incrementCategoryIndexAndGet(),
                "German language learning",
                null
        );

        List<Note> germanLanguageLearningNotes = new ArrayList<>();
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Start basic german grammar exercises",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.HIGH
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete german vocabulary list for beginners",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.LOW
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Schedule Weekly German Speaking Practice",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.HIGH
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Review German Grammar Rules",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Watch German Language Movies with Subtitles",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.LOW
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice German Conversational Phrases",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Attend German Language Workshop",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.LOW
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Read German Short Stories",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Memorize German Idiomatic Expressions",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.LOW
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Prepare for German Language Test",
                        germanLanguageLearningCategory.getId(),
                        NotePriority.HIGH
                )
        );
        germanLanguageLearningCategory.setNotesList(germanLanguageLearningNotes);
        return germanLanguageLearningCategory;
    }

    private static Category initMockProgrammingStudyCategoryWithNotes(DbTodo dbTodo) {
        Category programmingStudyCategory = new Category(
                dbTodo.incrementCategoryIndexAndGet(),
                "Programming Study",
                null
        );

        List<Note> programmingStudyNoteList = new ArrayList<>();
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java Basics Tutorial",
                        programmingStudyCategory.getId(),
                        NotePriority.HIGH
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java OOP Tutorial",
                        programmingStudyCategory.getId(),
                        NotePriority.HIGH
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java Collections Tutorial",
                        programmingStudyCategory.getId(),
                        NotePriority.HIGH
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice Data Structures and Algorithms",
                        programmingStudyCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java Streams Tutorial",
                        programmingStudyCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java Multithreading Tutorial",
                        programmingStudyCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice Java Concurrency",
                        programmingStudyCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Review Java Best Practices",
                        programmingStudyCategory.getId(),
                        NotePriority.LOW
                )
        );
        programmingStudyCategory.setNotesList(programmingStudyNoteList);
        return programmingStudyCategory;
    }

    private static Category initMockGymCategoryWithNotes(DbTodo dbTodo) {
        Category gymCategory = new Category(
                dbTodo.incrementCategoryIndexAndGet(),
                "Gym",
                null
        );

        List<Note> gymNoteList = new ArrayList<>();
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Plan Weekly Gym Workout Schedule",
                        gymCategory.getId(),
                        NotePriority.HIGH
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Focus on Cardio Exercises",
                        gymCategory.getId(),
                        NotePriority.HIGH
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Focus on Strength Training",
                        gymCategory.getId(),
                        NotePriority.HIGH
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Research Effective Weight Training Techniques",
                        gymCategory.getId(),
                        NotePriority.LOW
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice Yoga",
                        gymCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Evaluate Gym Equipment for Upgrade",
                        gymCategory.getId(),
                        NotePriority.LOW
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice Meditation",
                        gymCategory.getId(),
                        NotePriority.HIGH
                )
        );
        gymCategory.setNotesList(gymNoteList);
        return gymCategory;
    }
}