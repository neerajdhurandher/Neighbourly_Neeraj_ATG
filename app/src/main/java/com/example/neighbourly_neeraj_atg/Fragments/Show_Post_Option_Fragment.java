package com.example.neighbourly_neeraj_atg.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.neighbourly_neeraj_atg.MainActivity;
import com.example.neighbourly_neeraj_atg.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class Show_Post_Option_Fragment extends Fragment {

    ImageView Cancel_Button,Post_Image;
    LinearLayout Post_Linear_Layout;


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