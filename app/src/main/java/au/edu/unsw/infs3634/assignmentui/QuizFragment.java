package au.edu.unsw.infs3634.assignmentui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment implements View.OnClickListener {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        view  =  inflater.inflate(R.layout.detail_quiz,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.iv_french).setOnClickListener(this);
        view.findViewById(R.id.iv_germany).setOnClickListener(this);
        view.findViewById(R.id.iv_korean).setOnClickListener(this);
        view.findViewById(R.id.iv_yen).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.iv_french:
                intent = new Intent(getActivity(),ExamActivity.class);
                intent.putExtra("Language","French");
                startActivity(intent);
                break;
            case R.id.iv_germany:
                intent = new Intent(getActivity(),ExamActivity.class);
                intent.putExtra("Language","Germany");
                startActivity(intent);
                break;
            case R.id.iv_korean:
                intent = new Intent(getActivity(),ExamActivity.class);
                intent.putExtra("Language","Korean");
                startActivity(intent);
                break;
            case R.id.iv_yen:
                intent = new Intent(getActivity(),ExamActivity.class);
                intent.putExtra("Language","Japanese");
                startActivity(intent);
                break;
        }
    }
}
