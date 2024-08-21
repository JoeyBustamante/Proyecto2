package com.example.proyecto2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Clases.EventoDeportivo;

public class Calendario extends AppCompatActivity {

    private EditText editTextDate;
    private LinearLayout linearLayoutVentas;
    private List<EventoDeportivo> ventasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendario);

        //Enalzar las variables de instancia con los views de la activity.
        editTextDate = findViewById(R.id.editTextDate);


        linearLayoutVentas=findViewById(R.id.linearLayoutVentas);
        // Inicializar la lista de ventas
        //ventasList=generarVentas();
        // Configurar el DatePicker
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpicker=new DatePickerDialog(Calendario.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int anioSel, int mesSel, int diaSel) {
                        String fechaSeleccionada=anioSel+"-"+(mesSel+1)+"-"+diaSel;
                        editTextDate.setText(fechaSeleccionada);
                        // mostrarVentasPorFecha(fechaSeleccionada);
                    }
                },year,month,day);
                dpicker.show();

            }
        });





    }



    private List<EventoDeportivo> generarLista(){
        try (InputStream fis = getAssets().open("eventos.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            List<EventoDeportivo> eventos = (ArrayList<EventoDeportivo>) ois.readObject();
            return eventos;


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }



    private void mostrarEventos(){

    }
}
