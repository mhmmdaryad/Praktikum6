package com.example.caffeis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import model.Food;

public class FoodDetail extends AppCompatActivity {
    TextView food_name, food_price;
    ImageView food_image;
    ElegantNumberButton numberButton;
    Button btnSubmit;

    String foodId="";
    FirebaseDatabase database;
    DatabaseReference foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        //Firebase
        database = FirebaseDatabase.getInstance();
        foods= database.getReference("Foods");

        //init view

        numberButton= (ElegantNumberButton) findViewById(R.id.jumlah_menu);
        btnSubmit= (Button)findViewById(R.id.buttonpesan);

        food_name=(TextView)findViewById(R.id.nama_menu);
        food_price=(TextView)findViewById(R.id.textharga);
        food_image=(ImageView)findViewById(R.id.image_menu);

        if (getIntent()!= null){
            foodId=getIntent().getStringExtra("MenuId");
            if(foodId!=null){
                getDetailFood(foodId);
            }
        }
    }

    private void getDetailFood(String foodId) {
        foods.child(foodId);
        foods.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Food food = dataSnapshot.getValue(Food.class);

                Picasso.get().load(food.getImage()).into(food_image);
                food_price.setText(food.getPrice());
                food_name.setText(food.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
