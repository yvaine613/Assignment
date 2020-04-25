package au.edu.unsw.infs3634.assignmentui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseLanguage extends AppCompatActivity {
    public static final String EXTRA_MESSAGE1 = "au.edu.unsw.infs3634.assignmentui";
    private ImageButton Learning;
    private ImageButton Quiz;
    private ImageButton Search;
    private ImageButton Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        Intent intent = getIntent();
        String message = intent.getStringExtra(GuideActivity.EXTRA_MESSAGE);
        Learning = findViewById(R.id.imageButton9);
        Quiz = findViewById(R.id.imageButton10);
        Search = findViewById(R.id.imageButton11);
        Profile = findViewById(R.id.imageButton12);

        Learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage1(EXTRA_MESSAGE1);

            }
        });
        Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage2(EXTRA_MESSAGE1);

            }
        });


    }

    public void sendMessage1(String message) {
        Intent intent = new Intent(this, ChooseLanguage.class);
        intent.putExtra(EXTRA_MESSAGE1, message);
        startActivity(intent);

    }

    public void sendMessage2(String message) {
        Intent intent = new Intent(this, QuizPage.class);
        intent.putExtra(EXTRA_MESSAGE1, message);
        startActivity(intent);

    }

}

