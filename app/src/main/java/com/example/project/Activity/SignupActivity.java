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

public class SignupActivity extends AppCompatActivity
{
    /*======<<<<------ DECLARATION  ------>>>>============*/

    /*======<<<<------ /DECLARATION  ------>>>>============*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


    /*======<<<<------ INITIALISATION  ------>>>>============*/
        EditText username, password, repassword,jobText;
        ConstraintLayout signup;
        DBHelper DB;
        jobText = findViewById(R.id.job);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        signup = (ConstraintLayout) findViewById(R.id.btnsignup);
        DB = new DBHelper(this);
    /*======<<<<------ /INITIALISATION  ------>>>>============*/


    /*======<<<<------ SIGN UP SCRIPT  ------>>>>============*/
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String jobs = jobText.getText().toString();


                if (user.equals("") || pass.equals("") || repassword.equals("") || jobs.equals(""))
                    Toast.makeText(SignupActivity.this, "Please enter all  the fields", Toast.LENGTH_SHORT).show();
                else
                {
                    if (pass.equals(repass))
                    {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) // if user  moch mawjoud in the base add it
                        {
                            Boolean insert = DB.insertData(user, pass, jobs);
                            if (insert == true) // verification  lel  insert saret ou nn  + redirect to welcome activity
                                {
                                    Toast.makeText(SignupActivity.this, "Registrred successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                                    startActivity(intent);
                                }
                            else
                                {
                                Toast.makeText(SignupActivity.this, "Registrred Failed", Toast.LENGTH_SHORT).show();
                                }
                        }
                        else
                            {
                            Toast.makeText(SignupActivity.this, "user Already  exist please sign in ", Toast.LENGTH_SHORT).show();
                            }
                    }
                    else
                        {
                        Toast.makeText(SignupActivity.this, "Password  not matching", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });
    /*======<<<<------ /SIGN UP SCRIPT  ------>>>>============*/

    }
}


