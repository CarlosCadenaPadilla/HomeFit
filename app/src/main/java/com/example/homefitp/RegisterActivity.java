package com.example.homefitp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextCorreo;
    EditText mTextPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextCorreo = (EditText) findViewById(R.id.edittext_correo);

        mButtonRegister = (Button) findViewById(R.id.button_register);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String correo = mTextCorreo.getText().toString().trim();
                final String user = mTextUsername.getText().toString().trim();
                final String pwd = mTextPassword.getText().toString().trim();


                DialogFragment dialog = RegistroDialog.newInstance();
                ((RegistroDialog) dialog).setCallback(new RegistroDialog.Callback() {
                    @Override
                    public void onAceptarClick() {
                        Intent intent = new Intent(RegisterActivity.this, RegistroDatosActivity.class);
                        intent.putExtra("nombre", user);
                        intent.putExtra("correo", correo);
                        intent.putExtra("contraseña", pwd);
                        startActivity(intent);
                    }
                });
                dialog.show(getSupportFragmentManager(), "tag");
            }
        });
    }
}