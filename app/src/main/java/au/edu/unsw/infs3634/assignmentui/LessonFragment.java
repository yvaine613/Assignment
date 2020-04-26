package au.edu.unsw.infs3634.assignmentui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LessonFragment extends Fragment implements View.OnClickListener {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        view  =  inflater.inflate(R.layout.fragment_lesson,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.GO1).setOnClickListener(this);
        view.findViewById(R.id.GO2).setOnClickListener(this);
        view.findViewById(R.id.GO3).setOnClickListener(this);
        view.findViewById(R.id.GO4).setOnClickListener(this);
    }


    @Override
    //switch to different lesson
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.GO1:
                intent = new Intent(getActivity(),LessonActivity.class);
                intent.putExtra("Language","French");
                startActivity(intent);
                break;
            case R.id.GO2:
                intent = new Intent(getActivity(),LessonActivity.class);
                intent.putExtra("Language","German");
                startActivity(intent);
                break;
            case R.id.GO3:
                intent = new Intent(getActivity(),LessonActivity.class);
                intent.putExtra("Language","Korean");
                startActivity(intent);
                break;
            case R.id.GO4:
                intent = new Intent(getActivity(),LessonActivity.class);
                intent.putExtra("Language","Japanese");
                startActivity(intent);
                break;
        }
    }
}
