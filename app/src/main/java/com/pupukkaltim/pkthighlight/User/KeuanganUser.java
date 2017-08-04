package com.pupukkaltim.pkthighlight.User;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pupukkaltim.pkthighlight.R;
import com.pupukkaltim.pkthighlight.subuser.keuangan.LR.LabaRugi;
import com.pupukkaltim.pkthighlight.subuser.keuangan.hpp.HPP;
import com.pupukkaltim.pkthighlight.subuser.keuangan.kas.PosisiKas;
import com.pupukkaltim.pkthighlight.subuser.keuangan.pinjaman.Pinjaman;

import java.io.File;


public class KeuanganUser extends AppCompatActivity implements View.OnClickListener {
    private Button btnLR, btnKas, btnPinjaman, btnHPP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keuangan_user);
        btnLR = (Button) findViewById(R.id.btnLR);
        btnKas = (Button) findViewById(R.id.btnKas);
        btnPinjaman = (Button) findViewById(R.id.btnPinjaman);
        btnHPP = (Button) findViewById(R.id.btnHPP);

        btnHPP.setOnClickListener(this);
        btnLR.setOnClickListener(this);
        btnPinjaman.setOnClickListener(this);
        btnKas.setOnClickListener(this);

        File dir1 = new File(Environment.getExternalStorageDirectory().toString()+"/Download/PKT");
        dir1.mkdir();
        File dir2 = new File(Environment.getExternalStorageDirectory().toString()+"/Download/PKT/Keuangan");
        dir2.mkdir();
    }

    @Override
    public void onClick(View v) {
        if (v == btnHPP){
            Intent dia = new Intent(this, HPP.class);
            startActivity(dia);
        } else if(v == btnKas){
            Intent dia = new Intent(this, PosisiKas.class);
            startActivity(dia);
        } else if (v == btnLR){
            Intent dia = new Intent(this, LabaRugi.class);
            startActivity(dia);
        } else if(v == btnPinjaman){
            Intent dia = new Intent(this, Pinjaman.class);
            startActivity(dia);
        }
    }
}
