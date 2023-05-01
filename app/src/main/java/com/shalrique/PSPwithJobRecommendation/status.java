package com.shalrique.PSPwithJobRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class status extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button submit;

    SQLiteDatabase db3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        db3=openOrCreateDatabase("myData", Context.MODE_PRIVATE, null);
        db3.execSQL("CREATE TABLE IF NOT EXISTS AddStatus(status VARCHAR);");

        radioGroup= findViewById(R.id.radioGroup);
        submit=findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);

                Toast.makeText(status.this, radioButton.getText(), Toast.LENGTH_SHORT).show();

                db3.execSQL("INSERT INTO AddStatus VALUES ('"+radioButton.getText()+"');");
                Toast.makeText(status.this, "Added!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(status.this,takeAttendance.class);
                startActivity(i);


            }
        });

    }

}