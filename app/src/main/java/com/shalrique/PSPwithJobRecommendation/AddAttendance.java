package com.shalrique.PSPwithJobRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddAttendance extends AppCompatActivity {


    TextView tv9,name1,rolls;
    ListView l1,l2;
    ImageView imageView2;

    String name,roll;

    SQLiteDatabase db3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);



        db3=openOrCreateDatabase("myData", Context.MODE_PRIVATE, null);
        db3.execSQL("CREATE TABLE IF NOT EXISTS AddAttendance(name VARCHAR,rollno VARCHAR);");

        tv9=(TextView)findViewById(R.id.tv9);

        l1=(ListView)findViewById(R.id.l1);
        l2=(ListView)findViewById(R.id.l2);
        imageView2=findViewById(R.id.imageView2);
        name1=findViewById(R.id.name1);
        rolls=findViewById(R.id.rolls);


        db3=openOrCreateDatabase("myData", Context.MODE_PRIVATE, null);

        final ArrayList<String> list1 = new ArrayList<>();
        Cursor t1 = db3.rawQuery("SELECT * FROM AddStudent;", null);


        while(t1.moveToNext())
        {
            list1.add(t1.getString(3));
            ListAdapter listAdapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,list1);
            l1.setAdapter(listAdapter1);
        }


        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                name = l1.getItemAtPosition(position).toString();

                Toast.makeText(AddAttendance.this, name, Toast.LENGTH_SHORT).show();

                name1.setText(name);
            }
        });



        ArrayList<String> list2 = new ArrayList<>();
        Cursor t2 = db3.rawQuery("SELECT * FROM AddStudent;", null);


        while(t2.moveToNext())
        {
            list2.add(t2.getString(0));
            ListAdapter listAdapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,list2);
            l2.setAdapter(listAdapter2);
        }

        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                roll = l2.getItemAtPosition(position).toString();

                Toast.makeText(AddAttendance.this, roll, Toast.LENGTH_SHORT).show();

                rolls.setText(roll);
            }
        });



        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name == null && roll == null)
                {
                    Toast.makeText(AddAttendance.this, "Select Name and Roll no.", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    db3.execSQL("INSERT INTO AddAttendance VALUES ('"+name1.getText()+"','"+rolls.getText()+"');");

                    Toast.makeText(AddAttendance.this, "Success!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(AddAttendance.this,status.class);
                    startActivity(i);

                }
            }
        });


    }
}
