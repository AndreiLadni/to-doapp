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
                        "Learn German Grammar",
//                        "Start basic german grammar exercises",
//                        LocalDate.now().plusDays(5),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.HIGH
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Learn German Vocabulary",
//                        "Complete german vocabulary list for beginners",
//                        LocalDate.now().plusDays(10),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.LOW
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice German Speaking",
//                        "Schedule Weekly German Speaking Practice",
//                        LocalDate.now().plusDays(15),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.HIGH
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Review German Grammar Rules",
//                        "Review German Grammar Rules for Beginners",
//                        LocalDate.now().plusDays(20),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Watch German Language Movies with Subtitles",
//                        "Watch German Language Movies with Subtitles to improve listening skills",
//                        LocalDate.now().plusDays(25),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.LOW
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice German Conversational Phrases",
//                        "Practice German Conversational Phrases with Native Speakers",
//                        LocalDate.now().plusDays(30),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Attend German Language Workshop",
//                        "Attend German Language Workshop to improve speaking skills",
//                        LocalDate.now().plusDays(35),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.LOW
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Read German Short Stories",
//                        "Read German Short Stories to improve reading skills",
//                        LocalDate.now().plusDays(40),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Memorize German Idiomatic Expressions",
//                        "Memorize German Idiomatic Expressions to improve speaking skills",
//                        LocalDate.now().plusDays(45),
                        germanLanguageLearningCategory.getId(),
                        NotePriority.LOW
                )
        );
        germanLanguageLearningNotes.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Prepare for German Language Test",
//                        "Prepare for German Language Test to get B1 Certificate",
//                        LocalDate.now().plusDays(50),
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
//                        "Complete Java Basics Tutorial on Udemy",
//                        LocalDate.now().plusDays(5),
                        programmingStudyCategory.getId(),
                        NotePriority.HIGH
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java OOP Tutorial",
//                        "Complete Java OOP Tutorial on Udemy",
//                        LocalDate.now().plusDays(10),
                        programmingStudyCategory.getId(),
                        NotePriority.HIGH
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java Collections Tutorial",
//                        "Complete Java Collections Tutorial on Udemy",
//                        LocalDate.now().plusDays(15),
                        programmingStudyCategory.getId(),
                        NotePriority.HIGH
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice Data Structures and Algorithms",
//                        "Practice Data Structures and Algorithms on LeetCode",
//                        LocalDate.now().plusDays(20),
                        programmingStudyCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java Streams Tutorial",
//                        "Complete Java Streams Tutorial on Udemy",
//                        LocalDate.now().plusDays(25),
                        programmingStudyCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Complete Java Multithreading Tutorial",
//                        "Complete Java Multithreading Tutorial on Udemy",
//                        LocalDate.now().plusDays(30),
                        programmingStudyCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice Java Concurrency",
//                        "Practice Java Concurrency on LeetCode",
//                        LocalDate.now().plusDays(35),
                        programmingStudyCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        programmingStudyNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Review Java Best Practices",
//                        "Review Java Best Practices on GitHub",
//                        LocalDate.now().plusDays(40),
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
//                        "Plan Weekly Gym Workout Schedule for 3 months",
//                        LocalDate.now().plusDays(5),
                        gymCategory.getId(),
                        NotePriority.HIGH
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Focus on Cardio Exercises",
//                        "Focus on Cardio Exercises for 2 months",
//                        LocalDate.now().plusDays(10),
                        gymCategory.getId(),
                        NotePriority.HIGH
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Focus on Strength Training",
//                        "Focus on Strength Training for 2 months",
//                        LocalDate.now().plusDays(15),
                        gymCategory.getId(),
                        NotePriority.HIGH
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Research Effective Weight Training Techniques",
//                        "Research Effective Weight Training Techniques for 1 month",
//                        LocalDate.now().plusDays(20),
                        gymCategory.getId(),
                        NotePriority.LOW
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice Yoga",
//                        "Practice Yoga for 1 month",
//                        LocalDate.now().plusDays(25),
                        gymCategory.getId(),
                        NotePriority.MEDIUM
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Evaluate Gym Equipment for Upgrade",
//                        "Evaluate Gym Equipment for Upgrade",
//                        LocalDate.now().plusDays(30),
                        gymCategory.getId(),
                        NotePriority.LOW
                )
        );
        gymNoteList.add(
                new Note(
                        dbTodo.incrementNoteIndexAndGet(),
                        "Practice Meditation",
//                        "Practice Meditation for 1 month",
//                        LocalDate.now().plusDays(35),
                        gymCategory.getId(),
                        NotePriority.HIGH
                )
        );
        gymCategory.setNotesList(gymNoteList);
        return gymCategory;
    }
}