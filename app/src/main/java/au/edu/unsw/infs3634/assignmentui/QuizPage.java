package au.edu.unsw.infs3634.assignmentui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPage extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_quiz);
        Intent intent = getIntent();
        String message = intent.getStringExtra(ChooseLanguage.EXTRA_MESSAGE1);
    }
    }
