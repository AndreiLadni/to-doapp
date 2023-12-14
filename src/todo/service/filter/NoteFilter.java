package todo.service.filter;

import todo.model.Note;

import java.util.List;

public interface NoteFilter {

    List<Note> applyFilter(List<Note> notes);
}
