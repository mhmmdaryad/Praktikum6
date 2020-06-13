package com.example.caffeis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int kopi = 1, kentang = 2, roti = 3, martabak = 4, boba = 5;
    Button btnkopi, btnkentang, btnroti, btnmartabak, btnboba;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnkopi = (Button) findViewById(R.id.coffe);
        btnkentang = (Button) findViewById(R.id.kentang);
        btnroti = (Button) findViewById(R.id.roti);
        btnmartabak = (Button) findViewById(R.id.martabak);
        btnboba = (Button) findViewById(R.id.boba);

        btnkopi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", kopi);
            }
        });
        btnkentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", kentang);
            }
        });
        btnroti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", roti);
            }
        });
        btnmartabak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", martabak);
            }
        });
        btnboba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                startActivity(foodDetail);
                foodDetail.putExtra("FoodId", boba);
            }
        });

    }

}

