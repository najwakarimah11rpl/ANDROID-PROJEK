package com.komputerkit.sqlitedatabase;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Database db;
    EditText etBarang, etStok, etHarga;
    TextView tvPilihan;
    List<Barang> databarang = new ArrayList<>();
    BarangAdapter adapter;
    RecyclerView rcvBarang;

    String idbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this); // Assuming this line is part of your library setup

        load();
        selectData();
    }

    public void load() {
        db = new Database(this);
        db.buatTabel();

        etBarang = findViewById(R.id.etBarang);
        etStok = findViewById(R.id.etStok);
        etHarga = findViewById(R.id.etHarga);
        tvPilihan = findViewById(R.id.tvPilihan); // Assuming this TextView exists in your layout
        rcvBarang = findViewById(R.id.rcvBarang);
        rcvBarang.setLayoutManager(new LinearLayoutManager(this));
        rcvBarang.setHasFixedSize(true);
    }

    public void simpan(View v) {
        String barang = etBarang.getText().toString();
        String stok = etStok.getText().toString();
        String harga = etHarga.getText().toString();
        String pilihan = tvPilihan.getText().toString();

        if (barang.isEmpty() || stok.isEmpty() || harga.isEmpty()) {
            pesan("Data kosong");
        } else {
            if (pilihan.equals("insert")) {
                String sql = "INSERT INTO tblbarang (barang, stok, harga) VALUES ('" + barang + "', " + stok + ", " + harga + ")";

                if (db.runSQL(sql)) {
                    pesan("Insert berhasil");
                    selectData();
                } else {
                    pesan("Insert gagal");
                }
            } else if (pilihan.equals("update")) {
                String sql = "UPDATE tblbarang SET barang='" + barang + "', stok=" + stok + ", harga=" + harga + " WHERE idbarang=" + idbarang;

                if (db.runSQL(sql)) {
                    pesan("Data sudah diubah");
                    selectData();
                } else {
                    pesan("Data tidak bisa diubah");
                }
            }
        }

        etBarang.setText("");
        etStok.setText("");
        etHarga.setText("");
        tvPilihan.setText("insert");
    }

    public void pesan(String isi) {
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }

    public void selectData() {
        String sql = "SELECT * FROM tblbarang ORDER BY barang ASC";
        Cursor cursor = db.select(sql);

        databarang.clear(); // Clear the list before adding new data

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String idbarang = cursor.getString(cursor.getColumnIndex("idbarang"));
                String barang = cursor.getString(cursor.getColumnIndex("barang"));
                String stok = cursor.getString(cursor.getColumnIndex("stok"));
                String harga = cursor.getString(cursor.getColumnIndex("harga"));
                databarang.add(new Barang(idbarang, barang, stok, harga));
            } while (cursor.moveToNext());

            // Initialize or update the adapter
            if (adapter == null) {
                adapter = new BarangAdapter(this, databarang);
                rcvBarang.setAdapter(adapter);
            } else {
                adapter.notifyDataSetChanged();
            }
        } else {
            pesan("Data kosong");
        }

        if (cursor != null) {
            cursor.close();
        }
    }

    public void deleteData(String id) {
        idbarang = id;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("PERINGATAN");
        builder.setMessage("Yakin akan menghapus?");
        builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sql = "DELETE FROM tblbarang WHERE idbarang=" + idbarang;

                if (db.runSQL(sql)) {
                    pesan("Data sudah dihapus");
                    selectData();
                } else {
                    pesan("Data tidak bisa dihapus");
                }
            }
        });

        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void selectUpdate(String id) {
        idbarang = id;

        String sql = "SELECT * FROM tblbarang WHERE idbarang=" + idbarang;
        Cursor cursor = db.select(sql);

        if (cursor != null && cursor.moveToFirst()) {
            etBarang.setText(cursor.getString(cursor.getColumnIndex("barang")));
            etStok.setText(cursor.getString(cursor.getColumnIndex("stok")));
            etHarga.setText(cursor.getString(cursor.getColumnIndex("harga")));
            tvPilihan.setText("update");
        }

        if (cursor != null) {
            cursor.close();
        }
    }
}
