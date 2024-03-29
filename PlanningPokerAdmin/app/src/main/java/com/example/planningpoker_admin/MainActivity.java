package com.example.planningpoker_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction frag_login = getSupportFragmentManager().beginTransaction();
        frag_login.replace(R.id.fragment_container,new LoginFragment());
        frag_login.commit();
    }
}
