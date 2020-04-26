package au.edu.unsw.infs3634.assignmentui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class LessonActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private LessonAdapter adapter;
    private List<String> list = new ArrayList<>();
    private String mLanguage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        mLanguage = getIntent().getStringExtra("Language");
        initLesson();
        recyclerview =findViewById(R.id.recyclerview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Lesson");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LessonAdapter(this,list);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new LessonAdapter.ItemClickListener() {
            @Override
            public void setOnItemClickListener(int position) {
                Intent intent = new Intent(LessonActivity.this,StudyActivity.class);
                intent.putExtra("Language",mLanguage);
                intent.putExtra("type",list.get(position));
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
    //create listview
    private void initLesson() {
        list.add("Food");
        list.add("Fruits");
        list.add("Sports");
        list.add("Animals");
        list.add("Weather");
        list.add("Body Parts");
        list.add("Colors");
        list.add("Aquarium");
        list.add("Family");
        list.add("Jobs");
    }


}
