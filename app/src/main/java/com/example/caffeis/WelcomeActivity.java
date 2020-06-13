package com.example.caffeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    Button login, signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        login = (Button)findViewById(R.id.gotologin);
        signup = (Button)findViewById(R.id.gotosignup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivity = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(LoginActivity);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUpActivity = new Intent(WelcomeActivity.this, SignupActivity.class);
                startActivity(SignUpActivity);
            }
        });
    }


}

