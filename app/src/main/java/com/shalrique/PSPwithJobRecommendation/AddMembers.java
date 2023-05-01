package com.shalrique.PSPwithJobRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AddMembers extends AppCompatActivity {

    Button addStudentBtn,addFacultyBtn,logout, placementBtn,JobRecommendation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);



        addStudentBtn=(Button) findViewById(R.id.addStudentBtn);
        addFacultyBtn= (Button) findViewById(R.id.addFacultyBtn);
        logout=(Button) findViewById(R.id.logout);
        placementBtn= (Button) findViewById(R.id.placementBtn);
        JobRecommendation= (Button) findViewById(R.id.JobRecommendation);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(AddMembers.this,MainActivity.class);
                startActivity(i1);
            }
        });


        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i2 = new Intent(AddMembers.this,AddStudent.class);
                startActivity(i2);

            }
        });

        addFacultyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i4 = new Intent(AddMembers.this, SalaryPrediction.class);
                startActivity(i4);

            }
        });

        placementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i5 = new Intent(AddMembers.this,PlacementActivity.class);
                startActivity(i5);

            }
        });


        JobRecommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i8 = new Intent(AddMembers.this,Activity_JR.class);
                startActivity(i8);

            }
        });



    }
}