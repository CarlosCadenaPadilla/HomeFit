package com.example.homefitp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homefitp.Entidades.Usuario;
import com.example.homefitp.modeloDAO.UsuarioDAO;

public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioDAO =  new UsuarioDAO(LoginActivity.this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mButtonLogin = (Button)findViewById(R.id.button_login);
        mTextViewRegister = (TextView)findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Usuario usuario = usuarioDAO.login(correo,pwd);

                if(usuario != null)
                {
                    MyApplication.setUsuario(usuario);
                    Intent HomePage = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(HomePage);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}