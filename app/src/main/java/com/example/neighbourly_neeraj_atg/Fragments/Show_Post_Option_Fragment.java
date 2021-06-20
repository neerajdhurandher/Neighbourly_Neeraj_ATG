package com.example.neighbourly_neeraj_atg.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.neighbourly_neeraj_atg.MainActivity;
import com.example.neighbourly_neeraj_atg.R;


public class Show_Post_Option_Fragment extends Fragment {

    ImageView Cancel_Button;

    public Show_Post_Option_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show__post__option_, container, false);

        Cancel_Button = view.findViewById(R.id.post_option_cancel_btn);

        Cancel_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().remove(Show_Post_Option_Fragment.this).commit();

            }
        });

        return view;
    }
}