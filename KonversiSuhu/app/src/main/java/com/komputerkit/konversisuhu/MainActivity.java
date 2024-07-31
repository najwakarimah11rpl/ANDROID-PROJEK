package com.komputerkit.konversisuhu;

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

        };
    public void load(){
        spinner=findViewById(R.id.spinner);
        etNilai=findViewById(R.id.etNilai);
        tvHasil=findViewById(R.id.tvHasil);
    }

//    public void isiSpinner(){
//        String[] isi={"celsius to remaur", "to kelvin"};
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context: this,android.R.layout.simple_spinner_item,isi);
//    }
    public void btnKonversi(View view){
     String pilihan=spinner.getSelectedItem().toString();

     if(etNilai.getText().toString().equals("")){
         Toast.makeText(context: this, text:"nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
     } else{
         if(pilihan.equals("Celcius to Reamur")){
             cToR();
         }  if(pilihan.equals("Celcius to Fahrenheit")){
             cToF();
         }
     }
     System.out.printl(pilihan);
     cTor();}
    public void cToR(){
        double suhu=Double.parseDouble(etNilai.getText().toString());
        double hasil=(4.0/5.0)*suhu;
        tvHasil.seText(hasil+"");
    }
    public void cToF(){
        Toast.makeText(context: this, text:"belum dibuat", Toast.LENGTH_SHORT).show();
    }
    }
