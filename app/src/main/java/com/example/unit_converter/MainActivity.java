package com.example.unit_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView weight;
    CardView length;
    CardView temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight =findViewById(R.id.weight);
        length=findViewById(R.id.length);
        temperature=findViewById(R.id.temperature);

        weight.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,com.example.unit_converter.weight.class);
            startActivity(intent);
        });
        length.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,com.example.unit_converter.length.class);
            startActivity(intent);
        });
        temperature.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,com.example.unit_converter.temperature.class);
            startActivity(intent);
        });
    }
}