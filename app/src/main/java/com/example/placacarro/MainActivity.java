package com.example.placacarro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myapp.MESSAGE";
    Button btnVerificar;
    EditText txtPlaca;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVerificar = (Button)findViewById(R.id.btnVerificar);
        txtPlaca = (EditText)findViewById(R.id.txtPlaca);
        textView = (TextView)findViewById(R.id.textView);
        textView.setText(R.string.txtMainText);
    }
    public void sendRes(View view){
        try {
            String placa = txtPlaca.getText().toString();
            String placa1 = placa.substring(placa.length() - 1);
            int i = Integer.parseInt(placa1);
            if(placa.matches("^[A-Za-z]{3}\\d{4}$")){
                String rod = null;
                if (i == 1 || i == 2) {
                    rod = getString(R.string.seg);
                } else if (i == 3 || i == 4) {
                    rod = getString(R.string.ter);
                } else if (i == 5 || i == 6) {
                    rod = getString(R.string.qua);
                } else if (i == 7 || i == 8) {
                    rod = getString(R.string.qui);
                } else if (i == 9 || i == 0) {
                    rod = getString(R.string.sex);
                }
                rod = String.valueOf(rod);
                Intent intent = new Intent(this, resultadoPlaca.class);
                intent.putExtra(EXTRA_MESSAGE, rod);
                startActivity(intent);
            }
            else{
                throw new Exception();
            }
        }catch(Exception e){
            txtPlaca.setText("");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.msgAviso);
            builder.setMessage(R.string.aviso);
            builder.setPositiveButton(R.string.msgBtn, null);
            builder.create().show();
        }
    }
}
