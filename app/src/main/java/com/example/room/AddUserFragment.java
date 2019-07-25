package com.example.room;


import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddUserFragment extends Fragment {
    @BindView(R.id.userId) EditText userId;
    @BindView(R.id.name) EditText name;
    @BindView(R.id.Email) EditText email;
    @BindView(R.id.btnSave) Button btnSave;

    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btnSave)
    public void onClick(View view){
        int user = Integer.parseInt(userId.getText().toString());
        String nameUser = name.getText().toString();
        String emailUser = email.getText().toString();

        User userObj = new User(user,nameUser,emailUser);

        User existe = MainActivity.userDatabase.myDao().findUserById(user);
        try{
            if(existe !=null){
                Toast.makeText(getActivity(),"Ya existe el Id User",Toast.LENGTH_SHORT).show();
            }
            else{
                MainActivity.userDatabase.myDao().addUser(userObj);
                Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();
                userId.setText("");
                name.setText("");
                email.setText("");
            }
        }catch (Exception ex){
            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
        }

    }

}
