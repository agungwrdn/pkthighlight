package com.pupukkaltim.pkthighlight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pupukkaltim.pkthighlight.Admin.KeuanganAdmin;
import com.pupukkaltim.pkthighlight.Admin.LainAdmin;
import com.pupukkaltim.pkthighlight.Admin.PenjualanAdmin;
import com.pupukkaltim.pkthighlight.Admin.ProduksiAdmin;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnKeuangan, btnLain, btnPenjualan, btnProduksi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKeuangan = (Button) findViewById(R.id.btnKeuangana);
        btnLain = (Button) findViewById(R.id.btnLaina);
        btnPenjualan = (Button) findViewById(R.id.btnPenjualana);
        btnProduksi = (Button) findViewById(R.id.btnProduksia);

        btnProduksi.setOnClickListener(this);
        btnLain.setOnClickListener(this);
        btnPenjualan.setOnClickListener(this);
        btnKeuangan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnKeuangan){
            Intent dia = new Intent(this, KeuanganAdmin.class);
            startActivity(dia);
        } else if (v == btnLain){
            Intent dia = new Intent(this, LainAdmin.class);
            startActivity(dia);
        } else if(v == btnPenjualan){
            Intent dia = new Intent(this, PenjualanAdmin.class);
            startActivity(dia);
        } else if (v == btnProduksi){
            Intent dia = new Intent(this, ProduksiAdmin.class);
            startActivity(dia);
        }
    }
}
