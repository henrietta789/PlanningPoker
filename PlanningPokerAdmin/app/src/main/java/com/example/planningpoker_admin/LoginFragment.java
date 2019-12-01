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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.view.View.GONE;


public class LoginFragment extends Fragment {

    EditText name, group;
    Button login;
    DatabaseReference db;

    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login, container, false);
        name=v.findViewById(R.id.name_editText);
        group=v.findViewById(R.id.gp_editText);
        login=v.findViewById(R.id.login_button);
        db=FirebaseDatabase.getInstance().getReference().child("Poker");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLogin();
                FragmentTransaction frag_quest = getFragmentManager().beginTransaction();
                frag_quest.replace(R.id.fragment_container,new questFragment());
                frag_quest.commit();
            }
        });
        return v;
    }
    private void addLogin(){
        name=getView().findViewById(R.id.name_editText);
        String Name=name.getText().toString();

        group=getView().findViewById(R.id.gp_editText);
        String GpName=group.getText().toString();


        Fire_Form form = new Fire_Form(Name,GpName);
        //db.child("groups").child(Name).setValue(group);
        //db.child("name").child(GpName).setValue(name);
        db.push().setValue(form);

        Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();
    }
}
