package au.edu.unsw.infs3634.assignmentui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import au.edu.unsw.infs3634.assignmentui.db.QuestionDao;
import au.edu.unsw.infs3634.assignmentui.db.User;

public class ProfileFragment extends Fragment {

    private View view;
    private TextView tv_username;
    private TextView tv_tel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        view  =  inflater.inflate(R.layout.profile,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_username =  view.findViewById(R.id.tv_username);
        tv_tel =  view.findViewById(R.id.tv_tel);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sp =getActivity(). getSharedPreferences("user", Context.MODE_PRIVATE);
        int id = sp.getInt("id", 0);
        User user = QuestionDao.getInstance(getActivity()).getUserInfoById(id);
        tv_username.setText(user.getUname());
        tv_tel.setText(user.getUtel());
    }
}
