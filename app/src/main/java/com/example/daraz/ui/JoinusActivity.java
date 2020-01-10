package com.example.daraz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.daraz.R;

public class JoinusActivity extends AppCompatActivity {
    Button btnlogin,btncreateaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinus);

        btnlogin=findViewById(R.id.btnlogin);
        btncreateaccount=findViewById(R.id.btncreateaccount);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(JoinusActivity.this, LoginActivity.class));
            }
        });

        btncreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinusActivity.this, MsignupActivity.class));
            }
        });
    }
}
