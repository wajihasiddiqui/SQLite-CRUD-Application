package com.example.sqlite_crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database mydb;
    EditText name, age, id;
    Button button, getdata,update,delete;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        id = findViewById(R.id.id);
        delete = findViewById(R.id.delete);
        listView = findViewById(R.id.listview);
        button = findViewById(R.id.button);
        update = findViewById(R.id.update);
        getdata = findViewById(R.id.getdata);
        mydb  = new Database(this);
        //ViewAllData(); //For Buffer Data
        GetData();  //For ListView Data
        //UpdateData();
        //deleteData();



        //Insert Data

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Insert Data 
                boolean isInserted = mydb.insertData(name.getText().toString(),Integer.parseInt(age.getText().toString()));

                if(isInserted = true){

                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                    GetData();
                }

                else{

                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //Show Data in List View

    public void GetData(){

        ArrayList list = new ArrayList();

        Cursor cr = mydb.GetAllData();
        cr.moveToFirst();
        while(!cr.isAfterLast()){

            list.add("ID: " + cr.getInt(0) + "NAME: " + cr.getString(1) +"AGE: " + cr.getInt(2));
            cr.moveToNext();
        }

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


    }

//    public void UpdateData(){
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean isupdate = mydb.UpdateData(name.getText().toString(), age.getText().toString(),id.getText().toString());
//                if(isupdate = true){
//
//                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
//
//
//                }
//
//                else{
//
//                    Toast.makeText(MainActivity.this, "Data Not Updated ", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//        });
//
//
//    }


//    public void deleteData(){
//
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean  deletedRaws = mydb.deleteData(Integer.parseInt(id.getText().toString()));
//                if(deletedRaws = true){
//
//                    Toast.makeText(MainActivity.this, "Data delete", Toast.LENGTH_SHORT).show();
//                }
//                else{
//
//                    Toast.makeText(MainActivity.this, "Data Not delete ", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//        });
//
//
//    }

//    //Show Data in Buffer
//
//    public void ViewAllData(){
//        getdata.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//               Cursor cur = mydb.GetAllData();
//               if(cur.getCount() == 0){
//                   // show message
//                   ShowMessage("Error","Nothing Found");
//                   return;
//               }
//
//               StringBuffer buffer = new StringBuffer();
//               while(cur.moveToNext()){
//                   buffer.append("ID:   "+ cur.getString(0)+"\n");
//                   buffer.append("NAME:   "+ cur.getString(1)+"\n");
//                   buffer.append("AGE:   "+ cur.getString(2)+"\n\n");
//
//
//               }
//
//               //show all data
//                ShowMessage("Data",buffer.toString());
//            }
//        });
//    }
//
//
//    //Show Message Buffer
//
//    public void ShowMessage(String title, String Message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }
}