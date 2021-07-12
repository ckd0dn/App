package com.gomsinpark.makeeat_java;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Refrigerator_Activity extends AppCompatActivity {

    private Button tomato_btn;
    private Button gochu_btn;
    private Button sogogi_btn;
    private Button pig_btn;
    private Button bachu_btn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrigerator);

        tomato_btn = findViewById(R.id.tomato_btn);
        gochu_btn = findViewById(R.id.gochu_btn);
        sogogi_btn = findViewById(R.id.sogogi_btn);
        pig_btn = findViewById(R.id.pig_btn);
        bachu_btn = findViewById(R.id.bachu_btn);

        tomato_btn.setOnClickListener(click);
        gochu_btn.setOnClickListener(click);
        sogogi_btn.setOnClickListener(click);
        pig_btn.setOnClickListener(click);
        bachu_btn.setOnClickListener(click);




    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tomato_btn:
                    Toast.makeText(getApplicationContext(), "토마토", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.gochu_btn:
                    Toast.makeText(getApplicationContext(), "고추", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.sogogi_btn:
                    Toast.makeText(getApplicationContext(), "소고기", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.pig_btn:
                    Toast.makeText(getApplicationContext(), "돼지고기", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bachu_btn:
                    Toast.makeText(getApplicationContext(), "배추", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };




}