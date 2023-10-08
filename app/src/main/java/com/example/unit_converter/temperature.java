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

public class temperature extends AppCompatActivity {
    EditText inputnum;
    Spinner unit;
    TextView c,f,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        ImageView leftIcon = findViewById(R.id.left_icon_temp);

        inputnum=findViewById(R.id.inputnum);
        unit=findViewById(R.id.unit);
        c=findViewById(R.id.c);
        f=findViewById(R.id.f);
        k=findViewById(R.id.k);
        String[] arr={"c","f","k"};
        unit.setAdapter(new ArrayAdapter(temperature.this, android.R.layout.simple_list_item_activated_1,arr));
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
            Intent intent = new Intent(temperature.this, com.example.unit_converter.MainActivity.class);
            startActivity(intent);
        });
    }
    private void update() {
        if(!inputnum.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")){
            double in=Double.parseDouble(inputnum.getText().toString());
            switch (unit.getSelectedItem().toString()){
                case "c":
                    setT(in);
                    break;
                case "f":
                    setT((in-32)*5/9);
                    break;
                case "k":
                    setT(in-273.15);
                    break;
            }
        }
    }

    private void setT(double T_in) {
        c.setText(String.valueOf(T_in));
        f.setText(String.valueOf((T_in*9/5)+32));
        k.setText(String.valueOf(T_in+273.15));
    }
}