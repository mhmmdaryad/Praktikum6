package com.example.caffeis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import model.User;

public class LoginActivity extends AppCompatActivity {
    EditText Number, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Number = findViewById(R.id.usernumber);
        password = findViewById(R.id.text_input_password_toggle);
        button = (Button)findViewById(R.id.button);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                mDialog.setMessage("please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(Number.getText().toString()).exists()) {
                            mDialog.dismiss();

                            User user = dataSnapshot.child(Number.getText().toString()).getValue(User.class);
                            user.setPhone(Number.getText().toString());

                            if (user.getPassword().equals(password.getText().toString())) {
                                {
                                    Intent HomeActivity = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(HomeActivity);
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "log in failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "User not Exist", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
