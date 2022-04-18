package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private TextView TBresult;
    private EditText TXword;
    private Button BTNexecute;
    private Button BTNmessage;
    private String word;
    private String invest;

    private void initViews() {
        TBresult = findViewById(R.id.TBresult);
        TXword = findViewById(R.id.TXword);
        BTNexecute = findViewById(R.id.BTNexecute);
        BTNmessage = findViewById(R.id.BTNmessage);
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
        BTNmessage.setOnClickListener(view -> {
            seemessage();
        });
    }
    private void recibeData() {
        word = TXword.getText().toString().toLowerCase();
    }
    private void investWord() {
        /* Usando StringBuilder con Java sin usar codigo de Android
               word = new StringBuilder(word).reverse().toString();
        Usando el metodo .charAt(i) que maneja una palabra como Array...
               .charAt(i) identifica un caracter de la palabra en posicion i*/
        invest = "";
        for (int i = this.word.length() - 1; i >= 0; i--) {
            invest += this.word.charAt(i);
        }
        // Verificamos si la palabra es un palindromo
        if (this.word.equals(invest)) TBresult.setText("Es un palindromo");
        else TBresult.setText("No es un palindromo");
    }
    private void seemessage() {
        /* Utilizamos  una ventana emergente para mostrar confirmaciones o mensajes
        Con un metodo estatico de Java */
        /* Utilizaremos los siguients elementos para realizar el funcionamiento
         - Ambito o contexto que se eva a usar (pantalla) context:
         - Cadena de Caracteres text:
         - Constante derivada del mensaje con un temporizador Toast.LENGTH_LONG o Toast.LENGTH_SHORT
         Luego hacemos que el toast se configure con esos elementos y usamos el metodo .show()*/
        String seeMessage = convertir();
        Toast.makeText(this,seeMessage,Toast.LENGTH_LONG).show();

    }
    private String convertir() {
        String message = "No es un palindromo";
        if (this.word.equals(invest)) message = "Es un Palindromo";
        return message;
    }
}