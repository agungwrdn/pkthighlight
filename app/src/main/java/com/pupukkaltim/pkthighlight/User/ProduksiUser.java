package com.pupukkaltim.pkthighlight.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pupukkaltim.pkthighlight.R;
import com.pupukkaltim.pkthighlight.subuser.produksi.downtime.Downtime;
import com.pupukkaltim.pkthighlight.subuser.produksi.konsumsi.Konsumsi;
import com.pupukkaltim.pkthighlight.subuser.produksi.tonase.Tonase;


public class ProduksiUser extends AppCompatActivity implements View.OnClickListener {
    Button btnTonase, btnGas, btnOSD, btnDTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produksi_user);
        btnDTP = (Button) findViewById(R.id.btnDownTime);
        btnTonase = (Button) findViewById(R.id.btnTonase);
        btnGas = (Button) findViewById(R.id.btnKonsumsi);
        btnOSD = (Button) findViewById(R.id.btnOnStream);

        btnOSD.setOnClickListener(this);
        btnGas.setOnClickListener(this);
        btnDTP.setOnClickListener(this);
        btnTonase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnTonase){
            final Intent dia = new Intent(this, Tonase.class);
            startActivity(dia);
        } else if (v == btnGas){
            final Intent dia = new Intent(this, Konsumsi.class);
            startActivity(dia);
        } else if (v == btnDTP){
            final Intent dia = new Intent(this, Downtime.class);
            startActivity(dia);
        }
    }
}
