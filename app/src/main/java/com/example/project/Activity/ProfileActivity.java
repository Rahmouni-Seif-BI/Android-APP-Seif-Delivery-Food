package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity
{
    /*======<<<<------ DECLARATION  ------>>>>============*/
        private LinearLayout  home,profile,suppBtn,settingsBtn;
        private ConstraintLayout logout ;
        private TextView profiltext;
        private String namedb;
    /*======<<<<------ /DECLARATION ------>>>>============*/


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    /*======<<<<------ /INITIALISATION ------>>>>============*/
        home=findViewById(R.id.homeBtn);
        profile=findViewById(R.id.profileBtn);
        suppBtn = findViewById(R.id.suppBtn);
        settingsBtn= findViewById(R.id.settingsBtn);
        profiltext=(TextView)findViewById(R.id.profiltext);
        logout=findViewById(R.id.logout);
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
    /*======<<<<------ /INITIALISATION ------>>>>============*/


    /*======<<<<------ /SET NAME USER ------>>>>============*/
        namedb=getIntent().getStringExtra("name");
        profiltext.setText(namedb);
    /*======<<<<------ /SET NAME USER ------>>>>============*/




    /*======<<<<------ NAVIGATION BAR  ------>>>>============*/
        /*======<<<<------ REDIRECT TO IntroActivity  ------>>>>============*/
            logout.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent i = new Intent(ProfileActivity.this, IntroActivity.class);
                    startActivity(i);
                }
            });
        /*======<<<<------ /REDIRECT TO IntroActivity  ------>>>>============*/



        /*======<<<<------ REDIRECT TO CartListActivity  ------>>>>============*/
            floatingActionButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent=new Intent(ProfileActivity.this,CartListActivity.class);
                    intent.putExtra("name",namedb);
                    startActivity(intent);

                }
            });
        /*======<<<<------ /REDIRECT TO CartListActivity  ------>>>>============*/




        /*======<<<<------ REDIRECT TO MainActivity  ------>>>>============*/
            home.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent i = new Intent(ProfileActivity.this, MainActivity.class);
                    i.putExtra("name",namedb);
                    startActivity(i);
                }
            });
        /*======<<<<------ /REDIRECT TO MainActivity  ------>>>>============*/



        /*======<<<<------ REDIRECT TO SuppActivity  ------>>>>============*/
            suppBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent=new Intent(ProfileActivity.this,SuppActivity.class);
                    intent.putExtra("name",namedb);
                    startActivity(intent);
                }
            });
        /*======<<<<------ /REDIRECT TO SuppActivity  ------>>>>============*/



        /*======<<<<------ REDIRECT TO SettingsActivity  ------>>>>============*/
            settingsBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent i = new Intent(ProfileActivity.this, SettingsActivity.class);
                    i.putExtra("name",namedb);

                    startActivity(i);
                }
            });
        /*======<<<<------ /REDIRECT TO SettingsActivity  ------>>>>============*/

    /*======<<<<------ /NAVIGATION BAR  ------>>>>============*/

    }
}