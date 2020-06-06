package com.dreamsense.segundasemana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleUsuario extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTel;
    private TextView tvEmail;
    private TextView tvDesc;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        Bundle datos = getIntent().getExtras();

        final String nombre = datos.getString("dato");
        final String fecha = datos.get("fecha").toString();
        final String tel = datos.get("Tel").toString();
        final String email = datos.get("email").toString();
        final String descripcion = datos.get("desc").toString();

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        btnEditar = (Button) findViewById(R.id.btnEditar);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTel.setText(tel);
        tvEmail.setText(email);
        tvDesc.setText(descripcion);


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleUsuario.this, MainActivity.class);

                intent.putExtra("nombre", nombre);
                intent.putExtra("fecha", fecha);
                intent.putExtra("tel", tel);
                intent.putExtra("email", email);
                intent.putExtra("desc", descripcion);

                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleUsuario.this, MainActivity.class);
            startActivity(intent);

            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
