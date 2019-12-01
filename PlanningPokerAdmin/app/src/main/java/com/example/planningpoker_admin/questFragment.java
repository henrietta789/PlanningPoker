package com.example.planningpoker_admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class questFragment extends Fragment {

    EditText quest_et, date_et;
    Button add_btn, answ_btn;
    RecyclerView rck_vw;
    DatabaseReference db;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String mDataset;
    ArrayList<Questions> ques;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_quest, container, false);
        quest_et=v.findViewById(R.id.quest_editText);
        date_et=v.findViewById(R.id.date_editText);
        add_btn=v.findViewById(R.id.add_button);
        answ_btn=v.findViewById(R.id.answ_button);
        rck_vw=v.findViewById(R.id.quest_recyclerView);
        db=FirebaseDatabase.getInstance().getReference().child("Questions");

        answ_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction frag_quest = getFragmentManager().beginTransaction();
                frag_quest.replace(R.id.fragment_container,new AnswFragment());
                frag_quest.commit();
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuestion();
            }
        });
        rck_vw.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this.getActivity());
        rck_vw.setLayoutManager(layoutManager);
        ques=new ArrayList<>();

        adapter=new myAdapter(ques);

        getDataFirebase();


        return  v;
    }

    private void getDataFirebase() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Questions data = dataSnapshot.getValue(Questions.class);

                ques.add(data);
                rck_vw.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void addQuestion() {
        quest_et=getView().findViewById(R.id.quest_editText);
        String question=quest_et.getText().toString();

        date_et=getView().findViewById(R.id.date_editText);
        String date=date_et.getText().toString();

        Questions qu=new Questions(date,question);

        db.push().setValue(qu);

        Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();
    }
}
