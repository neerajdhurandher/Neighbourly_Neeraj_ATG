package com.example.neighbourly_neeraj_atg.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neighbourly_neeraj_atg.OnSwipeTouchListener;
import com.example.neighbourly_neeraj_atg.R;

public class Show_Post_Details_Fragment extends Fragment implements  View.OnTouchListener {

    Button Answer_Button;
    ImageView ImageView,Send_Button,User_Image_Type_Answer,show_post_cancel_btn;
    EditText Type_Answer_ET;
    TextView Location_TextView;
    RelativeLayout Type_Answer_Layout,Basic_Info_Layout,image_relative_layout;
    String Typed_Content = "";

    CardView Post_Details_CardView_Layout;
    ConstraintLayout full_constraint_Layout;
    Animation Anim_Swipe_Down;

    float firstX_point, firstY_point;



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
        full_constraint_Layout = view.findViewById(R.id.full_constraint_Layout);
        User_Image_Type_Answer = view.findViewById(R.id.user_image_type_answer);
        show_post_cancel_btn = view.findViewById(R.id.show_post_cancel_btn);
        image_relative_layout = view.findViewById(R.id.image_relative_layout);
        Post_Details_CardView_Layout = view.findViewById(R.id.Post_Details_CardView_Layout);

        Anim_Swipe_Down = AnimationUtils.loadAnimation(getActivity(),R.anim.layout_down_swipe_animation);


        Answer_Button.setVisibility(View.VISIBLE);
        Type_Answer_Layout.setVisibility(View.GONE);
        Send_Button.setVisibility(View.GONE);
        Location_TextView.setVisibility(View.GONE);

        Anim_Swipe_Down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {

                getActivity().getSupportFragmentManager().beginTransaction().remove(Show_Post_Details_Fragment.this).commit();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


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


        image_relative_layout.setOnTouchListener(new OnSwipeTouchListener(getActivity().getApplicationContext()){

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Log.d("swipe","right");
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                Log.d("swipe","left");
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Log.d("swipe","up");
            }


            @Override
            public void onSwipeDown() {
                super.onSwipeDown();

                Log.d("swipe","down");
            }
        });


        Post_Details_CardView_Layout.setOnTouchListener(this);


        return view;
    }


    private void Text_Check() {

        Typed_Content = Type_Answer_ET.getText().toString();

        if(!Typed_Content.equals("")) {

            Location_TextView.setVisibility(View.VISIBLE);
            Send_Button.setVisibility(View.VISIBLE);
            User_Image_Type_Answer.setVisibility(View.GONE);


        }

        else{
            Send_Button.setVisibility(View.GONE);
            Location_TextView.setVisibility(View.GONE);
            User_Image_Type_Answer.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int action = event.getAction();

        switch (action) {

            case MotionEvent.ACTION_DOWN:
                firstX_point = event.getRawX();
                firstY_point = event.getRawY();

                break;

            case MotionEvent.ACTION_UP:

                float finalX = event.getRawX();
                float finalY = event.getRawY();

                int distanceX = (int) (finalX - firstX_point);
                int distanceY = (int) (finalY - firstY_point);

                if (Math.abs(distanceX) > Math.abs(distanceY)) {
                    if ((firstX_point < finalX)) {
                        Log.d("Test", "Left to Right swipe performed");
                    } else {
                        Log.d("Test", "Right to Left swipe performed");
                    }
                }else{
                    if ((firstY_point < finalY)) {
                        Log.d("Test", "Up to Down swipe performed");
                        Post_Details_CardView_Layout.startAnimation(Anim_Swipe_Down);

                    } else {
                        Log.d("Test", "Down to Up swipe performed");
                    }
                }


                break;
        }


        return true;
    }
}