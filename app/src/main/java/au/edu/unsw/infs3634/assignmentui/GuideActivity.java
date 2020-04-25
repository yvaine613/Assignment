package au.edu.unsw.infs3634.assignmentui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class GuideActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE ="au.edu.unsw.infs3634.assignmentui";
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        button = findViewById(R.id.Start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(EXTRA_MESSAGE);

            }
        });
    }
    public void sendMessage(String message) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
    }

