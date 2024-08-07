package com.komputerkit.intentactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Barang extends AppCompatActivity {

    private TextView tvBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);
        load();
        ambilData();
    }

    private void load() {
        tvBarang = findViewById(R.id.tvBarang);
    }

    private void ambilData() {
        String ambil = getIntent().getStringExtra("ISI");
        if (ambil != null) {
            tvBarang.setText(ambil);
        }
    }
}
