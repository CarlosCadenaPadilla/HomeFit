package com.example.homefitp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    Button mButtonLogin;
    Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mButtonLogin = (Button)findViewById(R.id.button_login);
        mButtonRegister = (Button)findViewById(R.id.button_register);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(PrincipalActivity.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RegisterIntent = new Intent(PrincipalActivity.this, RegisterActivity.class);
                startActivity(RegisterIntent);
            }
        });
    }
}