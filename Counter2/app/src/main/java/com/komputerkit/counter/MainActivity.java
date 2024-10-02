package com.komputerkit.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    private void load() {
        tvHasil = findViewById(R.id.tvHasil);
    }

    public void btnUP(View view) {
        count++;
        tvHasil.setText(String.valueOf(count));
    }

    public void btnDown(View view) {
        count--;
        tvHasil.setText(String.valueOf(count));
    }
}
