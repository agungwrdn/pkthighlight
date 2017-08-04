package com.pupukkaltim.pkthighlight.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pupukkaltim.pkthighlight.R;
import com.pupukkaltim.pkthighlight.subadmin.penjualan.tonase.tonase;
import com.pupukkaltim.pkthighlight.subadmin.penjualan.stok.stok;

public class PenjualanAdmin extends AppCompatActivity implements View.OnClickListener {
    private Button btnTonase, btnStok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan_admin);
        btnTonase = (Button) findViewById(R.id.btnTonase);
        btnStok = (Button) findViewById(R.id.btnStok);

        btnStok.setOnClickListener(this);
        btnTonase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnStok){
            Intent dia = new Intent(this, stok.class);
            startActivity(dia);
        } else if(v == btnTonase){
            Intent dia = new Intent(this, tonase.class);
            startActivity(dia);
        }
    }
}
