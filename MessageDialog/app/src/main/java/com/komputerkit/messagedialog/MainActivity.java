package com.komputerkit.messagedialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize any UI components or set up listeners here if needed
    }

    public void showToast(String pesan) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String pesan) {
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("PERHATIAN!");
        buatAlert.setMessage(pesan);
        buatAlert.setPositiveButton("OK", null); // Optional positive button
        buatAlert.show();
    }

    public void showAlertButton(String pesan) {
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);
        showAlert.setTitle("PERINGATAN");
        showAlert.setMessage(pesan);

        showAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data sudah dihapus");
            }
        });

        showAlert.setNegativeButton("NO", null);
        showAlert.show();
    }

    public void btnToast(View view) {
        showToast("Selamat belajar");
    }

    public void btnAlert(View view) {
        showAlert("Selamat belajar");
    }

    public void btnAlertDialogButton(View view) {
        showAlertButton("Yakin akan menghapus?");
    }
}
