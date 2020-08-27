package models;

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
}
