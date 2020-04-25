package au.edu.unsw.infs3634.assignmentui.api;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import au.edu.unsw.infs3634.assignmentui.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokeActivity extends AppCompatActivity {

    private TextView tvJoke;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        tvJoke = findViewById(R.id.tv_joke);
        dialog = new ProgressDialog(this);
        getData();
        findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Joke");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    private void getData(){
        dialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JokeService jokeService =   retrofit.create(JokeService.class);
        Call<JokeResponse> callJoke = jokeService.getJoke("dev");
        callJoke.enqueue(new Callback<JokeResponse>() {
            @Override
            public void onResponse(Call<JokeResponse> call, Response<JokeResponse> response) {
                dialog.dismiss();
                if (response.isSuccessful()){
                    JokeResponse jokeResponse = response.body();
                    tvJoke.setText(jokeResponse.getValue());
                }
            }

            @Override
            public void onFailure(Call<JokeResponse> call, Throwable t) {
                dialog.dismiss();
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
}
