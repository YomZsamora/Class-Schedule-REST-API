package models;

import java.util.Objects;

public class Comments {
    private int student_id;
    private String content;
    private int id;

    public Comments(int student_id, String content) {
        this.student_id = student_id;
        this.content = content;
    }

    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return student_id == comments.student_id &&
                id == comments.id &&
                Objects.equals(content, comments.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, content, id);
    }
}
