package au.edu.unsw.infs3634.assignmentui;

import java.util.ArrayList;

public class Languages {
    private String newWords;
    private String translation;
    private String description;


    public Languages() {
    }

    public Languages(String newWords, String translation, String deacription) {
        this.newWords = newWords;
        this.translation = translation;
        this.description = deacription;
    }

    public String getNewWords() {
        return newWords;
    }

    public void setNewWords(String newWords) {
        this.newWords = newWords;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getDescription(String deacription) {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Languages getLanguages(String id) {
        for (Languages coin : getLanguages()) {
            if (coin.getNewWords().equals(id)) {
                return coin;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return newWords;
    }

    public static ArrayList<Languages> getLanguages() {
        ArrayList<Languages> languages = new ArrayList<>();
        languages.add(new Languages("", "", ""));
        languages.add(new Languages("", "", ""));


        return languages;
    }
}
