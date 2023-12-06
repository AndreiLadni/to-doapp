package todo.model;

import java.util.Objects;

// Note ( id , Description , Category id. )
public class Note {

    private Integer id;
    private String description;
    private Integer categoryId;

    public Note(Integer id, String description, Integer categoryId) {
        this.id = id;
        this.description = description;
        this.categoryId = categoryId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(description, note.description) && Objects.equals(categoryId, note.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, categoryId);
    }
}
