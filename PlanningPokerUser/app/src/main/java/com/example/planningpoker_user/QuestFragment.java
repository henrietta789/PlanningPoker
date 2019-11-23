package com.example.planningpoker_user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuestFragment extends Fragment {

    TextView question_tv;
    Button send_bt;
    RecyclerView buttons_rv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttons_rv=getView().findViewById(R.id.Butt_recyView);
        question_tv=getView().findViewById(R.id.quest_textView);
        send_bt=getView().findViewById(R.id.send_button);

    }
}
