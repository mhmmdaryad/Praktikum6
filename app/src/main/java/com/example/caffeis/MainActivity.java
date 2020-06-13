package com.example.caffeis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int kopi = 1, kentang = 2, roti = 3, martabak = 4, boba = 5;
    LinearLayout btnkopi, btnkentang, btnroti, btnmartabak, btnboba;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnkopi = (LinearLayout) findViewById(R.id.coffe);
        btnkentang = (LinearLayout) findViewById(R.id.kentang);
        btnroti = (LinearLayout) findViewById(R.id.roti);
        btnmartabak = (LinearLayout) findViewById(R.id.martabak);
        btnboba = (LinearLayout) findViewById(R.id.boba);

        btnkopi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", 1);
            }
        });
        btnkentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", 2);
            }
        });
        btnroti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", 3);
            }
        });
        btnmartabak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", 4);
            }
        });
        btnboba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", 5);
            }
        });

    }

}

