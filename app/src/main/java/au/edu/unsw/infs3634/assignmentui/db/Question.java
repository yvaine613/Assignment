package au.edu.unsw.infs3634.assignmentui.db;

import android.content.ContentValues;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String name;
    private String english;
    private String type;
    private String language;
    private String answer;

    public Question(String name, String english, String type, String language) {
        this.name = name;
        this.english = english;
        this.type = type;
        this.language = language;
    }

    public Question(int id, String name, String english, String type, String language) {
        this.id = id;
        this.name = name;
        this.english = english;
        this.type = type;
        this.language = language;
    }

    public static ContentValues getValues(Question type){
        ContentValues cv = new ContentValues();
        cv.put("name", type.getName());
        cv.put("english", type.getEnglish());
        cv.put("type", type.getType());
        cv.put("language", type.getLanguage());
        return cv;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
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
}
