package com.example.homefitp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.homefitp.Entidades.Usuario;
import com.example.homefitp.modeloDAO.UsuarioDAO;

public class RegistroDatosActivity extends AppCompatActivity implements View.OnClickListener {

    private String nombre, correo, contraseña;
    private EditText edad, peso, altura;
    private RadioGroup rgGenero, rgObjetivo, rgDificultad;
    private Button enviar;
    private String genero, objetivo, dificultad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrodatos_activity);
        nombre = getIntent().getStringExtra("nombre");
        correo = getIntent().getStringExtra("correo");
        contraseña = getIntent().getStringExtra("contraseña");

        edad = findViewById(R.id.etEdad);
        peso = findViewById(R.id.etPeso);
        altura = findViewById(R.id.etAltura);

        rgGenero = findViewById(R.id.rgGenero);
        rgObjetivo = findViewById(R.id.rgObjetivo);
        rgDificultad = findViewById(R.id.rgDificultad);

        enviar = findViewById(R.id.btnEnviar);
        enviar.setOnClickListener(this);

        rgGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbFemenino : genero = "Femenino";
                    break;
                    case R.id.rbMasculino : genero = "Masculino";
                    break;
                    case R.id.rbOtro : genero = "Otro";
                    break;
                }
            }
        });

        rgObjetivo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbBajarPeso : objetivo = "Bajar de Peso";
                        break;
                    case R.id.rbTonificar : objetivo = "Tonificar";
                        break;
            }
        }});

        rgDificultad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbDificultadAlta : dificultad = "Alta";
                        break;
                    case R.id.rbDificultadMedia : dificultad = "Media";
                        break;
                    case R.id.rbDificultadBaja : dificultad = "Baja";
                        break;
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        Usuario usuario = new Usuario(nombre, correo, contraseña, edad.getText().toString(), genero, Integer.parseInt(altura.getText().toString()), Integer.parseInt(peso.getText().toString()), dificultad, objetivo);
        UsuarioDAO usuarioDAO = new UsuarioDAO(RegistroDatosActivity.this);
        long id = usuarioDAO.insertUsuario(usuario);

        if(id>-1){
            Intent intent = new Intent(this, LoginActivity.class);
        }else{
            Toast.makeText(RegistroDatosActivity.this,"Error en la conexión",Toast.LENGTH_SHORT).show();
        }
    }
}