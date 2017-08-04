package com.pupukkaltim.pkthighlight.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pupukkaltim.pkthighlight.R;
import com.pupukkaltim.pkthighlight.subuser.lain.download.Download;
import com.pupukkaltim.pkthighlight.subuser.lain.komoditas.Komoditas;

public class LainUser extends AppCompatActivity implements View.OnClickListener {
    private Button btnKomoditas, btnDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lain_user);
        btnDownload = (Button) findViewById(R.id.btnDownload);
        btnKomoditas = (Button) findViewById(R.id.btnkomoditas);
        btnKomoditas.setOnClickListener(this);
        btnDownload.setOnClickListener(this);
      }

    @Override
    public void onClick(View v) {
        if (v == btnKomoditas){
            Intent dia = new Intent(this, Komoditas.class);
            startActivity(dia);
        } else if(v == btnDownload){
            Intent dia = new Intent(this, Download.class);
            startActivity(dia);
        }
    }
}
