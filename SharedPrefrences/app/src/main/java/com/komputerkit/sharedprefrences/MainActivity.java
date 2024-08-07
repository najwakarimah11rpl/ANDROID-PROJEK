package com.komputerkit.sharedprefrences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView etBarang, etStok;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load() {
        etBarang = findViewById(R.id.etBarang);
        etStok = findViewById(R.id.etStok);
        sharedPreferences = getSharedPreferences("barang", MODE_PRIVATE);
    }

    public void isiSharedPreferences(String barang, float stok) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("barang", barang);
        editor.putFloat("stok", stok);
        editor.apply();
    }

    public void simpan(View view) {
        String barang = etBarang.getText().toString();
        float stok = 0;

        try {
            stok = Float.parseFloat(etStok.getText().toString());
        } catch (NumberFormatException e) {
            stok = 0.0f;
        }

        if (barang.isEmpty() || stok == 0.0f) {
            Toast.makeText(this, "Data kosong atau stok tidak valid", Toast.LENGTH_SHORT).show();
        } else {
            isiSharedPreferences(barang, stok);
            Toast.makeText(this, "Data sudah disimpan", Toast.LENGTH_SHORT).show();
        }
        etBarang.setText("");
        etStok.setText("");
    }

    public void tampil(View view) {
        String barang = sharedPreferences.getString("barang", "Tidak ada data");
        float stok = sharedPreferences.getFloat("stok", 0.0f);

        etBarang.setText(barang);
        etStok.setText(Float.toString(stok));
    }
}
