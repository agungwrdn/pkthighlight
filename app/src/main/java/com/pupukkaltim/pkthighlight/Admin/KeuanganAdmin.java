package com.pupukkaltim.pkthighlight.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pupukkaltim.pkthighlight.R;
import com.pupukkaltim.pkthighlight.subadmin.keuangan.LR.LabaRugiAdmin;
import com.pupukkaltim.pkthighlight.subadmin.keuangan.hpp.HPPAdmin;
import com.pupukkaltim.pkthighlight.subadmin.keuangan.kas.PosisiKasAdmin;
import com.pupukkaltim.pkthighlight.subadmin.keuangan.pinjaman.PinjamanAdmin;

public class KeuanganAdmin extends AppCompatActivity implements View.OnClickListener {
    private Button btnLR, btnKas, btnPinjaman, btnHPP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keuangan_admin);
        btnLR = (Button) findViewById(R.id.btnLR);
        btnKas = (Button) findViewById(R.id.btnKas);
        btnPinjaman = (Button) findViewById(R.id.btnPinjaman);
        btnHPP = (Button) findViewById(R.id.btnHPP);

        btnHPP.setOnClickListener(this);
        btnLR.setOnClickListener(this);
        btnPinjaman.setOnClickListener(this);
        btnKas.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == btnHPP){
            Intent dia = new Intent(this, HPPAdmin.class);
            startActivity(dia);
        } else if(v == btnKas){
            Intent dia = new Intent(this, PosisiKasAdmin.class);
            startActivity(dia);
        } else if (v == btnLR){
            Intent dia = new Intent(this, LabaRugiAdmin.class);
            startActivity(dia);
        } else if(v == btnPinjaman){
            Intent dia = new Intent(this, PinjamanAdmin.class);
            startActivity(dia);
        }
    }
}
