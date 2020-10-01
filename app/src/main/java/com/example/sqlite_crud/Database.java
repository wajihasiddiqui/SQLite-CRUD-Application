package com.example.sqlite_crud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "dbtest", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create = "CREATE TABLE tbluser(UID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME VARCHAR(20), UAGE INTEGER)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertData(String name, int age)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
             String insert = "INSERT INTO tbluser (UID, UNAME, UAGE) VALUES (null, '"+name+"', '"+age+"')";
             return true;
        }

        catch(Exception ex){

            return false;
        }
    }


    //generate the query to read from the database

    public Cursor GetAllData(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM tbluser", null);
        return cur;
    }
}
