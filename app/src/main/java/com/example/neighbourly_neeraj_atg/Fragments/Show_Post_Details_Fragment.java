package com.example.neighbourly_neeraj_atg.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neighbourly_neeraj_atg.OnSwipeTouchListener;
import com.example.neighbourly_neeraj_atg.R;

public class Show_Post_Details_Fragment extends Fragment {

    Button Answer_Button;
    ImageView ImageView,Send_Button,User_Image_Type_Answer,show_post_cancel_btn;
    EditText Type_Answer_ET;
    TextView Location_TextView;
    RelativeLayout Type_Answer_Layout,Basic_Info_Layout;
    String Typed_Content = "";

    CardView Post_Details_CardView_Layout;



    public Show_Post_Details_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show__post__details_, container, false);
        ImageView = view.findViewById(R.id.imageView);
        Answer_Button = view.findViewById(R.id.type_answer_btn);
        Type_Answer_Layout = view.findViewById(R.id.type_answer_layout);
        Send_Button = view.findViewById(R.id.answer_send_btn);
        Type_Answer_ET = view.findViewById(R.id.answer_text);
        Location_TextView = view.findViewById(R.id.show_location_tv);
        Basic_Info_Layout = view.findViewById(R.id.basic_info_layout);
        User_Image_Type_Answer = view.findViewById(R.id.user_image_type_answer);
        show_post_cancel_btn = view.findViewById(R.id.show_post_cancel_btn);
        Post_Details_CardView_Layout = view.findViewById(R.id.Post_Details_CardView_Layout);

        Answer_Button.setVisibility(View.VISIBLE);

        Type_Answer_Layout.setVisibility(View.GONE);
        Send_Button.setVisibility(View.GONE);
        Location_TextView.setVisibility(View.GONE);



        Type_Answer_ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                Text_Check();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Text_Check();

            }
        });



        Answer_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Answer_Button.setVisibility(View.GONE);
                Type_Answer_Layout.setVisibility(View.VISIBLE);

            }
        });

        show_post_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(Show_Post_Details_Fragment.this).commit();
            }
        });


        ImageView.setOnTouchListener(new OnSwipeTouchListener(getActivity()){

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onSwipeDown() {
                super.onSwipeDown();

                Log.d("swipe","down");
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    private void Text_Check() {

        Typed_Content = Type_Answer_ET.getText().toString();

        if(!Typed_Content.equals("")) {
            Send_Button.setVisibility(View.VISIBLE);
            Location_TextView.setVisibility(View.VISIBLE);

        }

        else{
            Send_Button.setVisibility(View.GONE);
            Location_TextView.setVisibility(View.GONE);
        }
    }
}