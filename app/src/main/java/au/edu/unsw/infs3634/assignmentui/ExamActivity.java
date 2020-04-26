package au.edu.unsw.infs3634.assignmentui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import au.edu.unsw.infs3634.assignmentui.api.JokeActivity;
import au.edu.unsw.infs3634.assignmentui.db.Question;
import au.edu.unsw.infs3634.assignmentui.db.QuestionDao;

public class ExamActivity extends AppCompatActivity implements View.OnClickListener {

    int position = 0;
    TextView tvQuestion;
    private List<Question> exams;
    TextView ivFirst;
    TextView ivSecond;
    TextView ivThree;
    TextView ivFour;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        String mLanguage = getIntent().getStringExtra("Language");
        Toolbar toolbar = findViewById(R.id.toolbar);
        tvQuestion = findViewById(R.id.tv_question);
        ivFirst = findViewById(R.id.iv_first);
        ivSecond = findViewById(R.id.iv_second);
        ivThree = findViewById(R.id.iv_three);
        ivFour = findViewById(R.id.iv_four);
        toolbar.setTitle("Quiz");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        exams = QuestionDao.getInstance(this).loadQuestion(mLanguage);
        init();
        findViewById(R.id.iv_first).setOnClickListener(this);
        findViewById(R.id.iv_second).setOnClickListener(this);
        findViewById(R.id.iv_three).setOnClickListener(this);
        findViewById(R.id.iv_four).setOnClickListener(this);
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
                .setTitle("Tips")
                .setMessage("Test Results")
                .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(ExamActivity.this,QuestionResultActivity.class);
                        intent.putExtra("data", (Serializable) exams);
                        startActivity(intent);
                        finish();

                    }
                }).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        }).create().show();
    }
    private void init() {
        if (position>9){
            show();
            return;
        }
        //fill the block
        Question data = exams.get(position);
        tvQuestion.setText((position+1)+". " +data.getName());
        ArrayList<String> list = new ArrayList<>();
        list.add(data.getEnglish());
        Random random = new Random();
        while (list.size() < 4) {
            Question randomData = exams.get(random.nextInt(exams.size()));
            boolean has=false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(randomData.getEnglish())){
                    has = true;
                }
            }
            if (!has){
                list.add(randomData.getEnglish());
            }
        }
        Collections.sort(list);
        ivFirst.setText(list.get(0));
        ivSecond.setText(list.get(1));
        ivThree.setText(list.get(2));
        ivFour.setText(list.get(3));
    }


    @Override
    //get the answer from students
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_first:
                if (position>=exams.size()){
                    show();
                    return;
                }else{
                    String answer = ivFirst.getText().toString();
                    exams.get(position).setAnswer(answer);
                    position++;
                    init();
                }


                break;
            case R.id.iv_second:
                if (position>=exams.size()){
                    show();
                    return;
                }else{
                    String answer = ivSecond.getText().toString();
                    exams.get(position).setAnswer(answer);
                    position++;
                    init();
                }

                break;
            case R.id.iv_three:
                if (position>=exams.size()){
                    show();
                    return;
                }else{
                   String answer = ivThree.getText().toString();
                    exams.get(position).setAnswer(answer);

                    position++;
                    init();
                }

                break;
            case R.id.iv_four:
                if (position>=exams.size()){
                    show();
                    return;
                }else{
                    String answer = ivFour.getText().toString();
                    exams.get(position).setAnswer(answer);
                    position++;
                    init();
                }

                break;

        }
    }
}
