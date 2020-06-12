package com.example.caffeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    private Button buttonMasuk;
    private Button buttonDaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        buttonMasuk = (Button) findViewById(R.id.gotologin);
        buttonDaftar = (Button) findViewById(R.id.gotosignup);

        buttonMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });
        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });
    }
    public void opensignup(){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
    public void openlogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
