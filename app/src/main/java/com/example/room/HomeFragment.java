package com.example.room;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.btnAddUser) Button btnAddUser;
    @BindView(R.id.btnViewUser) Button btnViewUser;
    @BindView(R.id.btnUpdateUser) Button btnUpdateUser;
    @BindView(R.id.btnDeleteUser) Button btnDeleteUser;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,view);
        btnAddUser.setOnClickListener(this);
        btnViewUser.setOnClickListener(this);
        btnUpdateUser.setOnClickListener(this);
        btnDeleteUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.btnAddUser:
                fragment=new AddUserFragment();
                break;
            case R.id.btnViewUser:
                fragment=new ReadUserFragment();
                break;
            case R.id.btnUpdateUser:
                Toast.makeText(getActivity(),"Delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDeleteUser:
                fragment=new DeleteFragment();
                break;
        }
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
    }
}
