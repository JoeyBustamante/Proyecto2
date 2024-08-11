package com.example.proyecto2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Excepciones.CredencialesInvalidasException;

public class iniciarSecion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iniciar_secion);

        EditText usuarioTxt = findViewById(R.id.usuarioTxt);
        EditText contrasenaTxt = findViewById(R.id.contrasenaTxt);
        Button loginBtn = findViewById(R.id.iniciarSecionBtn2);

        loginBtn.setOnClickListener(v -> {
            String usuario = usuarioTxt.getText().toString();
            String contrasena = contrasenaTxt.getText().toString();

            try {
                autentificar(usuario, contrasena);
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
            } catch (CredencialesInvalidasException w) {
                Toast.makeText(this, w.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void autentificar(String usuario, String contrasena) throws CredencialesInvalidasException {
        if (!"admin".equals(usuario) || !"1234".equals(contrasena)) {
            throw new CredencialesInvalidasException("Usuario o contraseña incorrectos");
        }
    }
}
