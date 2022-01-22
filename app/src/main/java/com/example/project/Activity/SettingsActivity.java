package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SettingsActivity extends AppCompatActivity
{
        /*======<<<<------ DECLARATION  ------>>>>============*/
        private LinearLayout home,profile,suppBtn,settingsBtn;
        private ConstraintLayout btnupdate,changpass;
        private String namedb;
        private EditText oldp,newp,cnewp;
        DBHelper DB;
        /*======<<<<------ DECLARATION  ------>>>>============*/

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);

        /*======<<<<------ SET NAME USER  ------>>>>============*/
            namedb=getIntent().getStringExtra("name");
        /*======<<<<------ /SET NAME USER  ------>>>>============*/


        /*======<<<<------ INITIALISATION  ------>>>>============*/
            oldp=findViewById(R.id.oldpass);
            newp=findViewById(R.id.newpass);
            cnewp=findViewById(R.id.cnewpass);
            btnupdate=findViewById(R.id.updatebtn);
            changpass=findViewById(R.id.changepass);
            home=findViewById(R.id.homeBtn);
            profile=findViewById(R.id.profileBtn);
            suppBtn = findViewById(R.id.suppBtn);
            settingsBtn= findViewById(R.id.settingsBtn);
            Spinner LangueSpinner = (Spinner) findViewById(R.id.LangueSpinner);
            Spinner CountrySpinner = (Spinner) findViewById(R.id.paysSpinner);
        /*======<<<<------ /INITIALISATION  ------>>>>============*/


        /*======<<<<------ METHOD CHANGE PASSWORD  ------>>>>============*/
            changpass.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    String nameTXT =namedb;
                    String contactTXT = newp.getText().toString();
                    String oldtxt = oldp.getText().toString();
                    String dobTXT = cnewp.getText().toString();

                    if(contactTXT.equals("") && dobTXT.equals("") && oldtxt.equals("") )
                    {
                        Toast.makeText(SettingsActivity.this, "empty !!!", Toast.LENGTH_SHORT).show();
                    }

                    else
                        {   // Boolean checkupdatedata = DB.updatepassword(nameTXT, contactTXT);
                            //  if(checkupdatedata==true)
                        Toast.makeText(SettingsActivity.this, "SORRY THIS PART IS NOT DEVELOPED YET", Toast.LENGTH_SHORT).show();

                        }
                }
            });
        /*======<<<<------ /METHOD CHANGE PASSWORD  ------>>>>============*/



        /*======<<<<------ UPDATE APPLICATION  ------>>>>============*/
            btnupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(SettingsActivity.this, "YOUR APP IS UP TO DATE", Toast.LENGTH_SHORT).show();
                }
            });
        /*======<<<<------ /UPDATE APPLICATION  ------>>>>============*/



        /*======<<<<------ NAVIGATION BAR  ------>>>>============*/
            FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);

            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(SettingsActivity.this, CartListActivity.class);
                    i.putExtra("name",namedb);

                    startActivity(i);
                }
            });

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(SettingsActivity.this, MainActivity.class);
                    i.putExtra("name",namedb);

                    startActivity(i);
                }
            });

            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(SettingsActivity.this, ProfileActivity.class);
                    i.putExtra("name",namedb);

                    startActivity(i);
                }
            });

            suppBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(SettingsActivity.this, SuppActivity.class);
                    i.putExtra("name",namedb);

                    startActivity(i);
                }
            });
        /*======<<<<------ /NAVIGATION BAR  ------>>>>============*/




        /*======<<<<------ SPINNER COUNTRY  ------>>>>============*/

            CountrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String selectedItem = adapterView.getItemAtPosition(i).toString();
                   // Toast.makeText(SettingsActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        /*======<<<<------ /SPINNER COUNTRY  ------>>>>============*/



        /*======<<<<------ SPINNER LANGUAGE  ------>>>>============*/
            LangueSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                {
                    String selectedItemlangue = adapterView.getItemAtPosition(i).toString();
                   // Toast.makeText(SettingsActivity.this, selectedItemlangue, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        /*======<<<<------ SPINNER LANGUAGE  ------>>>>============*/


    }
}