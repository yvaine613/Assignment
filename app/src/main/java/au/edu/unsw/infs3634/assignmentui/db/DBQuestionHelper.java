package au.edu.unsw.infs3634.assignmentui.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBQuestionHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "question.db";
    private static final int DATABASE_VERSION = 1;

    String question = "create table question ("
            + "id integer primary key autoincrement, "
            + "name VARCHAR, "
            + "english VARCHAR, "
            + "type VARCHAR, "
            + "language VARCHAR)";
    public static final String comment = "create table comment ("
            + "id integer primary key autoincrement, "
            + "type VARCHAR, "
            + "language VARCHAR, "
            + "content VARCHAR, "
            + "time VARCHAR)";
    String user = "create table user ("
            + "uid integer primary key autoincrement, "
            + "uname VARCHAR, "
            + "upasswd VARCHAR, "
            + "utel VARCHAR, "
            + "utext VARCHAR, "
            + "uicon VARCHAR)";
    public DBQuestionHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        db.execSQL(question);
        db.execSQL(comment);
        db.execSQL(user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }

}
