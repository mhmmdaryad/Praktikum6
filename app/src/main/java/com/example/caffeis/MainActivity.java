package com.example.caffeis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    LinearLayout btnkopi, btnkentang, btnroti, btnmartabak, btnboba;
    Button lokasi;

    FirebaseDatabase database;
    DatabaseReference foodlist;

    int[] images={R.drawable.kopisusu,R.drawable.kentanggoreng};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        foodlist = database.getReference("Foods");

        btnkopi = (LinearLayout) findViewById(R.id.coffe);
        btnkentang = (LinearLayout) findViewById(R.id.kentang);
        btnroti = (LinearLayout) findViewById(R.id.roti);
        btnmartabak = (LinearLayout) findViewById(R.id.martabak);
        btnboba = (LinearLayout) findViewById(R.id.boba);

        lokasi = (Button) findViewById(R.id.button4);

        lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MapsActivity = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(MapsActivity);
            }
        });

        btnkopi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                foodDetail.putExtra("Nama", "Es Kopi Susu");
                foodDetail.putExtra("Harga", "15000");
                foodDetail.putExtra("Foto", images[0]);
                startActivity(foodDetail);
            }
        });
        btnkentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                foodDetail.putExtra("Nama", "Kentang Goreng");
                foodDetail.putExtra("Harga", "20000");
                foodDetail.putExtra("Foto", images[1]);
                startActivity(foodDetail);
            }
        });
        btnroti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                foodDetail.putExtra("Nama", "Roti Bakar");
                foodDetail.putExtra("Harga", "12000");
                foodDetail.putExtra("Foto", "Es Kopi Susu");
                startActivity(foodDetail);
            }
        });
        btnmartabak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                foodDetail.putExtra("Nama", "Martabak");
                foodDetail.putExtra("Harga", "25000");
                foodDetail.putExtra("Foto", "Es Kopi Susu");
                startActivity(foodDetail);
            }
        });
        btnboba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(MainActivity.this, FoodDetail.class);
                foodDetail.putExtra("Nama", "Es Boba");
                foodDetail.putExtra("Harga", "22000");
                foodDetail.putExtra("Foto", "Es Kopi Susu");
                startActivity(foodDetail);
            }
        });

    }

}

