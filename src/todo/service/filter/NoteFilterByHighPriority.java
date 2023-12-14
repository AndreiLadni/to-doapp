package todo.service.filter;

import todo.model.Note;
import todo.model.NotePriority;

import java.util.ArrayList;
import java.util.List;

public class NoteFilterByHighPriority implements NoteFilter {

    @Override
    public List<Note> applyFilter(List<Note> notes) {
        List<Note> filteredNotesByPriority = new ArrayList<>();

        for (Note note : notes) {
            if (note.getPriority() == null) {
                continue;
            }

            if (note.getPriority().equals(NotePriority.MEDIUM)) {
                filteredNotesByPriority.add(note);
            }
        }

        return filteredNotesByPriority;
    }
}
