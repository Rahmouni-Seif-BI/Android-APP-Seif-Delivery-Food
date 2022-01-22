package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;

public class SigninActivity extends AppCompatActivity
{
        /*======<<<<------ DECLARATION  ------>>>>============*/
            EditText username,password;
            ConstraintLayout btnsigninok;
            DBHelper DB;
        /*======<<<<------ /DECLARATION  ------>>>>============*/

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signin);

        /*======<<<<------ INITIALISATION  ------>>>>============*/
            username = (EditText) findViewById(R.id.username1);
            password = (EditText) findViewById(R.id.pasword1);
            btnsigninok= (ConstraintLayout) findViewById(R.id.btnsigninok);
            DB = new DBHelper(this);
        /*======<<<<------ /INITIALISATION  ------>>>>============*/



        /*======<<<<------ REDIRECTE TO MAINACTIVITY AFTER CHECK  ------>>>>============*/
            btnsigninok.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    if (user.equals("")||pass.equals(""))
                        Toast.makeText(SigninActivity.this,"please enter all the fields",Toast.LENGTH_SHORT).show();
                    else{
                        Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                        if (checkuserpass==true)
                        {
                            Toast.makeText(SigninActivity.this,"Redirecting...",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("name",user);
                            startActivity(intent);
                        }else
                        {
                            Toast.makeText(SigninActivity.this,"Invalide credentials",Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            });
        /*======<<<<------ REDIRECTE TO MAINACTIVITY AFTER CHECK  ------>>>>============*/
        }
}



