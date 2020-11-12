package com.example.sqlite_crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    //Create Database

    public Database(@Nullable Context context) {
        super(context, "dbtest", null, 1);
    }

    //Create Table

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create = "CREATE TABLE tbluser(UID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME VARCHAR(20), UAGE INTEGER)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Insert Data

    public boolean insertData(String name, int age)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            String insert ="INSERT INTO tbluser (UID, UNAME, UAGE) VALUES (null, '"+name+"', '"+age+"')";
            db.execSQL(insert);
             return true;
        }

        catch(Exception ex){

            return false;
        }
    }


    //Second Method of Insert

//   public boolean InsertData(String name, int age,int id){
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("UNAME",name);
//        contentValue.put("UAGE",age);
//        long result = db.insert("tbluser",null,contentValue);
//        if(result == -1){
//            return false;
//        }
//        else{
//            return true;
//        }
//
//    }


    //generate the query to read data from database

    public Cursor GetAllData(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM tbluser", null);
        return cur;
    }

    //Delete Database

//    public Boolean deleteDatabase(int id) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        try{
//            db.execSQL("SELECT * FROM tbluser WHERE UID ='"+id+"'");
//            return true;
//        }
//        catch(Exception ex){
//            return false;
//        }
//    }
//
    //Update Database
//    public Boolean updateDatabase(int id,String name,int age) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        try{
//            db.execSQL("UPDATE tbluser set UNAME = '"+name+"', UAGE = '"+age+"', WHERE UID = '"+id+"'");
//            return true;
//        }
//        catch(Exception ex){
//            return false;
//        }
//    }


    //Second Method of Update
//
//    public boolean UpdateData(String name, String age, String id){
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("UNAME",name);
//        contentValue.put("UAGE",age);
//        contentValue.put("UID",id);
//        db.update("tbluser", contentValue, "ID = ?", new String[]{String.valueOf(id)});
//
//            return true;
//
//
//    }
//
//
//    //Second Method of Delete
//
//    public boolean deleteData(int id){
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete("tbluser","ID = ?", new String[]{String.valueOf(id)});
//        return true;
//    }
}
