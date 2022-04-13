package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private TextView TBresult;
    private EditText TXword;
    private Button BTNexecute;
    private String word;

    private void initViews() {
        TBresult = findViewById(R.id.TBresult);
        TXword = findViewById(R.id.TXword);
        BTNexecute = findViewById(R.id.BTNexecute);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        /* Para el evento .setOnClickListener() podemos enviar un metodo o funcion (funcion Anonima)
        llamando a la interfaz .OnClickListener() que ejecute el procedimiento solo para el boton
        que llame al .setOnClickListener()
                Nombre_del_Boton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
        En funcion LAMBDA
                Nombre_del_Boton.setOnClickListener(view -> {
                });
        */
        BTNexecute.setOnClickListener(view -> {
            recibeData();
            investWord();
        });
    }
    private void recibeData() {
        word = TXword.getText().toString().toLowerCase();
    }
    private void investWord() {
        // Usando StringBuilder con Java sin usar codigo de Android
        //        word = new StringBuilder(word).reverse().toString();
        // Usando el metodo .charAt(i) que maneja una palabra como Array...
        //        .charAt(i) identifica un caracter de la palabra en posicion i
        String invest = "";
        for (int i = this.word.length() - 1; i >= 0; i--) {
            invest += this.word.charAt(i);
        }
        // Verificamos si la palabra es un palindromo
        if (this.word.equals(invest)) TBresult.setText("Es un palindromo");
        else TBresult.setText("No es un palindromo");
    }
}