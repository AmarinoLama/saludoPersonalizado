package com.example.saludopersonalizado;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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
    TextView tv_saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        btn_saludar.setOnClickListener(view -> {
            logicaBtn();
        });
    }

    public void logicaBtn() {
        if (et_nombre.getText().toString().isEmpty() || et_nacimiento.getText().toString().isEmpty()) {
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
            return;
        }
        tv_saludo.setText("Hola, " + et_nombre.getText().toString() + ". Eres " + edad());
    }

    public void inicializar() {
        et_nombre = findViewById(R.id.et_nombre);
        et_nacimiento = findViewById(R.id.et_nacimiento);
        btn_saludar = findViewById(R.id.btn_saludar);
        tv_saludo = findViewById(R.id.tv_saludo);
    }

    public String edad() {
        int nacimiento = Integer.parseInt(et_nacimiento.getText().toString());
        return nacimiento <= 2005 ? "mayor de edad" : "menor de edad";
    }
}