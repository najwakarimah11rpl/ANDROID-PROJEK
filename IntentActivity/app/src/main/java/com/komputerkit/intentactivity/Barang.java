package com.komputerkit.intentactivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Barang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_barang);
       load();
       ambilData();
    } public void load(){
        tvbarang=findViewById(R.id.tvBarang);
    } public void ambilData(){
        String ambil=getIntent().getStringExtra("ISI");
        tvbarang.setText(ambil);
    }
}
