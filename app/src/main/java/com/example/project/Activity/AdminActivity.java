package com.example.project.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;

public class AdminActivity extends AppCompatActivity
{
    /*======<<<<------ DECLARATION ------>>>>============*/
    EditText name, contact, dob;
    Button insert, update, delete, view,ViewAvis;
    DBHelper DB;
    /*======<<<<------ /DECLARATION ------>>>>============*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        /*======<<<<------ INITIALISATION ------>>>>============*/
        name = findViewById(R.id.name);         //  EditText user
        contact = findViewById(R.id.contact);   //  EditText job
        dob = findViewById(R.id.dob);           //  EditText password
        insert = findViewById(R.id.btnInsert);  //  Button pour insertion user
        update = findViewById(R.id.btnUpdate);  //  Button pour update user
        delete = findViewById(R.id.btnDelete);  //  Button pour delete user
        view = findViewById(R.id.btnView);      //  Button pour affichage user
        ViewAvis = findViewById(R.id.btnViewAvis);//
        DB = new DBHelper(this);         //
        /*======<<<<------ /INITIALISATION ------>>>>============*/



        /*======<<<<------ SCRIPT INSERTION ------>>>>============*/
        insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();
                if (nameTXT.equals("") ||contactTXT.equals("") || dobTXT.equals("") )
                    {
                        Toast.makeText(AdminActivity.this, "please enter all data", Toast.LENGTH_SHORT).show();
                    }
                else
                    {
                        Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, dobTXT);
                        if(checkinsertdata==true)
                            Toast.makeText(AdminActivity.this, "New User was Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AdminActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        /*======<<<<------ /SCRIPT INSERTION ------>>>>============*/


        /*======<<<<------ SCRIPT UPDATE ------>>>>============*/
        update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(AdminActivity.this, "User Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminActivity.this, "Not Updated", Toast.LENGTH_SHORT).show();
            }
        });
        /*======<<<<------ /SCRIPT UPDATE ------>>>>============*/


        /*======<<<<------ SCRIPT DELETE ------>>>>============*/
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(AdminActivity.this, "User Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        /*======<<<<------ /SCRIPT UPDATE ------>>>>============*/


        /*======<<<<------ SCRIPT SELECT USER ------>>>>============*/
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(AdminActivity.this, "No User Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Password:"+res.getString(1)+"\n");
                    buffer.append("Job :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Users Liste");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        /*======<<<<------ SCRIPT SELECT USER   ------>>>>============*/


        /*======<<<<------ SCRIPT SELECT AVIS------>>>>============*/
        ViewAvis.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Cursor res = DB.getdataAvis();
                if(res.getCount()==0){
                    Toast.makeText(AdminActivity.this, "No Avis Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){

                   buffer.append("Avis:"+res.getString(1)+"\n");
                    buffer.append("Rate :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Avis Liste");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        /*======<<<<------ /SCRIPT SELECT AVIS------>>>>============*/

    }
}
