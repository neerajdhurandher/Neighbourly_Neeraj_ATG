package com.example.neighbourly_neeraj_atg.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.neighbourly_neeraj_atg.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Show_Post_Details_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Show_Post_Details_Fragment extends Fragment {

    Button Answer_Button;
    ImageView Send_Button,User_Image_Type_Answer;
    EditText Type_Answer_ET;
    TextView Location_TextView;
    RelativeLayout Type_Answer_Layout;
    String Typed_Content = "";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Show_Post_Details_Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Show_Post_Details_Fragment newInstance(String param1, String param2) {
        Show_Post_Details_Fragment fragment = new Show_Post_Details_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Answer_Button = container.findViewById(R.id.type_answer_btn);
        Type_Answer_Layout = container.findViewById(R.id.type_answer_layout);
        Send_Button = container.findViewById(R.id.answer_send_btn);
        Type_Answer_ET = container.findViewById(R.id.answer_text);
        Location_TextView = container.findViewById(R.id.show_location_tv);
        User_Image_Type_Answer = container.findViewById(R.id.user_image_type_answer);
        Type_Answer_Layout.setVisibility(View.GONE);
        Send_Button.setVisibility(View.GONE);
        Location_TextView.setVisibility(View.GONE);

        Typed_Content = Type_Answer_ET.getText().toString();

        if(!Typed_Content.equals("")) {
            Send_Button.setVisibility(View.VISIBLE);
            Location_TextView.setVisibility(View.VISIBLE);
            Send_Button.setVisibility(View.GONE);
            Location_TextView.setVisibility(View.GONE);
        }

        else{
            Send_Button.setVisibility(View.GONE);
            Location_TextView.setVisibility(View.GONE);
            Send_Button.setVisibility(View.GONE);
            Location_TextView.setVisibility(View.VISIBLE);
        }



        Answer_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Type_Answer_Layout.setVisibility(View.VISIBLE);
            }
        });



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show__post__details_, container, false);
    }
}