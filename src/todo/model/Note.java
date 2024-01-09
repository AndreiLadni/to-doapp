package todo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Note {

    private Integer id;
    private String name;
    private Integer categoryId;
    private NotePriority priority;

    public Note(Integer id, String name, Integer categoryId, NotePriority priority) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.priority = priority;
    }

    public Note(Integer id, String name, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public NotePriority getPriority() {
        return priority;
    }

    public void setPriority(NotePriority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Note" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", priority=" + priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(name, note.name) && Objects.equals(categoryId, note.categoryId) && priority == note.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryId, priority);
    }
}
