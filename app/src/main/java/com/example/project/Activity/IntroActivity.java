package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.R;

public class IntroActivity extends AppCompatActivity
{
        /*======<<<<------ DECLARATION ------>>>>============*/
        private ConstraintLayout startbtnsign,startBtnlog,adminBtn;
        /*======<<<<------ DECLARATION BAR ------>>>>============*/

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
        /*======<<<<------------ INITIALISATION ----------->>>>============*/
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_intro);
            adminBtn=findViewById(R.id.adminBtn);
            startbtnsign=findViewById(R.id.startbtnsign);
            startBtnlog=findViewById(R.id.startbtnlog);
        /*======<<<<------------- INITIALISATION ---------->>>>============*/


        /*======<<<<------ REDIRECT TO ADMINACTIVITY ------>>>>============*/
            adminBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent=new Intent(IntroActivity.this,AdminActivity.class);
                    startActivity(intent);
                }
            });
        /*======<<<<------ REDIRECT TO ADMINACTIVITY ------>>>>============*/


        /*======<<<<------ REDIRECT TO ADMINACTIVITY ------>>>>============*/
            startbtnsign.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent=new Intent(IntroActivity.this,SignupActivity.class);
                    startActivity(intent);
                }
            });
        /*======<<<<------ REDIRECT TO ADMINACTIVITY ------>>>>============*/


        /*======<<<<------ REDIRECT TO ADMINACTIVITY ------>>>>============*/
            startBtnlog.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent=new Intent(IntroActivity.this,SigninActivity.class);
                    startActivity(intent);
                }
            });
        /*======<<<<------ REDIRECT TO ADMINACTIVITY ------>>>>============*/
        }
}