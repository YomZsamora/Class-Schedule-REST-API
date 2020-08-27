package models;

public class Comments {
    private String content;
    private int student_id;

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
}
