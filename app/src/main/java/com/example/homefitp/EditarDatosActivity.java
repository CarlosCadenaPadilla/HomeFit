package com.example.homefitp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.homefitp.Entidades.Usuario;
import com.example.homefitp.modeloDAO.UsuarioDAO;

public class EditarDatosActivity extends AppCompatActivity implements View.OnClickListener {

    String[] GENEROS = new String[]{"Femenino", "Masculino", "Otro"};
    String[] DIFICULTADES = new String[]{"Alta", "Media", "Baja"};

    EditText editTextNombre, editTextEdad, editTextPeso, editTextAltura;
    AutoCompleteTextView editTextGenero, editTextDificultad;
    RadioGroup radioGroupObjetivo;
    RadioButton selectedRadioButton;
    String objetivo;
    Button guardar;
    ImageView imageViewUsuario;

    Usuario usuario;
    UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_datos);

        editTextNombre = findViewById(R.id.edittextNombre);
        editTextAltura = findViewById(R.id.edittextAltura);
        editTextEdad = findViewById(R.id.edittextEdad);
        editTextPeso = findViewById(R.id.edittextPeso);
        radioGroupObjetivo = findViewById(R.id.rgObjetivo);


        editTextGenero = findViewById(R.id.editTextAutocompleteGenero);
        editTextDificultad = findViewById(R.id.editTextAutocompleteDificultad);

        imageViewUsuario = findViewById(R.id.imageViewUsuario);

        guardar = findViewById(R.id.buttonGuardar);
        guardar.setOnClickListener(this);

        usuario = MyApplication.getUsuario();
        usuarioDAO = new UsuarioDAO(this);

        editTextNombre.setText(usuario.getNombre());
        editTextGenero.setText(usuario.getSexo());
        editTextDificultad.setText(usuario.getDificultad_deseada());
        editTextPeso.setText(Integer.toString(usuario.getPeso()));
        editTextEdad.setText(usuario.getEdad());
        editTextAltura.setText(Integer.toString(usuario.getEstatura()));


        if (usuario.getObjetivo().equals("Bajar de Peso")) {
            RadioButton rbBajarPeso = findViewById(R.id.rbBajarPeso);
            rbBajarPeso.setChecked(true);
        } else {
            if (usuario.getObjetivo().equals("Tonificar")) {
                RadioButton rbTonificar = findViewById(R.id.rbTonificar);
                rbTonificar.setChecked(true);
            }
        }

        if (usuario.getSexo().equals("Femenino")) {
            imageViewUsuario.setImageResource(R.drawable.female_user);
        } else {
            imageViewUsuario.setImageResource(R.drawable.male_user);
        }

        ArrayAdapter<String> adapterGeneros = new ArrayAdapter<String>(this, R.layout.options_dropdown, GENEROS);
        ArrayAdapter<String> adapterDificultades = new ArrayAdapter<String>(this, R.layout.options_dropdown, DIFICULTADES);


        editTextGenero.setAdapter(adapterGeneros);
        editTextDificultad.setAdapter(adapterDificultades);

        editTextGenero.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == 0) {
                    imageViewUsuario.setImageResource(R.drawable.female_user);
                } else {
                    imageViewUsuario.setImageResource(R.drawable.male_user);
                }
            }
        });

        radioGroupObjetivo.setOnCheckedChangeListener(radioGroupListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.AppBar);
        toolbar.setTitle("Editar Perfil");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    RadioGroup.OnCheckedChangeListener radioGroupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            selectedRadioButton = findViewById(checkedId);
        }
    };

    @Override
    public void onClick(View v) {
        usuario.setNombre(editTextNombre.getText().toString());
        usuario.setEdad(editTextEdad.getText().toString());
        usuario.setEstatura(Integer.parseInt(editTextAltura.getText().toString()));
        usuario.setPeso(Integer.parseInt(editTextPeso.getText().toString()));
        usuario.setSexo(editTextGenero.getText().toString());
        usuario.setDificultad_deseada(editTextDificultad.getText().toString());
        if (selectedRadioButton != null) {
            usuario.setObjetivo(selectedRadioButton.getText().toString());
        }

        long id = usuarioDAO.updateUsuario(usuario);
        if (id > -1) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

    }
}