package com.example.neighbourly_neeraj_atg.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.neighbourly_neeraj_atg.R;

public class Show_Location_Fragment extends Fragment {

    RelativeLayout Rest_of_Popup_are;


    public Show_Location_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show__location_, container, false);

        Rest_of_Popup_are = view.findViewById(R.id.rest_of_popup_alpha);


        Rest_of_Popup_are.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(Show_Location_Fragment.this).commit();
            }
        });

        return view;
    }
}