package com.pupukkaltim.pkthighlight;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginAdmin extends AppCompatActivity implements View.OnClickListener {
    EditText Email, password;
    Button login;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        Email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onLoginUser();
    }

    private void onLoginUser() {
        if(getUserEmail().equals("admin@pkt.com") && getUserPassword().equals("adminpkt")){
            logIn(getUserEmail(), getUserPassword());
        } else {
            showFieldsAreRequired();
        }
    }

    private void logIn(String getUserEmail, String getUserPassword) {
        showAlertDialog("Log In...",false);

        mAuth.signInWithEmailAndPassword(getUserEmail, getUserPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                dismissAlertDialog();
                if(task.isSuccessful()){
                    goToMainActivity();
                }else {
                    showAlertDialog(task.getException().getMessage(),true);
                }
            }
        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(LoginAdmin.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void dismissAlertDialog() {
        dialog.dismiss();
    }

    private void showAlertDialog(String message, boolean isCancelable) {
        dialog = buildAlertDialog(getString(R.string.login_error_title), message,isCancelable,LoginAdmin.this);
        dialog.show();
    }

    public static AlertDialog buildAlertDialog(String title, String message, boolean isCancelable, Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setTitle(title);

        if(isCancelable){
            builder.setPositiveButton(android.R.string.ok, null);
        }else {
            builder.setCancelable(false);
        }
        return builder.create();
    }

    private void showFieldsAreRequired() {
        showAlertDialog(getString(R.string.emailSalah),true);
    }

    private String getUserPassword() {
        return password.getText().toString().trim();
    }

    private String getUserEmail() {
        return Email.getText().toString().trim();
    }
}
