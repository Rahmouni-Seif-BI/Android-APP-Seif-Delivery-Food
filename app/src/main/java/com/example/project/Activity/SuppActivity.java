package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.Toast;

import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SuppActivity extends AppCompatActivity
{
    /*======<<<<------ DECLARATION  ------>>>>============*/
        private LinearLayout home,profile,settingsBtn;
        private EditText Tavis,Trate;
        private ImageView information,callcenter;
        private String namedb;
        private DBHelper DB;
        private ConstraintLayout feedback;
    /*======<<<<------ /DECLARATION  ------>>>>============*/


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supp);

        /*======<<<<------ SHAKE IMAGE  ------>>>>============*/
            onShakeImage();
        /*======<<<<------ /SHAKE IMAGE  ------>>>>============*/



        /*======<<<<------ /INITIALISATION  ------>>>>============*/
            namedb=getIntent().getStringExtra("name");
            information=(ImageView)findViewById(R.id.infoimg);
            Tavis=findViewById(R.id.avis);
            Trate=findViewById(R.id.rate);
            feedback = findViewById(R.id.feddback);
            home=(LinearLayout) findViewById(R.id.homeBtn);
            profile=(LinearLayout) findViewById(R.id.profileBtn);
            DB = new DBHelper(this);
            settingsBtn=(LinearLayout) findViewById(R.id.settingsbBtn);
            callcenter=(ImageView)findViewById(R.id.callimg) ;
            FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        /*======<<<<------ /INITIALISATION  ------>>>>============*/








        /*======<<<<------ IMPLICIT INTENT TO OPEN CALL APP  ------>>>>============*/
            callcenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String phone = "53012600";
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
                }
            });
        /*======<<<<------ /IMPLICIT INTENT TO OPEN CALL APP  ------>>>>============*/



        /*======<<<<------ IMPLICIT INTENT TO OPEN INSTAGRAM APP  ------>>>>============*/
            information.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    String url="https://www.instagram.com/seif_rahmounii/";
                    // An implicit intent, request a URL.
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    startActivity(intent);
                }
        /*======<<<<------ IMPLICIT INTENT TO OPEN INSTAGRAM APP  ------>>>>============*/

        });



        /*======<<<<------ NAVIGATION BAR ------>>>>============*/
        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(SuppActivity.this, CartListActivity.class);
                i.putExtra("name",namedb);
                startActivity(i);
            }
        });

        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent i = new Intent(SuppActivity.this, MainActivity.class);
                i.putExtra("name",namedb);

                startActivity(i);
            }
        });

        profile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(SuppActivity.this, ProfileActivity.class);
                i.putExtra("name",namedb);

                startActivity(i);
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(SuppActivity.this, SettingsActivity.class);
                i.putExtra("name",namedb);

                startActivity(i);
            }
        });
        /*======<<<<------ /NAVIGATION BAR  ------>>>>============*/



        /*======<<<<------ FEED BACK SCRIPT  ------>>>>============*/
            feedback.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {

                    String avis = Tavis.getText().toString();
                    String rate = Trate.getText().toString();

                    if (avis.equals("") || rate.equals(""))
                        Toast.makeText(SuppActivity.this, "Please enter all  the fields", Toast.LENGTH_SHORT).show();
                    else {

                        Boolean insert = DB.insertDataAvis(avis, rate);

                        if (insert == true) // verification  lel  insert saret ou nn  + redirect to welcome activity
                        {
                            Toast.makeText(SuppActivity.this, "Feed back successfully sent", Toast.LENGTH_SHORT).show();
                            Tavis.setText("");
                            Trate.setText("");

                        } else {
                            Toast.makeText(SuppActivity.this, "Registrred Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            });
        /*======<<<<------ /FEED BACK SCRIPT  ------>>>>============*/




        }

        /*======<<<<------ SHAKE SCRIPT  ------>>>>============*/
        public void onShakeImage()
            {        ImageView image;
                image = (ImageView) findViewById(R.id.callimg);
                RotateAnimation rotate = new RotateAnimation(0, 10,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setRepeatCount(1000);
                rotate.setDuration(550);
                rotate.setStartOffset(3000);
                rotate.setRepeatMode(Animation.REVERSE);
                rotate.setInterpolator(new CycleInterpolator(3));
                image.startAnimation(rotate);

            }
        /*======<<<<------ /SHAKE SCRIPT  ------>>>>============*/
}