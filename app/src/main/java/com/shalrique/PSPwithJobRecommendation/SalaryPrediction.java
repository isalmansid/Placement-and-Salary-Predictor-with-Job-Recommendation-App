package com.shalrique.PSPwithJobRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class SalaryPrediction extends AppCompatActivity {

    EditText Branch,SSC,HSC_DIPLOMA,Degree_Sem_1_Cgpa,Degree_Sem_2_Cgpa,Degree_Sem_3_Cgpa,Degree_Sem_4_Cgpa,Degree_Sem_5_Cgpa,Programming_Skills,Communication_Skills_Out_Of_5,English_Grammar_Out_Of_5;
    Button predict;
    TextView result;

    String url = "https://isalmansids.pythonanywhere.com/predict";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_prediction);


        Branch = (EditText) findViewById(R.id.Branch);
        SSC = (EditText) findViewById(R.id.SSC);
        HSC_DIPLOMA = (EditText) findViewById(R.id.HSC_DIPLOMA);
        Degree_Sem_1_Cgpa =(EditText) findViewById(R.id.Degree_Sem_1_Cgpa);
        Degree_Sem_2_Cgpa =(EditText) findViewById(R.id.Degree_Sem_2_Cgpa);
        Degree_Sem_3_Cgpa =(EditText) findViewById(R.id.Degree_Sem_3_Cgpa);
        Degree_Sem_4_Cgpa =(EditText) findViewById(R.id.Degree_Sem_4_Cgpa);
        Degree_Sem_5_Cgpa =(EditText) findViewById(R.id.Degree_Sem_5_Cgpa);
        Programming_Skills =(EditText) findViewById(R.id.Programming_Skills);
        Communication_Skills_Out_Of_5 =(EditText) findViewById(R.id.Communication_Skills_Out_Of_5);
        English_Grammar_Out_Of_5 =(EditText) findViewById(R.id.English_Grammar_Out_Of_5);

        predict = (Button) findViewById(R.id.predict);
        result = (TextView) findViewById(R.id.result);


        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hit the API -> Volley

                StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data = jsonObject.getString("Salary");

                                        result.setText("Salary is: "+data+" LPA");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(SalaryPrediction.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){

                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("Branch",Branch.getText().toString());
                        params.put("SSC",SSC.getText().toString());
                        params.put("HSC_DIPLOMA",HSC_DIPLOMA.getText().toString());
                        params.put("Degree_Sem_1_Cgpa",Degree_Sem_1_Cgpa.getText().toString());
                        params.put("Degree_Sem_2_Cgpa",Degree_Sem_2_Cgpa.getText().toString());
                        params.put("Degree_Sem_3_Cgpa",Degree_Sem_3_Cgpa.getText().toString());
                        params.put("Degree_Sem_4_Cgpa",Degree_Sem_4_Cgpa.getText().toString());
                        params.put("Degree_Sem_5_Cgpa",Degree_Sem_5_Cgpa.getText().toString());
                        params.put("Programming_Skills",Programming_Skills.getText().toString());
                        params.put("Communication_Skills_Out_Of_5",Communication_Skills_Out_Of_5.getText().toString());
                        params.put("English_Grammar_Out_Of_5",English_Grammar_Out_Of_5.getText().toString());

                        return params;
                    }

                };
                RequestQueue queue = Volley.newRequestQueue(SalaryPrediction.this);
                queue.add(stringRequest);
            }
        });
    }
}
