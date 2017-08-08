package com.pupukkaltim.pkthighlight.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pupukkaltim.pkthighlight.R;
import com.pupukkaltim.pkthighlight.subuser.penjualan.stok.stok;
import com.pupukkaltim.pkthighlight.subuser.penjualan.tonase.tonasePenjualan;
import com.pupukkaltim.pkthighlight.subuser.produksi.tonase.Tonase;


public class PenjualanUser extends AppCompatActivity implements View.OnClickListener {
    private Button btnTonase, btnStok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan_user);
        btnTonase = (Button) findViewById(R.id.btnTonasePenjualan);
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
            Intent dia = new Intent(this, tonasePenjualan.class);
            startActivity(dia);
        }
    }
}
