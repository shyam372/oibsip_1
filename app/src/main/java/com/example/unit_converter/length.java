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

public class length extends AppCompatActivity {
    ImageView left_icon_length;
    EditText inputnum;
    Spinner unit;
    TextView km,m,cm,foot,mile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        left_icon_length=findViewById(R.id.left_icon_length);

        inputnum=findViewById(R.id.inputnum);
        unit=findViewById(R.id.unit);
        km=findViewById(R.id.km);
        m=findViewById(R.id.m);
        cm=findViewById(R.id.cm);
        foot=findViewById(R.id.foot);
        mile=findViewById(R.id.mile);
        String[] arr={"km","m","cm","foot","mile"};
        unit.setAdapter(new ArrayAdapter(length.this, android.R.layout.simple_list_item_activated_1,arr));
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


        left_icon_length.setOnClickListener(v -> {
            Intent intent=new Intent(length.this,com.example.unit_converter.MainActivity.class);
            startActivity(intent);
        });
    }
    private void update() {
        if(!inputnum.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")){
            double in=Double.parseDouble(inputnum.getText().toString());
            switch (unit.getSelectedItem().toString()){
                case "km":
                    setKm(in);
                    break;
                case "m":
                    setKm(in/1000);
                    break;
                case "cm":
                    setKm(in/100000);
                    break;
                case "foot":
                    setKm(in/3281);
                    break;
                case "mile":
                    setKm(in*1.6);
                    break;
            }
        }
    }
    private void setKm(double km_in){
        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(km_in*1000));
        cm.setText(String.valueOf(km_in*100000));
        foot.setText(String.valueOf(km_in*3281));
        mile.setText(String.valueOf(km_in/1.6));

    }
}