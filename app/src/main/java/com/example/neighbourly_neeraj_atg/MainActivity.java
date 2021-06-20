package com.example.neighbourly_neeraj_atg;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.neighbourly_neeraj_atg.Fragments.Show_Location_Fragment;
import com.example.neighbourly_neeraj_atg.Fragments.Show_Post_Details_Fragment;
import com.example.neighbourly_neeraj_atg.Fragments.Show_Post_Option_Fragment;

public class MainActivity extends AppCompatActivity {


    ImageView Location_Btn,Search_Btn;
    Button Post_Btn;
    FrameLayout Fragment_Container;
    CardView CardView1,CardView2,CardView3,CardView4;
    ScrollView All_Post_ScrollView;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView1 = findViewById(R.id.card_view_1);
        CardView2 = findViewById(R.id.card_view_2);
        CardView3 = findViewById(R.id.card_view_3);
        CardView4 = findViewById(R.id.card_view_4);

        Location_Btn = findViewById(R.id.location_btn);
        Search_Btn = findViewById(R.id.search_btn);
        Post_Btn = findViewById(R.id.post_btn);
        All_Post_ScrollView = findViewById(R.id.All_Post_ScrollView);
        Fragment_Container = findViewById(R.id.show_popup_frg);
        Fragment_Container.setVisibility(View.GONE);


        getSupportActionBar().hide();

        if(Fragment_Container == null  ) {

            Fragment_Container.setVisibility(View.GONE);
        }

        All_Post_ScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                /*
                Log.d("scroll", "scroll x : " + String.valueOf(scrollX));
                Log.d("scroll", "scroll y : " +  String.valueOf(scrollY));
                Log.d("scroll", "scroll O x : " +  String.valueOf(oldScrollX));
                Log.d("scroll", "scroll O y : " +  String.valueOf(oldScrollY));

                */

//                All_Post_ScrollView.scrollToDescendant(CardView1);

            }
        });

//        All_Post_ScrollView.setFocusableInTouchMode(true);
//        All_Post_ScrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);



        CardView1.setNextFocusDownId(R.id.card_view_2);

        CardView2.setNextFocusDownId(R.id.card_view_3);
        CardView2.setNextFocusUpId(R.id.card_view_1);

        CardView3.setNextFocusDownId(R.id.card_view_4);
        CardView3.setNextFocusUpId(R.id.card_view_2);



        Location_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_Container.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction().add(Fragment_Container.getId(),new Show_Location_Fragment(),"set_frg").commit();


//                if(Fragment_Container != null) {
//
//                    if (savedInstanceState != null)
//                        return;
//
//                    getSupportFragmentManager().beginTransaction().add(Fragment_Container.getId(),new Show_Location_Fragment(),"set_frg").commit();
//
//
//                }
            }
        });

        Post_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_Container.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction().add(Fragment_Container.getId(),new Show_Post_Option_Fragment(),"set_frg").commit();

//                if(Fragment_Container != null) {
//
//                    if (savedInstanceState != null)
//                        return;
//
//                    getSupportFragmentManager().beginTransaction().add(Fragment_Container.getId(),new Show_Post_Option_Fragment(),"set_frg").commit();
//
//
//                }
            }
        });


        CardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_Container.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction().add(Fragment_Container.getId(),new Show_Post_Details_Fragment(),"set_frg").commit();

            }
        });


    }
}