package com.ciglesias.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {

    LatLng positionClinica, positionParqueDelAgua, positionParqueSanPio, positionHomecenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        positionClinica = new LatLng(7.1167468, -73.1512181);
        positionHomecenter = new LatLng(7.1156964,-73.1225811);
        positionParqueDelAgua = new LatLng(7.1305213, -73.1118849);
        positionParqueSanPio = new LatLng(7.1185493, -73.112901);

        findViewById(R.id.id_btn_clinica_san_luis).setOnClickListener(onClickListenerUbicacion);
        findViewById(R.id.id_btn_homecenter).setOnClickListener(onClickListenerUbicacion);
        findViewById(R.id.id_btn_parque_san_pio).setOnClickListener(onClickListenerUbicacion);
        findViewById(R.id.id_btn_parque_del_agua).setOnClickListener(onClickListenerUbicacion);


    }

    private OnClickListener onClickListenerUbicacion = new OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent i = new Intent(MainActivity.this, MapsActivity.class);

            switch (v.getId()) {
                case R.id.id_btn_clinica_san_luis:
                    i.putExtra("position", positionClinica);
                    i.putExtra("title", "Clinica San luis");
                    break;
                case R.id.id_btn_homecenter:
                    i.putExtra("position", positionHomecenter);
                    i.putExtra("title", "HomeCenter");
                    break;
                case R.id.id_btn_parque_san_pio:
                    i.putExtra("position", positionParqueSanPio);
                    i.putExtra("title", "Parque san pio");
                    break;
                case R.id.id_btn_parque_del_agua:
                    i.putExtra("position", positionParqueDelAgua);
                    i.putExtra("title", "Parque del agua");
                    break;
            }

            startActivity(i);
        }
    };
}
