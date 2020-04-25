package au.edu.unsw.infs3634.assignmentui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import au.edu.unsw.infs3634.assignmentui.db.QuestionDao;


public class LoginActivity extends AppCompatActivity {


    EditText mMobileEt;
    EditText mPwdEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mMobileEt = findViewById(R.id.mMobileEt);
        mPwdEt = findViewById(R.id.mPwdEt);
        findViewById( R.id.mRegisterTv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        findViewById( R.id.btLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mMobileEt.getText().toString();
                String pwd = mPwdEt.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    return;
                }

                int id = QuestionDao.getInstance(LoginActivity.this).userLogin(name, pwd);
                if (id != -1) {
                    SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
                    sp.edit().putInt("id",id).commit();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }





}
