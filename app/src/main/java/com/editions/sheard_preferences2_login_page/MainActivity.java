package com.editions.sheard_preferences2_login_page;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //code here====

                SharedPreferences sharedPreferences= getSharedPreferences("Login", MODE_PRIVATE);


                Boolean check= sharedPreferences.getBoolean("data", Boolean.parseBoolean("false"));

                Intent myNext;
                if (check){// if (ckeck) is true go to the HomeActivity

                   myNext=  new Intent(MainActivity.this, HomeActivity.class);

                }else { // if (ckeck) is false go to the Login Activity

                    myNext= new Intent(MainActivity.this, LoginActivity.class);
                }// if, else end here=================

                startActivity(myNext);

            }
        },4000);//4000 milliseconds = 4 seconds




    }
}