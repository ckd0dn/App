package com.gomsinpark.makeeat_java.Pop_recipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gomsinpark.makeeat_java.R;

public class Pop_recipe_category_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_recipe_category);

        Button button1 = findViewById(R.id.taste_recipe_button1);
        Button button2 = findViewById(R.id.taste_recipe_button2);
        Button button3 = findViewById(R.id.taste_recipe_button3);
        Button button4 = findViewById(R.id.taste_recipe_button4);
        Button button5 = findViewById(R.id.taste_recipe_button5);
        Button button6 = findViewById(R.id.taste_recipe_button6);
        Button button7 = findViewById(R.id.taste_recipe_button7);
        Button button8 = findViewById(R.id.taste_recipe_button8);
        Button button9 = findViewById(R.id.taste_recipe_button9);
        Button button10 = findViewById(R.id.taste_recipe_button10);
        Button button11 = findViewById(R.id.taste_recipe_button11);
        Button button12 = findViewById(R.id.taste_recipe_button12);
        Button button13 = findViewById(R.id.taste_recipe_button13);
        Button button14 = findViewById(R.id.taste_recipe_button14);
        Button button15 = findViewById(R.id.taste_recipe_button15);
        Button button16 = findViewById(R.id.taste_recipe_button16);
        Button button17 = findViewById(R.id.taste_recipe_button17);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe1_Activity.class);
                 startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe2_Activity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe3_Activity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe4_Activity.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe5_Activity.class);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe6_Activity.class);
                startActivity(intent);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe7_Activity.class);
                startActivity(intent);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe8_Activity.class);
                startActivity(intent);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe9_Activity.class);
                startActivity(intent);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe10_Activity.class);
                startActivity(intent);
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe11_Activity.class);
                startActivity(intent);
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe12_Activity.class);
                startActivity(intent);
            }
        });

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe13_Activity.class);
                startActivity(intent);
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe14_Activity.class);
                startActivity(intent);
            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe15_Activity.class);
                startActivity(intent);
            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe16_Activity.class);
                startActivity(intent);
            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pop_recipe17_Activity.class);
                startActivity(intent);
            }
        });
    }
}