package com.pupukkaltim.pkthighlight.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.pupukkaltim.pkthighlight.R;
import com.pupukkaltim.pkthighlight.subadmin.produksi.downtime.downtimeAdmin;
import com.pupukkaltim.pkthighlight.subadmin.produksi.konsumsi.konsumsiProduksiAdmin;
import com.pupukkaltim.pkthighlight.subadmin.produksi.onstream.onStreamAdmin;
import com.pupukkaltim.pkthighlight.subadmin.produksi.tonase.TonaseProduksiAdmin;

public class ProduksiAdmin extends AppCompatActivity implements View.OnClickListener {
    private Button btnTonase, btnGas, btnOSD, btnDTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produksi_admin);
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
            Intent dia = new Intent(this, TonaseProduksiAdmin.class);
            startActivity(dia);
        } else if (v == btnGas){
            Intent dia = new Intent(this, konsumsiProduksiAdmin.class);
            startActivity(dia);
        } else if (v == btnDTP){
            Intent dia = new Intent(this, downtimeAdmin.class);
            startActivity(dia);
        } else if(v == btnOSD){
            Intent dia = new Intent(this, onStreamAdmin.class);
            startActivity(dia);
        }
    }
}
