package au.edu.unsw.infs3634.assignmentui.db;


import java.io.Serializable;


public class Comment implements Serializable{
    private int id;
    private String type;
    private String content;
    private String time;
    private String language;
    public Comment(int id,String type,String language, String content, String time) {
        this.id = id;
        this.type = type;
        this.language = language;
        this.content = content;
        this.time = time;
    }

    public Comment(String type,String language,String content, String time) {
        this.type = type;
        this.language = language;
        this.content = content;
        this.time = time;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
