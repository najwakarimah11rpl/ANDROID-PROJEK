package com.komputerkit.recyclerviewcardview;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    load();}
    public void load(){
        recyclerView=findViewById(R.id.rcvSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    } public void isiData(){
        siswaList=new ArrayList<Siswa>();
        siswaList.add(new Siswa("Joni", "Surabaya"));
        siswaList.add(new Siswa("eko", "Surabaya"));
        siswaList.add(new Siswa("eki", "Surabaya"));
        siswaList.add(new Siswa("ani", "Surabaya"));
        siswaList.add(new Siswa("rani", "Surabaya"));
        siswaList.add(new Siswa("sigma", "Surabaya"));
        siswaList.add(new Siswa("sigmi", "Surabaya"));
        siswaList.add(new Siswa("sigmi", "Surabaya"));

        adapter=new SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);
    }
    public void bttnTambah(View view){
        siswaList.add(new Siswa("Rembo", "Jakarta"));
        adapter.notifyDataSetChanged();
    }


}