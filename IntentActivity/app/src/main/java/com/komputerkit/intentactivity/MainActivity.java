package com.komputerkit.intentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    private void load() {
        etBarang = findViewById(R.id.etBarang);
    }

    public void btnBarang(View view) {
        String barang = etBarang.getText().toString();
        Intent intent = new Intent(this, BarangActivity.class);
        intent.putExtra("ISI", barang);
        startActivity(intent);
    }
}
