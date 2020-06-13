package com.example.caffeis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import model.Food;

public class FoodDetail extends AppCompatActivity {

    ImageView foto;
    ElegantNumberButton numberButton;
    Button btnSubmit;

    String harga = "", nama = "";

    FirebaseDatabase database;
    DatabaseReference foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //init view
        numberButton = (ElegantNumberButton) findViewById(R.id.jumlah_menu);
        btnSubmit = (Button) findViewById(R.id.buttonpesan);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FoodDetail.this, "Pesanan diterima, Silahkan Cek Keranjang Belanja", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        harga = intent.getStringExtra("Harga");
        nama = intent.getStringExtra("Nama");

        TextView textNama = (TextView) findViewById(R.id.nama_menu);
        textNama.setText(nama);

        TextView textHarga = (TextView) findViewById(R.id.textharga);
        textHarga.setText(harga);

        ImageView cetakFoto=(ImageView) findViewById(R.id.image_menu);
        if (intent.getStringExtra("Foto").equals("1")) {
            cetakFoto.setImageResource(R.drawable.kopisusu);
        }else  if (intent.getStringExtra("Foto").equals("2")) {
            cetakFoto.setImageResource(R.drawable.kentanggoreng);
        }else  if (intent.getStringExtra("Foto").equals("3")) {
            cetakFoto.setImageResource(R.drawable.roti);
        }else  if (intent.getStringExtra("Foto").equals("4")) {
            cetakFoto.setImageResource(R.drawable.martabak);
        }else  if (intent.getStringExtra("Foto").equals("5")) {
            cetakFoto.setImageResource(R.drawable.boba);
        }
    }
}
