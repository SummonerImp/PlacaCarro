package com.example.placacarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultadoPlaca extends AppCompatActivity {
    TextView txtRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_placa);
        txtRes = (TextView)findViewById(R.id.txtRes);
        Intent intent = getIntent();
        String rod = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        txtRes.setText(getText(R.string.rodizio)+rod);
    }
}
