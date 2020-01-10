package com.example.daraz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daraz.MainActivity;
import com.example.daraz.R;
import com.example.daraz.bll.LoginBll;
import com.example.daraz.strictmode.Strictmodeclass;

public class LoginActivity extends AppCompatActivity {
    Button btnexit,btnLogin;
    EditText etmoboremail,etPassword;
    TextView tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnexit=findViewById(R.id.btnexit);
        btnLogin=findViewById(R.id.btnLogin);
        etmoboremail=findViewById(R.id.etmoboremail);
        etPassword=findViewById(R.id.etPassword);
        tvCreateAccount=findViewById(R.id.tvCreateAccount);

        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = etmoboremail.getText().toString();
        String password = etPassword.getText().toString();

        LoginBll loginBLL = new LoginBll();

        Strictmodeclass.Strictmode();
        if (loginBLL.checkUser(username, password)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            etmoboremail.requestFocus();
        }
    }
}
