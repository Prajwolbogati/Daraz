package com.example.daraz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daraz.R;

import java.util.Random;

public class MsignupActivity extends AppCompatActivity {
    EditText etmnum, etsmscode;
    Button btnnext, btnsend;
    TextView tvLogin;
    int min = 1;
    int max = 100000;

    Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msignup);
        btnnext=findViewById(R.id.btnnext);
        etmnum=findViewById(R.id.etmnum);
        tvLogin = findViewById(R.id.tvLogin);
        etsmscode=findViewById(R.id.etsmscode);
        btnsend=findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etmnum.getText().toString()))
                {
                    etmnum.setError("Mandatory Field");
                    return;
                }
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(1000);
                            int I1 = r.nextInt(max - min + 1) + min;
                            etsmscode.setText(Integer.toString(I1));
                        }   catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etmnum.getText().toString()))
                {
                    etmnum.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(etsmscode.getText().toString())){
                    etsmscode.setError("Mandatory Field");
                    return;
                }
                Intent intent = new Intent(MsignupActivity.this, RegisterActivity.class);
                String No = etmnum.getText().toString();
                String sms = etsmscode.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("PhoneNo", No);
                bundle.putString("SMS", sms);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MsignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}