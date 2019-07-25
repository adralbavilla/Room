package com.example.room;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {
    @BindView(R.id.userIdDelete) EditText userIdDelete;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.delete)
    public void onClick(){
        int id = Integer.parseInt(userIdDelete.getText().toString());
        User user =new User(id,"","");

        MainActivity.userDatabase.myDao().deleteUser(user);

        Toast.makeText(getActivity(),"Se borro correctamente",Toast.LENGTH_SHORT).show();
    }

}
