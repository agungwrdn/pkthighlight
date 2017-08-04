package com.pupukkaltim.pkthighlight.Admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.pupukkaltim.pkthighlight.R;
import com.pupukkaltim.pkthighlight.subadmin.lain.download.DownloadAdmin;
import com.pupukkaltim.pkthighlight.subadmin.lain.komoditas.KomoditasAdmin;

public class LainAdmin extends AppCompatActivity implements View.OnClickListener {
    private Button btnDownload, btnKomoditas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lain_admin);
        btnDownload = (Button) findViewById(R.id.btnDownload);
        btnKomoditas = (Button) findViewById(R.id.btnKomoditas);
        btnDownload.setOnClickListener(this);
        btnKomoditas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnDownload){
            Intent dia = new Intent(this, DownloadAdmin.class);
            startActivity(dia);
        }else if (v == btnKomoditas){
            Intent dia = new Intent(this, KomoditasAdmin.class);
            startActivity(dia);
        }
    }
}
