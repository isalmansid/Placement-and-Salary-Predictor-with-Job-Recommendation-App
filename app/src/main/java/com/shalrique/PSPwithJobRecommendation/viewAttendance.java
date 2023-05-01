package com.shalrique.PSPwithJobRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class viewAttendance extends AppCompatActivity {

    ListView l1,l2,l3,l4;
    SQLiteDatabase db6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);




        l1=(ListView)findViewById(R.id.l1);
        l2=(ListView)findViewById(R.id.l2);
        l3=(ListView)findViewById(R.id.l3);
        l4=(ListView)findViewById(R.id.l4);

        db6=openOrCreateDatabase("myData", Context.MODE_PRIVATE, null);

        db6=openOrCreateDatabase("myData", Context.MODE_PRIVATE, null);

        final ArrayList<String> list1 = new ArrayList<>();
        Cursor t1 = db6.rawQuery("SELECT * FROM AddAttendance;", null);


        while(t1.moveToNext())
        {
            list1.add(t1.getString(0));
            ListAdapter listAdapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,list1);
            l1.setAdapter(listAdapter1);
        }


        ArrayList<String> list2 = new ArrayList<>();
        Cursor t2 = db6.rawQuery("SELECT * FROM AddAttendance;", null);


        while(t2.moveToNext())
        {
            list2.add(t2.getString(1));
            ListAdapter listAdapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,list2);
            l2.setAdapter(listAdapter2);
        }



        ArrayList<String> list3 = new ArrayList<>();
        Cursor t3 = db6.rawQuery("SELECT * FROM AddStatus;", null);


        while(t3.moveToNext())
        {
            list3.add(t3.getString(0));
            ListAdapter listAdapter3 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,list3);
            l3.setAdapter(listAdapter3);
        }




        ArrayList<String> list4 = new ArrayList<>();
        Cursor t4 = db6.rawQuery("SELECT * FROM AddDate;", null);


        while(t4.moveToNext())
        {
            list4.add(t4.getString(0));
            ListAdapter listAdapter4 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,list4);
            l4.setAdapter(listAdapter4);
        }




    }
}