package com.example.placacarro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

public class Foto extends AppCompatActivity {
    private static final int CAPTURAR_IMAGEM = 1;
    private Uri uri;
    Button btnTakePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        btnTakePic = (Button) findViewById(R.id.btnTakePic);
    }

    public void takePic(View v) {
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (it.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(it, CAPTURAR_IMAGEM);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(imageBitmap);
                TableLayout layout = (TableLayout) findViewById(R.id.layout);
                layout.addView(imageView);
                mostrarMensagem("Imagem capturada!");
            } else {
                mostrarMensagem("Imagem não capturada!");
            }
        }
        if (resultCode == Activity.RESULT_OK && requestCode == 123) {
            Uri imagemSelecionada = data.getData();
            ImageView imageView = new ImageView(this);
            imageView.setImageURI(imagemSelecionada);
        }
    }

    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}