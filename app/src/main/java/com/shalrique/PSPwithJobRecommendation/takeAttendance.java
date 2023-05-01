package com.shalrique.PSPwithJobRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class takeAttendance extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button addAttendanceBtn,viewAttendanceBtn,logout;
    TextView tvDate;
    SQLiteDatabase db3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        addAttendanceBtn =findViewById(R.id.addAttendanceBtn);
        viewAttendanceBtn=findViewById(R.id.viewAttendanceBtn);

        logout =findViewById(R.id.logout);
        tvDate=findViewById(R.id.tvDate);

        db3=openOrCreateDatabase("myData", Context.MODE_PRIVATE, null);
        db3.execSQL("CREATE TABLE IF NOT EXISTS AddDate(date VARCHAR);");



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(takeAttendance.this,MainActivity.class);
                startActivity(i);
            }
        });

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePickerDialog();

            }
        });

        addAttendanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(takeAttendance.this,AddAttendance.class);
                startActivity(i);
            }
        });

        viewAttendanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(takeAttendance.this,viewAttendance.class);
                startActivity(intent);
            }
        });

    }

    public void showDatePickerDialog()
    {

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        month+=1;
        int year = c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                year,month,day

        );
        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date=dayOfMonth +"/" +month +"/" +year;
        tvDate.setText(date);
        db3.execSQL("INSERT INTO AddDate VALUES ('"+tvDate.getText()+"');");
        Toast.makeText(takeAttendance.this, "Date Added!", Toast.LENGTH_SHORT).show();

    }

}