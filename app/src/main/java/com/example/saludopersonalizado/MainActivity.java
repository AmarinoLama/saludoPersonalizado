package com.example.saludopersonalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_nacimiento;
    Button btn_saludar;
    TextView tv_saludo, tv_despedida;
    RadioGroup rg_genero, rg_despedida;
    RadioButton rb_masculino, rb_femenino, rb_pronto, rb_adios;
    CheckBox cb_despedida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        btn_saludar.setOnClickListener(view -> {
            logicaBtn();
        });

        cb_despedida.setOnClickListener(view -> {
            rg_despedida.setVisibility(cb_despedida.isChecked() ? View.VISIBLE : View.GONE);
            tv_despedida.setVisibility(cb_despedida.isChecked() ? View.VISIBLE : View.GONE);
        });
    }

    public void logicaBtn() {
        if (et_nombre.getText().toString().isEmpty() || et_nacimiento.getText().toString().isEmpty()) {
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
            return;
        }
        tv_saludo.setText("Hola, " + genero() + et_nombre.getText().toString() + ". \nEres " + edad() + despedida());
    }

    public String edad() {
        int nacimiento = Integer.parseInt(et_nacimiento.getText().toString());
        return nacimiento <= 2005 ? "mayor de edad" : "menor de edad";
    }

    public String genero() {
        return rb_masculino.isChecked() ? "Sr." : "Sra.";
    }

    public String despedida() {
        if (!cb_despedida.isChecked()) return "";
        return rb_adios.isChecked() ? "\nADIOS" : "\nHASTA PRONTO";
    }

    public void inicializar() {
        et_nombre = findViewById(R.id.et_nombre);
        et_nacimiento = findViewById(R.id.et_nacimiento);
        btn_saludar = findViewById(R.id.btn_saludar);
        tv_saludo = findViewById(R.id.tv_saludo);
        rg_genero = findViewById(R.id.rg_genero);
        rb_masculino = findViewById(R.id.rb_masculino);
        rb_femenino = findViewById(R.id.rb_femenino);
        cb_despedida = findViewById(R.id.cb_despedida);
        rb_adios = findViewById(R.id.rb_adios);
        rb_pronto = findViewById(R.id.rb_pronto);
        rg_despedida = findViewById(R.id.rg_despedida);
        tv_despedida = findViewById(R.id.tv_despedida);
    }
}