package com.example.unit_converter;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class weight extends AppCompatActivity {
    ImageView left_icon;
    EditText inputnum;
    Spinner unit;
    TextView kg,grams,pounds,tons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        ImageView leftIcon= findViewById(R.id.left_icon);

        inputnum=findViewById(R.id.inputnum);
        unit=findViewById(R.id.unit);
        kg=findViewById(R.id.kg);
        grams=findViewById(R.id.grams);
        pounds=findViewById(R.id.pounds);
        tons=findViewById(R.id.tons);
        String[] arr={"kg","grams","pounds","tons"};
        unit.setAdapter(new ArrayAdapter(weight.this, android.R.layout.simple_list_item_activated_1,arr));
        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text=parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        inputnum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                update();
            }
        });





        leftIcon.setOnClickListener(v -> {
            Intent intent=new Intent(weight.this,com.example.unit_converter.MainActivity.class);
            startActivity(intent);
        });
    }
    private void update() {
        if(!inputnum.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")){
            double in=Double.parseDouble(inputnum.getText().toString());
            switch (unit.getSelectedItem().toString()){
                case "kg":
                    setKg(in);
                    break;
                case "grams":
                    setKg(in/1000);
                    break;
                case "pounds":
                    setKg(in/2.20);
                    break;
                case "tons":
                    setKg(in*1000);
                    break;
            }
        }
    }
    private void setKg(double kg_in){
        kg.setText(String.valueOf(kg_in));
        grams.setText(String.valueOf(kg_in*1000));
        pounds.setText(String.valueOf(kg_in*2.20));
        tons.setText(String.valueOf(kg_in/1000));

    }


}