package com.example.planningpoker_user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {

    EditText name_et;
    EditText psw_et;
    Button login_btn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name_et=getView().findViewById(R.id.name_editText);
        psw_et=getView().findViewById(R.id.psw_editText);
        login_btn=getView().findViewById(R.id.login_button);


    }
}
