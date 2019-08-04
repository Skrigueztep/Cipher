package com.developer.skrigueztep.cipher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtToCipher;
    Button cipherBtn;
    TextView txtCiphered;

    String TAG = "MainActivity: ";

    char[] alphabet = {
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'
    };

    int ROT = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtToCipher = (EditText) findViewById(R.id.textToCipher);
        cipherBtn = (Button) findViewById(R.id.cipherBtn);
        txtCiphered = (TextView) findViewById(R.id.textCiphered);

        cipherBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String text = txtToCipher.getText().toString().toLowerCase();

                if(text.isEmpty()){
                    showMessage(TAG, "Text field is empty");
                }else{
                    // String cipherTxt = cipher(text,ROT);
                    txtCiphered.setText("Texto cifrado");
                    txtToCipher.setText("");
                    showMessage(TAG, "Text chipered");
                }
            }
        });

    }

    private void showMessage(String TAG, String message){
        Toast.makeText(this,TAG + message,Toast.LENGTH_SHORT).show();
    }

    /*
        Este metodo debe devolver una nueva cadena con el texto cifrado aplicando
        la base el cifrado cesar utilizando el ROT estandar
    */

    private String cipher(String text, int rot_index){
        for(int i = 0; i < text.length(); i++){     // Recorre el string
            char letra = text.charAt(i);            // Encapsula la letra dada por el indice
            for(int index = 0; index < alphabet.length; ){   // Recorre el char[]
                if(letra == alphabet[index]){   //  Verifica que la letra coincida con el elemento dado por el indice en el alfabeto
                    // Si son iguales suma el indice mas el rot y obtiene el elemento en la posicion
                    // Y si es mayor el nuevo indice a 26 se resta (nuevo_index - 26 = resultado) en donde
                    // El resultado va a ser el nuevo indice y se obtiene el elemento de ese nuevo indice
                }else{
                    // Si no son iguales se sigue recorriendo hasta que lo sea
                    index++;
                }
            }
        }

        // Regresa un String con el texto generado por los indices
    }
}
