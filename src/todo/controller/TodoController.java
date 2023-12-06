package todo.controller;

import com.sun.source.tree.NewArrayTree;
import jdk.jfr.Category;
import todo.model.Cotegori;
import todo.model.Note;

import java.util.ArrayList;

public class TodoController {
    public static void main(String[] args) {
        Cotegori gym = new Cotegori(1, "Gym", null );
        Note n1 = new Note(1, "2 подхода гантеля" , 1);
        Note n2 = new Note(2 , "Жим лежа 3 подхода", 1);
        ArrayList<Note>noteForGym = new ArrayList<>();
        noteForGym.add(n1);
        noteForGym.add(n2);
        gym.setNotesList(noteForGym);
        System.out.println(gym);
    }
}
