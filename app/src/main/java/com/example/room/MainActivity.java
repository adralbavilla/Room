package com.example.room;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager= getSupportFragmentManager();

        userDatabase = Room.databaseBuilder(getApplicationContext(),UserDatabase.class,"userdb").allowMainThreadQueries().build();

        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();
    }
}
