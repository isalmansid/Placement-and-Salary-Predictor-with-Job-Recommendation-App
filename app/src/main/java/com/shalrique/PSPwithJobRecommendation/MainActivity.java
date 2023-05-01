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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,password;
    TextView tv,tv2;
    Button login,Signup;
    Spinner sp;

    String user[]={"Student","Faculty"};
    String nameT,passwordT;
    String e1,p1,itemSelected;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=openOrCreateDatabase("myData", Context.MODE_PRIVATE, null);

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);

        sp=findViewById(R.id.sp);


        login= (Button) findViewById(R.id.login);
        Signup = (Button) findViewById(R.id.Signup);
        tv2 = (TextView) findViewById(R.id.tv2);




        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,user);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemSelected =(String) sp.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(itemSelected.equals("Faculty"))
                {
                    if(name.getText().toString().equals("faculty") && password.getText().toString().equals("faculty"))
                    {
                        Intent i8 = new Intent(MainActivity.this,AddMembers.class);
                        startActivity(i8);
                    }
                }

                if(itemSelected.equals("Student"))
                {
                    Cursor q1 = db.rawQuery("SELECT * FROM AddFaculty;", null);
                    q1.moveToFirst();

                    do
                    {
                        nameT = q1.getString(0);
                        passwordT= q1.getString(1);

                        e1 = name.getText().toString();
                        p1=password.getText().toString();



                        if(nameT.equals(e1) && passwordT.equals(p1))
                        {

                            Toast.makeText(MainActivity.this, "Logged In!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this,takeAttendance.class);
                            startActivity(i);
                            return;
                        }


                        nameT="";
                        passwordT="";

                    }while(q1.moveToNext());


                }

                //Toast.makeText(MainActivity.this, "Wrong Credentials!", Toast.LENGTH_SHORT).show();


            }
        });



        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.execSQL("DELETE FROM AddStudent");
                db.execSQL("DELETE FROM AddFaculty");
                db.execSQL("DELETE FROM AddAttendance");
                db.execSQL("DELETE FROM AddStatus");
                db.execSQL("DELETE FROM AddDate");
                Toast.makeText(MainActivity.this, "All Records Deleted!", Toast.LENGTH_SHORT).show();

            }
        });


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i9 = new Intent(MainActivity.this, signup.class);
                startActivity(i9);

                Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();

            }
        });




    }


}
