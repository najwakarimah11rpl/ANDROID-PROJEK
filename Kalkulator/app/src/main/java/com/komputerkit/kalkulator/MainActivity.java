package com.komputerkit.kalkulator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        load();

        public void load() {
        tvHasil= findViewById(R.id.tvHasil);}
        etBil_1=findViewById(R.id.etBil_1);
        etBil_2=findViewById(R.id.etBil_2);

        public void btnJumlah(View view){
            if (etBil_1.getText().toString().equals("") || etBil_2.getText().toString().equals("")){
                Toast.makeText(context;this, text;"ada bilangan yang kosong",Toast.LENGHT_SHORT)
                show();
        }
        else if{

            double bil_1=Double.parseDouble(etBil_1.getText(). toString());
            double bil_2=Double.parseDouble(etBil_2.getText(). toString());

            double hasil=bil_1+bil_2;
            tvHasil.seText(hasil+"");}
        else if{
            double hasil=bil_1-bil_2;
            tvHasil.seText(hasil+"");}}}}
