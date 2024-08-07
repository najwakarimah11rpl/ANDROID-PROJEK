package com.komputerkit.konversisuhu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText etNilai;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        load();
        isiSpinner();
    }

    private void load() {
        spinner = findViewById(R.id.spinner);
        etNilai = findViewById(R.id.etNilai);
        tvHasil = findViewById(R.id.tvHasil);
    }

    private void isiSpinner() {
        String[] isi = {"Celsius to Reamur", "Celsius to Fahrenheit", "Celsius to Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, isi);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if (etNilai.getText().toString().equals("")) {
            Toast.makeText(this, "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            if (pilihan.equals("Celsius to Reamur")) {
                cToR();
            } else if (pilihan.equals("Celsius to Fahrenheit")) {
                cToF();
            } else if (pilihan.equals("Celsius to Kelvin")) {
                cToK();
            }
        }
        System.out.println(pilihan);
    }

    private void cToR() {
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0 / 5.0) * suhu;
        tvHasil.setText(hasil + "");
    }

    private void cToF() {
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9.0 / 5.0) * suhu + 32;
        tvHasil.setText(hasil + "");
    }

    private void cToK() {
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu + 273.15;
        tvHasil.setText(hasil + "");
    }
}
