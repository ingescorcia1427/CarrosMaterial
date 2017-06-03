package com.example.cuc.carros;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.cuc.carros.R;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class AgregarCarro extends AppCompatActivity {
    private EditText cajaNchasis;
    private Spinner opc_marca, opc_color, opc_modelo;
    private boolean guardado;
    private TextInputLayout icajaNchasis, icajaMarca, icajaColor, icajaModelo;
    private String[] opc;
    private Resources res;
    private Adapter adapter1, adapter2, adapter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);


        opc_color = (Spinner)findViewById(R.id.spnColor);
        opc_modelo = (Spinner)findViewById(R.id.spnModelo);

        icajaNchasis = (TextInputLayout)findViewById(R.id.numChasis);
        icajaMarca = (TextInputLayout)findViewById(R.id.marcaCarro);
        icajaColor = (TextInputLayout)findViewById(R.id.colorCarro);
        icajaModelo = (TextInputLayout)findViewById(R.id.modeloCarro);
        guardado = false;

        cajaNchasis.addTextChangedListener(new TextWatcherPersonalizado(icajaNchasis,getResources().getString(R.string.mensaje_error_nchasis)) {
            @Override
            public boolean estaVacio(Editable s) {
                if(TextUtils.isEmpty(s) && !guardado) return true;
                else return false;
            }
        });
    }

    public int fotoAleatoria(){
        int fotos[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
        int numero = (int)(Math.random() * 5);
        return fotos[numero];
    }

}
