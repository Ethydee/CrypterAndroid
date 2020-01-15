package com.heybarnes.crypter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button copyBtn = (Button) findViewById(R.id.copyBtn);
        Button encodeBtn = (Button) findViewById(R.id.encodeBtn);
        Button decodeBtn = (Button) findViewById(R.id.decodeBtn);

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText outputEditText = (EditText) findViewById(R.id.outputEditText);
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Crpyter", outputEditText.getText().toString());
                clipboard.setPrimaryClip(clip);
            }
        });

        encodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputEditText = (EditText) findViewById(R.id.inputEditText);
                EditText outputEditText = (EditText) findViewById(R.id.outputEditText);

                String trane = inputEditText.getText().toString();
                StringBuilder code = new StringBuilder();
                for (int i = 0; i < trane.length(); i++) {
                    int p = i + 1;
                    char cy = trane.charAt(i);
                    code.append("#").append((int) cy * p);
                }
                outputEditText.setText(code);
            }
        });

        decodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputEditText = (EditText) findViewById(R.id.inputEditText);
                EditText outputEditText = (EditText) findViewById(R.id.outputEditText);
                String toDec = inputEditText.getText().toString();
                StringBuilder decoded = new StringBuilder();
                String[] toDecIter = toDec.split("#");
                for (int i = 1; i < toDecIter.length; i++) {
                    int rone = Integer.parseInt(toDecIter[i]) / i;
                    char ord = (char) rone;
                    decoded.append(ord);
                }
                outputEditText.setText(decoded);
            }
        });
    }
}
