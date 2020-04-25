package au.edu.unsw.infs3634.assignmentui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private static QuestionDao userDB;
    private SQLiteDatabase db;
    private QuestionDao(Context context) {
        DBQuestionHelper dbHelper = new DBQuestionHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public static QuestionDao getInstance(Context context) {
        if (userDB == null) {
            userDB = new QuestionDao(context);
        }
        return userDB;
    }


    public void addQuestion(Question device) {
        db.insert("question", null, Question.getValues(device));

    }



    public List<Question> loadQuestion(String type,String language){
        ArrayList<Question> devices = new ArrayList<>();
        Cursor cursor = db.query("question", null, "type=? and language=?", new String[]{type,language}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {

                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String english = cursor.getString(cursor.getColumnIndex("english"));
                Question question = new Question( id,  name, english,  type, language);
                devices.add(question);
            }
            cursor.close();
        }
        return devices;
    }

    public List<Question> loadQuestion(String language){
        ArrayList<Question> devices = new ArrayList<>();
        Cursor cursor = db.query("question", null, " language=?", new String[]{language}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {

                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String english = cursor.getString(cursor.getColumnIndex("english"));
                String type = cursor.getString(cursor.getColumnIndex("type"));
                Question question = new Question( id,  name, english,  type, language);
                devices.add(question);
            }
            cursor.close();
        }
        return devices;
    }
    public ContentValues getContentValues(Comment order){
        ContentValues cv = new ContentValues();
        cv.put("type", order.getType());
        cv.put("language", order.getLanguage());
        cv.put("content", order.getContent());
        cv.put("time", order.getTime());
        return cv;

    }


    public void addComment(Comment order) {
        db.insert("comment", null, getContentValues(order));
    }

    public List<Comment> loadCommentById(String type,String language){
        ArrayList<Comment> orderList = new ArrayList<Comment>();
        Cursor cursor = db.query("comment", null, "type=? and language=?", new String[]{type,language}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String content = cursor.getString(cursor.getColumnIndex("content"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                Comment order = new Comment(id,type,language, content, time);
                orderList.add(order);
            }

            cursor.close();
        }
        return orderList;
    }

    public boolean registerUser(User user) {
        if (user != null) {
            Cursor cursor = db.query("user", null, "uname=?", new String[]{user.getUname()}, null, null, null);
            if (cursor.getCount() > 0) {
                return false;
            } else {
                db.insert("user", null, User.getUserValues(user));
                return true;
            }
        }
        return false;

    }


    public User getUserInfoById(int id) {
        User user = null;
        Cursor cursor = db.query("user", null, "uid" + "=" + id, null, null, null, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int uid = cursor.getInt(cursor.getColumnIndex("uid"));
                String uname = cursor.getString(cursor.getColumnIndex("uname"));
                String upasswd = cursor.getString(cursor.getColumnIndex("upasswd"));
                String utel = cursor.getString(cursor.getColumnIndex("utel"));
                String utext = cursor.getString(cursor.getColumnIndex("utext"));
                String uicon = cursor.getString(cursor.getColumnIndex("uicon"));
                user = new User(uid, uname, upasswd, utel, utext, uicon);
            }
            cursor.close();
        }
        return user;
    }

    public int userLogin(String name, String password) {
        Cursor cursor = db.query("user", null, "uname=?" + " and " + "upasswd=?", new String[]{name, password}, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            return cursor.getInt(cursor.getColumnIndex("uid"));
        } else {
            return -1;
        }
    }
}
