package com.shalrique.PSPwithJobRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    EditText name1,rollNo1,password1,confirmPassword1,phone1;
    Button register1;

    SQLiteDatabase db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        db1=openOrCreateDatabase("myData", Context.MODE_PRIVATE, null);
        db1.execSQL("CREATE TABLE IF NOT EXISTS AddStudent(rollno1 VARCHAR,password1 VARCHAR,confirmpassword1 VARCHAR,name1 VARCHAR,phone1 INT);");


        name1=(EditText) findViewById(R.id.name1);
        rollNo1=(EditText) findViewById(R.id.rollNo1);
        password1=(EditText)findViewById(R.id.password1);
        confirmPassword1=(EditText) findViewById(R.id.confirmPassword1);
        phone1=(EditText) findViewById(R.id.phone1);

        register1= (Button) findViewById(R.id.register1);



        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if(name1.getText().toString().length() == 0||
                        rollNo1.getText().toString().length() == 0||
                        password1.getText().toString().length() == 0||
                        confirmPassword1.getText().toString().length() == 0||
                        phone1.getText().toString().length() == 0  )

                {
                    Toast.makeText(AddStudent.this, "All fields required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                else {

                    db1.execSQL("INSERT INTO AddStudent VALUES('"+rollNo1.getText()+"','"+password1.getText()+"','"+confirmPassword1.getText() + "','"+name1.getText()+"','"+phone1.getText()+"');");
                    Toast.makeText(AddStudent.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(AddStudent.this,AddMembers.class);
                    startActivity(i);

                }


            }
        });



    }
}