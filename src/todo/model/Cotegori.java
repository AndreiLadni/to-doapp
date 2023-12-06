package todo.model;

import java.util.ArrayList;
import java.util.Objects;

// Category ( id, Name, AreyList )
public class Cotegori {
    private Integer id;
    private String name;
    private ArrayList<Note> notesList;

    public Cotegori(Integer id, String name, ArrayList<Note> notesList) {
        this.id = id;
        this.name = name;
        this.notesList = notesList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotesList(ArrayList<Note> notesList) {
        this.notesList = notesList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Note> getNotesList() {
        return notesList;
    }

    @Override
    public String toString() {
        return "Cotegori{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notesList=" + notesList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cotegori cotegori = (Cotegori) o;
        return Objects.equals(id, cotegori.id) && Objects.equals(name, cotegori.name) && Objects.equals(notesList, cotegori.notesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, notesList);
    }
}

