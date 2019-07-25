package com.example.room;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {
    @BindView(R.id.display_info) TextView display_info;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        ButterKnife.bind(this,view);
        List<User> users = MainActivity.userDatabase.myDao().getUsers();

        String info="";

        for(User user : users){
            int id = user.getId();
            String userName = user.getName();
            String userEmail = user.getEmail();
            info = info +"\n\n"+"Id: "+ id + "\n"+"Name: "+ userName + "\n"+"Email: "+ userEmail;

        }
        display_info.setText(info);
        return view;
    }

}
