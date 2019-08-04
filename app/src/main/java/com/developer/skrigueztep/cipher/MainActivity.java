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
                    String cipherTxt = cesarCipher(text,ROT);
                    txtCiphered.setText(cipherTxt);
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
        la base del cifrado cesar utilizando el ROT estandar

        Reference: http://puntocomnoesunlenguaje.blogspot.com/2016/02/cifrado-cesar-java.html
    */
   /*

    a=n     n=a
    b=o     o=b
    c=p     p=c
    d=q     q=d
    e=r     r=e
    f=s     s=f
    g=t     t=g
    h=u     u=h
    i=v     v=i
    j=w     w=j
    k=x     x=k
    l=y     y=l
    m=y     z=m

   */

    private String cesarCipher(String text, int rot_index){

        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) + rot_index) > 'z') {
                cifrado.append((char) (text.charAt(i) + rot_index - 26));
            } else {
                cifrado.append((char) (text.charAt(i) + rot_index));
            }
        }

        return cifrado.toString();
    }
}
