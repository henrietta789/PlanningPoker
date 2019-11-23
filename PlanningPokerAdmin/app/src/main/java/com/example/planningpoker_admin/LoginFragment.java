package com.example.planningpoker_admin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.view.View.GONE;


public class LoginFragment extends Fragment {

    EditText name, psw;
    Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        login=getView().findViewById(R.id.name_editText);
        psw=getView().findViewById(R.id.psw_editText);
        login=getView().findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction frag_quest = getFragmentManager().beginTransaction();
                frag_quest.replace(R.id.fragment_container,new LoginFragment());
                frag_quest.commit();
                }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}
