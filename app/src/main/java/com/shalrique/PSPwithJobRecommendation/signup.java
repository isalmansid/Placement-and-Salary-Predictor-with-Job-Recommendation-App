package com.shalrique.PSPwithJobRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class signup extends AppCompatActivity {

    Button addStudentBtn,addFacultyBtn,logout, placementBtn,JobRecommendation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        addStudentBtn=(Button) findViewById(R.id.addStudentBtn);
        //addFacultyBtn= (Button) findViewById(R.id.addFacultyBtn);
        logout=(Button) findViewById(R.id.logout);
        //placementBtn= (Button) findViewById(R.id.placementBtn);
        //JobRecommendation= (Button) findViewById(R.id.JobRecommendation);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(signup.this,MainActivity.class);
                startActivity(i1);
            }
        });


        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i2 = new Intent(signup.this,AddStudent.class);
                startActivity(i2);

            }
        });





    }
}