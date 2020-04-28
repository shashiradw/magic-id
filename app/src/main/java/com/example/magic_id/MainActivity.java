package com.example.magic_id;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textId;
    Button btnSubmit;
    TextView textView;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textId=findViewById(R.id.textId);
        btnSubmit=findViewById(R.id.btnSubmit);
        textView=findViewById(R.id.year);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate calculate=new Calculate();
                String idNumber=textId.getText().toString().trim();

                if(idNumber=="") {
                    textView.setText("Cannot have Null Id Number");
                }
                else if(Integer.parseInt(idNumber.substring(0,2))==0){
                    textView.setText("Invalid Id Number");
                }
                else if(idNumber.length()<6){
                    textView.setText("Invalid Id Number");
                }
                else{
                    model=calculate.calculateBday(idNumber);

                    textView.setText(model.getGender()+" , "+model.getYear()+" , "+model.getMonth()+" , "+model.getDay());
                }

            }
        });

    }
}
