package com.example.proyecto2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Clases.campeon;
import Excepciones.datosIncompletosException;

public class IngresarDatos extends AppCompatActivity {


    String medalla;
    String pais;
    String deporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ingresar_datos);

        Spinner medallaSp = findViewById(R.id.medallaSp);
        Spinner paisSp = findViewById(R.id.paisSp);
        Spinner deporteSp = findViewById(R.id.deporteSp);
        EditText nombreTxt = findViewById(R.id.nombreTxt);
        Button guardarBtn = findViewById(R.id.guardarBtn);
        Button salirBtn = findViewById(R.id.salirBtn);
        RadioGroup sexoRb = findViewById(R.id.radioFemMas);



        List<String> medallas = Arrays.asList("","Oro","Plata","Bronce");
        ArrayAdapter<String> adapterMedalla = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, medallas);
        adapterMedalla.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medallaSp.setAdapter(adapterMedalla);
        medallaSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                medalla = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        String[] olympicCountries = {"","Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Federated States of Micronesia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Great Britain", "Greece", "Grenada", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Puerto Rico", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
        ArrayAdapter<String> adapterPaises = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,olympicCountries);
        adapterPaises.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paisSp.setAdapter(adapterPaises);

        paisSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pais = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> deportesOlimpicos = new ArrayList<>(Arrays.asList("","Atletismo", "Natación", "Gimnasia artística", "Gimnasia rítmica", "Voleibol", "Baloncesto", "Fútbol", "Balonmano", "Boxeo", "Lucha libre", "Lucha grecorromana", "Judo", "Taekwondo", "Esgrima", "Tiro con arco", "Tiro deportivo", "Tenis", "Tenis de mesa", "Bádminton", "Ciclismo en ruta", "Ciclismo en pista", "Ciclismo BMX", "Ciclismo de montaña", "Halterofilia", "Remo", "Piragüismo en aguas tranquilas", "Piragüismo en aguas bravas", "Vela", "Hockey sobre césped", "Rugby 7", "Golf", "Equitación", "Triatlón", "Escalada deportiva", "Skateboarding", "Surf", "Karate", "Béisbol/Sóftbol", "Pentatlón moderno", "Waterpolo"));
        ArrayAdapter<String> adapterDeportes = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,deportesOlimpicos);
        adapterDeportes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deporteSp.setAdapter(adapterDeportes);
        deporteSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                deporte = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        guardarBtn.setOnClickListener(v ->{
            String nombre = nombreTxt.getText().toString();
            String sexo="";

            int seleccionado = sexoRb.getCheckedRadioButtonId();
            if(seleccionado!=-1){
                RadioButton radioSelec = findViewById(seleccionado);
                sexo=radioSelec.getText().toString();

            }
            campeon cp = new campeon(medalla,pais,deporte,nombre,sexo);
            try {
                datosCompletos(medalla,pais,deporte,nombre,sexo);
                guardarEnArchivo(cp);
                Toast.makeText(this,"Datos Guardados con exito", Toast.LENGTH_SHORT).show();


            }catch(datosIncompletosException d){
                Toast.makeText(this,d.getMessage(),Toast.LENGTH_SHORT).show();

            }

        });


        salirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IngresarDatos.this,MainActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void datosCompletos(String medalla, String pais, String deporte, String nombreAtleta, String sexo) throws datosIncompletosException {

        if(!medalla.isEmpty() && !pais.isEmpty() && !deporte.isEmpty() && !nombreAtleta.isEmpty() && !sexo.isEmpty()){

        }else{
            throw new datosIncompletosException("Faltan datos");
        }

    }


    public void guardarEnArchivo(campeon ca){
        FileWriter fw=null;
        String nombre = ca.getNombreAtleta();
        String medalla = ca.getMedalla();
        String sexo = ca.getSexo();
        String deporte = ca.getDeporte();
        String pais = ca.getPais();
        String contenido = nombre+" "+medalla+" "+sexo+" "+deporte+" "+pais;
        try {
            File file = new File(getFilesDir(), "campeones.txt");
            fw = new FileWriter(file, true);
            fw.write(contenido + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}