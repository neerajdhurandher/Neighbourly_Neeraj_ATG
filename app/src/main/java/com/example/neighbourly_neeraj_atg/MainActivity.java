package com.example.neighbourly_neeraj_atg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.neighbourly_neeraj_atg.Fragments.Show_Location_Fragment;
import com.example.neighbourly_neeraj_atg.Fragments.Show_Post_Option_Fragment;

public class MainActivity extends AppCompatActivity {


    ImageView Location_Btn,Search_Btn;
    Button Post_Btn;
    FrameLayout Fragment_Container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Location_Btn = findViewById(R.id.location_btn);
        Search_Btn = findViewById(R.id.search_btn);
        Post_Btn = findViewById(R.id.post_btn);
        Fragment_Container = findViewById(R.id.show_popup_frg);



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


    }
}