package com.pupukkaltim.pkthighlight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {
    Button admin,user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        admin = (Button)findViewById(R.id.btnAdmin);
        user = (Button)findViewById(R.id.btnUser);
        user.setOnClickListener(this);
        admin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == user){
            Intent user = new Intent(ChooseActivity.this, UserActivity.class);
            startActivity(user);
        } else {
            Intent admin = new Intent(ChooseActivity.this, LoginAdmin.class);
            startActivity(admin);
        }
    }
}
