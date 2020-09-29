package com.example.homefitp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ims.RegistrationManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCfnPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCfnPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent (RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cfn_pwd = mTextCfnPassword.getText().toString().trim();

                if(pwd.equals(cfn_pwd))
                {
                    long val = db.addUser(user,pwd);
                    if(val>0)
                    {
                        Toast.makeText(RegisterActivity.this,"Yo Have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent (RegisterActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(RegisterActivity.this,"Password Incorrect",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}