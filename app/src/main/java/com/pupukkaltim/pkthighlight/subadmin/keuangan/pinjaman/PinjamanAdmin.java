package com.pupukkaltim.pkthighlight.subadmin.keuangan.pinjaman;

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

public class PinjamanAdmin extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_PDF_REQUEST = 234;
    private PDFView PDF;
    private Button btnChoose, btnUpload;
    private Uri filePath;
    private StorageReference mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showadmin);
        PDF = (PDFView) findViewById(R.id.pdf);
        btnChoose = (Button) findViewById(R.id.btnChoosek);
        btnUpload = (Button) findViewById(R.id.uploadk);
        btnUpload.setOnClickListener(this);
        btnChoose.setOnClickListener(this);
        mStorageRef = FirebaseStorage.getInstance().getReference();
    }
    private void uploadFile(){
        if(filePath != null) {

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            StorageReference riversRef = mStorageRef.child("keuangan").child("Pinjaman Jangka Pendek.pdf");
            progressDialog.show();
            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"File Uploaded", Toast.LENGTH_SHORT);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),exception.getMessage(), Toast.LENGTH_SHORT);
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                            progressDialog.setMessage(((int) progress) + "% Uploaded" );
                        }
                    });

        } else {

        }
    }
    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select some file"), PICK_PDF_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
            PDF.fromUri(filePath).load();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnChoose){
            showFileChooser();
        } else if (v == btnUpload) {
            uploadFile();
        }
    }
}
