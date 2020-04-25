package au.edu.unsw.infs3634.assignmentui;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.edu.unsw.infs3634.assignmentui.db.Comment;
import au.edu.unsw.infs3634.assignmentui.db.QuestionDao;

public class CommentActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private CommentAdapter adapter;
    private List<Comment> list = new ArrayList<>();
    private String mLanguage;
    private String type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        mLanguage = getIntent().getStringExtra("Language");
        type = getIntent().getStringExtra("type");
        recyclerview = findViewById(R.id.recyclerview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Comment");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommentAdapter(this, list);
        recyclerview.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Comment> commentList = QuestionDao.getInstance(this).loadCommentById(type,mLanguage);
        list.clear();
        list.addAll(commentList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
