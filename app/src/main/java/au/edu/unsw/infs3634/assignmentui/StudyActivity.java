package au.edu.unsw.infs3634.assignmentui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import au.edu.unsw.infs3634.assignmentui.api.JokeActivity;
import au.edu.unsw.infs3634.assignmentui.db.Comment;
import au.edu.unsw.infs3634.assignmentui.db.Question;
import au.edu.unsw.infs3634.assignmentui.db.QuestionDao;

public class StudyActivity extends AppCompatActivity {

    int position = 0;
    TextView tvQuestion;
    ImageView ivImg;
    TextView tvEnglish;
    private List<Question> exams;
    private String mLanguage;
    private String type;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
         mLanguage = getIntent().getStringExtra("Language");
         type = getIntent().getStringExtra("type");
        Toolbar toolbar = findViewById(R.id.toolbar);
        tvQuestion = findViewById(R.id.tv_question);
        ivImg = findViewById(R.id.ivImg);
        tvEnglish = findViewById(R.id.tv_english);
        toolbar.setTitle("Study");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        exams = QuestionDao.getInstance(this).loadQuestion(type,mLanguage);
        init();
        findViewById(R.id.bt_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position>=exams.size()){
                    show();
                    return;
                }else{

                    position++;
                    init();
                }
            }
        });
        findViewById(R.id.tv_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyActivity.this,CommentActivity.class);
                intent.putExtra("Language",mLanguage);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    private void show(){
        new AlertDialog.Builder(this)
                .setTitle("Congratulation!")
                .setMessage("Please select an operation")
                .setPositiveButton("Joke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        startActivity(new Intent(StudyActivity.this, JokeActivity.class));
                        finish();
                    }
                }).setNegativeButton("Comment", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addComment();
                dialogInterface.dismiss();
            }
        }).create().show();

    }

    private void addComment() {
        EditText view = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("Comment")
                .setView(view)
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.dismiss();
                        String content = view.getText().toString();
                        if (!TextUtils.isEmpty(content)) {
                            QuestionDao.getInstance(StudyActivity.this).addComment(new Comment(type,mLanguage,content,getNowTime()));
                            startActivity(new Intent(StudyActivity.this, JokeActivity.class));
                            finish();
                        }
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }
    private String getNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date());
    }
    private void init() {
        if (position>=exams.size()){
            show();
            return;
        }
        Question data = exams.get(position);
        tvQuestion.setText((position+1)+". " +data.getName());
        tvEnglish.setText(data.getEnglish());
        setImage(data.getEnglish());

    }

    private void setImage(String english) {
        String[] name = english.split("/");
        String eng = name[0].trim();
        String[] arr = eng.split(" ");
        Bitmap bitmap = null;
        if (arr.length==1){
            bitmap =  getBitmapByName(arr[0].toLowerCase());
        }else if (arr.length>1){
            bitmap =   getBitmapByName(arr[0]+"_"+arr[1].toLowerCase());
        }
        if (bitmap==null){
            ivImg.setVisibility(View.GONE);
        }else{
            ivImg.setVisibility(View.VISIBLE);
            ivImg.setImageBitmap(bitmap);
        }
    }

    public Bitmap getBitmapByName(String name) {
        ApplicationInfo appInfo = getApplicationInfo();
        int resID = getResources().getIdentifier(name, "drawable", appInfo.packageName);
        return BitmapFactory.decodeResource(getResources(), resID);
    }
}
