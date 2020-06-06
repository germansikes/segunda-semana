package com.dreamsense.segundasemana;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends android.support.v7.app.AppCompatActivity implements View.OnClickListener {

    private int año;
    private int mes;
    private int dia;
    private EditText etFecha;
    private EditText etNombre;
    private EditText etTel;
    private EditText etEmail;
    private EditText etDesc;
    private Button botonFecha;
    private Button botonSig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonFecha = (Button) findViewById(R.id.btnDate);
        botonFecha.setOnClickListener(this);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etTel = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDesc = (EditText) findViewById(R.id.etDescripcion);

        botonSig = (Button) findViewById(R.id.btnSig);

        Bundle datosretornados = getIntent().getExtras();
        if (datosretornados != null) {


            //Asignar los valores;
            String rnombre = datosretornados.getString("nombre");
            String rfecha = datosretornados.getString("fecha");
            String rtel = datosretornados.getString("tel");
            String remail = datosretornados.getString("email");
            String rdescrip = datosretornados.getString("desc");

            etNombre.setText(rnombre);
            etFecha.setText(rfecha);
            etEmail.setText(remail);
            etTel.setText(rtel);
            etDesc.setText(rdescrip);
        }

        botonSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalleUsuario.class);
                intent.putExtra("dato", etNombre.getText().toString());
                intent.putExtra("fecha", etFecha.getText().toString());
                intent.putExtra("Tel", etTel.getText().toString());
                intent.putExtra("email", etEmail.getText().toString());
                intent.putExtra("desc", etDesc.getText().toString());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == botonFecha) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            año = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            dia = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            etFecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            Snackbar.make(view, "Fecha Seleccionada.", Snackbar.LENGTH_SHORT).show();

                        }
                    }, año, mes, dia);
            datePickerDialog.show();
            Snackbar.make(v, "Fecha Seleccionada.", Snackbar.LENGTH_SHORT).show();
        }
    }

}
