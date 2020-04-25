package au.edu.unsw.infs3634.assignmentui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.Toolbar;
import au.edu.unsw.infs3634.assignmentui.db.QuestionDao;
import au.edu.unsw.infs3634.assignmentui.db.User;


public class RegisterActivity extends AppCompatActivity {

    private EditText etWriteName;
    private EditText etPhone;
    private EditText etWritePwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Lesson");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        etWriteName = findViewById(R.id.et_write_name);
        etPhone = findViewById(R.id.et_phone);
        etWritePwd = findViewById(R.id.et_write_pwd);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etWriteName.getText().toString();
                String phone = etPhone.getText().toString();
                String pwd = etWritePwd.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    return;
                }
                User user = new User(name, pwd, phone,"", "") ;
                if (QuestionDao.getInstance(RegisterActivity.this).registerUser(user)){
                    showToast("success");
                    finish();
                }else{
                    showToast("failed");
                }
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


    public void showToast(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
}
