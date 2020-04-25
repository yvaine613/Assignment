package au.edu.unsw.infs3634.assignmentui.db;

import android.content.ContentValues;

public class User {
    int uid;
    String uname;
    String upasswd;
    String utel;
    String utext;
    String uicon;
    public static ContentValues getUserValues(User user){
        ContentValues cv = new ContentValues();
        cv.put("uname", user.getUname());
        cv.put("upasswd", user.getUpasswd());
        cv.put("utel", user.getUtel());
        cv.put("utext", user.getUtext());
        cv.put("uicon", user.getUicon());
        return cv;
    }

    public User() {
    }

    public User(int uid, String uname, String upasswd, String utel, String utext, String uicon) {
        this.uid = uid;
        this.uname = uname;
        this.upasswd = upasswd;
        this.utel = utel;
        this.utext = utext;
        this.uicon = uicon;
    }

    public User(String uname, String upasswd, String utel, String utext, String uicon) {
        this.uname = uname;
        this.upasswd = upasswd;
        this.utel = utel;
        this.utext = utext;
        this.uicon = uicon;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpasswd() {
        return upasswd;
    }

    public void setUpasswd(String upasswd) {
        this.upasswd = upasswd;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUtext() {
        return utext;
    }

    public void setUtext(String utext) {
        this.utext = utext;
    }

    public String getUicon() {
        return uicon;
    }

    public void setUicon(String uicon) {
        this.uicon = uicon;
    }
}
