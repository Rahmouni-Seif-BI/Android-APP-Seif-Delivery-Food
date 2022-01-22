package com.example.project.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{
        public static final  String DBNAME = "Login.db";

        public DBHelper(Context context){
            super(context, "Login.db", null , 1 );
        }
        @Override
        public void onCreate(SQLiteDatabase MyDB)
        {
        /*==================<<<<<<<<------ CREATE TABLE USERS ------>>>>>>>>======================*/
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT,job TEXT)");
        /*==================<<<<<<<<------ !!!ENDCREATE TABLE USERS ----->>>>>>>>=================*/


        /*==================<<<<<<<<------ CREATE TABLE AVIS ------>>>>>>>>======================*/
        MyDB.execSQL("CREATE TABLE avis(id INTEGER primary key AUTOINCREMENT,avis TEXT,rate TEXT)");
        /*==================<<<<<<<<------ !!!END CREATE TABLE AVIS ------>>>>>>>>===============*/


        /*==================<<<<<<<<------ CREATE TABLE ADMIN ------>>>>>>>>======================*/
        MyDB.execSQL("create Table Admin(name TEXT primary key, passwordadmin TEXT)");
        /*==================<<<<<<<<------ !!!END CREATE TABLE ADMIN ------>>>>>>>>===============*/
        }


        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int i, int i1)
        {
        /*=============<<<<<<<<------ DELETE TABLE IF THEY ARE EXISTS ------>>>>>>>>==============*/
            MyDB.execSQL("drop Table if exists users");
            MyDB.execSQL("drop Table if exists avis");
            MyDB.execSQL("drop Table if exists Admin");
        /*================<<<<<<<------ !!!END DELETE TABLE IF THEY ARE EXISTS ------>>>>>>>>=====*/


        }
    /*[[[[[[[[[[[[((((((((((((((((----------- CRUD TABLE USERS -------------))))))))))))))]]]]]]]]*/
        /*
           A) INSERT
           B) UPDATE
           C) DELETE
           D) SELECT
         */

        /*==================<<<<<<<<------ INSERT INTO USERS TABLE ------>>>>>>>>=================*/
        public Boolean insertData (String username, String password ,String jobs)
        {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("username",username);
            contentValues.put("password",password);
            contentValues.put("job",jobs);
            long result= MyDB.insert("users", null, contentValues);
            if (result==-1) return  false;
            else
                return true;
        }
        /*================<<<<<<<<------ !!!END INSERT INTO USERS TABLE ------>>>>>>>>============*/


        /*==================<<<<<<<<------ INSERT INTO USER TABLE VIA ADMIN ------>>>>>>>>========*/

        public Boolean insertuserdata(String name, String contact, String dob)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("username", name);
            contentValues.put("job", contact);
            contentValues.put("password", dob);
            long result=DB.insert("users", null, contentValues);
            if(result==-1)
                {
                    return false;
                }
            else
                {
                    return true;
                }
        }
        /*=============<<<<<<<<------ !!!END INSERT INTO USERS TABLE VIA ADMIN ------>>>>>>>>=====*/


        /*============<<<<<<------ UPDATE FROM USERS TABLE VIA ADMIN ------>>>>>>>>===============*/
        public Boolean updateuserdata(String name, String contact, String dob)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("job", contact);
            contentValues.put("password", dob);
            Cursor cursor = DB.rawQuery("Select * from users where username = ?",
                    new String[]{name});
            if (cursor.getCount() > 0)
                {
                    long result = DB.update("users", contentValues, "username=?",
                            new String[]{name});
                    if (result == -1)
                        {
                            return false;
                        }
                    else
                        {
                            return true;
                        }
                }
            else
                {
                    return false;
                }
        }
        /*==========<<<<<<------ !!!END UPDATE FROM USERS TABLE VIA ADMIN ------>>>>>>============*/

    /*============<<<<<<------ UPDATE FROM USERS PASSWORD  ------>>>>>>>>===============*/
    public Boolean updatepassword(String name, String newpass)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("password", newpass);
        Cursor cursor = DB.rawQuery("Select * from users where username = ?",
                new String[]{name});
        if (cursor.getCount() > 0)
        {
            long result = DB.update("users", contentValues, "username=?",
                    new String[]{name});
            if (result == -1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
    /*==========<<<<<<------ !!!END UPDATE PASSWORD FROM USERS TABLE ------>>>>>>============*/




        /*=============<<<<<<------ DELETE FROM USERS TABLE VIA ADMIN ------>>>>>>>===============*/
        public Boolean deletedata (String name)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from users where username = ?",
                    new String[]{name});
            if (cursor.getCount() > 0)
                {
                    long result = DB.delete("users", "username=?",
                            new String[]{name});
                    if (result == -1)
                        {
                            return false;
                        }
                    else
                        {
                            return true;
                        }
                }
            else
                {
                    return false;
                }
        }
        /*=========<<<<<<<<------ !!!END DELETE FROM USERS TABLE VIA ADMIN ------>>>>>>>>=========*/




        /*===============<<<<<<<<------ SELECT* FROM USERS TABLE  ------>>>>>>>>==================*/
        public Cursor getdata ()
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from users", null);
            return cursor;
        }
        /*===============<<<<<<<------ !!!END SELECT* FROM USERS TABLE  ------>>>>>>>>============*/



        /*=========<<<<<<---- SELECT* FROM USERS TABLE WHERE CONDITION ------>>>>>>>>=============*/
        public boolean checkusername(String username)
        {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("Select * from users where username= ?",
                    new String[] {username});
            if(cursor.getCount()>0)
                return  true;
            else
                return false;
        }
        /*==========<<<<<<------ SELECT* FROM USERS TABLE WHERE CONDITION ------>>>>>>>>==========*/



        /*======<<<<<---- SELECT* FROM USERS TABLE WHERE COND1 + COND2 MATCHES ---->>>>>>>========*/
        public Boolean checkusernamepassword(String username , String password)
        {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("Select * from  users " +
                    "where username = ? and password= ?",new String[] {username,password});
            if (cursor.getCount()>0)
                return true;
            else
                return false;
        }
        /*=====<<<----- SELECT* FROM USERS TABLE WHERE COND1 + COND2 MATCHES ------>>>>>>=========*/

    /*[[[[[[[[[[[[((((((((((((----------- !!!! END CRUD TABLE USERS -----------)))))))))]]]]]]]]]]*/




    /*[[[[[[[[[[[[((((((((((((((((----------- LMD TABLE AVIS -------------))))))))))))))]]]]]]]]]]*/
        /*
           A) SELECT
           B) INSERT

         */
        /*==================<<<<<<<<------ SELECT* FROM AVIS TABLE  ------>>>>>>>>================*/
        public Cursor getdataAvis()
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from Avis", null);
            return cursor;
        }
        /*==================<<<<<<<<------ !!!END SELECT* FROM AVIS TABLE  ------>>>>>>>>=========*/




        /*==================<<<<<<<<------ INSERT INTO AVIS TABLE ------>>>>>>>>==================*/
        public Boolean insertDataAvis(String avis, String rate)
        {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("avis",avis);
            contentValues.put("rate",rate);
            long result= MyDB.insert("avis", null, contentValues);
            if (result==-1) return  false;
            else
                return true;
        }
        /*================<<<<<<<<------ !!!END INSERT INTO AVIS TABLE ------>>>>>>>>=============*/

    /*[[[[[[[[[[[[((((((((((((----------- !!END LMD TABLE AVIS -------------))))))))))))))]]]]]]]]*/
}
