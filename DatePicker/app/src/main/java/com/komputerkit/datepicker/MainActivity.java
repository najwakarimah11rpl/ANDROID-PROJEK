package com.komputerkit.datepicker;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etTanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        load();
    } public void load(){
        etTanggal=findViewById(R.id.etTanggal);
    }
    public void etTanggal(View view) {
            Calendar cal=Calendar.getInstance();
            int tgl=cal.get(Calendar.DAY_OF_MONTH);
            int bln=cal.get(Calendar.MONTH);
            int thn=cal.get(Calendar.YEAR);
        DatePickerDialog dtp=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int thn, int bln, int tgl) {
                String tanggal = tgl + "-" + (bln + 1) + "-" + thn;
                etTanggal.setText(tanggal);
            }
//
//            @Override
//                public void onDateSet(DatePicker view, int thn, int bln,int tgl){
//                    etTanggal.(tgl+"-"+(bln+1)+"-"+thn);
//                }
            }, thn, bln, tgl);
        dtp.show();
        }}
