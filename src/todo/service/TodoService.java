package todo.service;

import todo.model.Cotegori;
import todo.model.Note;
import todo.repositorii.DbTodo;

public class TodoService {
    private DbTodo db;

    public TodoService(DbTodo db) {
        this.db = db;
    }
    // Добавить категории
    //!

    // Получить категорию по id +
    //!

    // Удаление категории
    //Добавить заметки в категории +
    //!


    // Получить заметку по id (категории) и по id (заметки) +
    // обновить заметку по id (категории) и по id (заметки)
    // Удалить заметку по id (категории) и по id (заметки)
    // Получить заметку по фильтру +
    // Сартировать заметки по Алфавиту

    public void addCotegori (Cotegori cotegori){
        db.getCotegoriMap().put(cotegori.getId(), cotegori);

    }

    public Cotegori getCotegori(Integer cotegoriId){
        Cotegori result = db.getCotegoriMap().get(cotegoriId);
        return result;
    }

    public void addNoteToCotegori(Integer cotegoriID, Note newNote){
     Cotegori cotegori = getCotegori(cotegoriID);
     if (cotegori == null){
         throw new  IllegalArgumentException("Не туда ты попал");
     }
     cotegori.getNotesList().add(newNote);

//     try{
//         cotegori.getNotesList().add(newNote);
//     }catch (NullPointerException exception){
//         System.err.println("Чел ты не ту категорию написал ");
//     }

    }
}
