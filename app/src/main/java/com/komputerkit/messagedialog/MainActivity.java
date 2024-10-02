package com.komputerkit.messagedialog;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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

        public void showToast(String pesan){
            Toast.makeText(context=this, pesan, Toast.LENGTH_SHORT).show();
        }
        public void showAlert(String pesan){
            AlertDialog.Builder buatAlert=new AlertDialog.Builder(context= this);
            buatAlert.setTitle("PERHATIAN!");
            buatAlert.setMessage(pesan);
            buatAlert.show();
        }
        public void showAlertButton(String pesan){
            AlertDialog.Builder showAlert=new AlertDialog.Builder(context= this);
            showAlert.setTitle("PERINGATAN");
            showAlert.setMessage(pesan);

            showAlert.setPositiveButton(text="NO", new DialogInterface.OnCancelListener()){
                public void onClick(DialogInterface dialog, int which){
                    showToast(pesan= "data syudah dihapus");
                }
            } showAlert.show();
        }
        public void btnToast(View view){
            showToast(pesan= "selamat belajar");
        } public void btnAlert(View view){
            showAlert(pesan= "selamat belajar");
        } public void btnAlertDialogButton(View view){
            showAlertButton(pesan= "yakin akan menghapus?");
        }
}}