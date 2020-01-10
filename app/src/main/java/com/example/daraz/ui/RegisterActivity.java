package com.example.daraz.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daraz.R;
import com.example.daraz.ServerResponse.SignupResponse;
import com.example.daraz.Url.Url;
import com.example.daraz.api.UserApi;
import com.example.daraz.model.user;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText etName,etPassword, etEmail;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
       etName = findViewById(R.id.etName);
        btnSubmit=findViewById(R.id.btnSubmit);



        final Bundle bundle = getIntent().getExtras();





        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText().toString()))
                {
                    etName.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(etPassword.getText().toString())){
                    etPassword.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(etEmail.getText().toString())){
                    etEmail.setError("Mandatory Field");
                    return;
                }

                String PhoneNo = bundle.getString("PhoneNo");
                String SMS = bundle.getString("SMS");
                String Name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                user users = new user(Name, email, password,PhoneNo, SMS);

                UserApi usersAPI = Url.getInstance().create(UserApi.class);
                Call<SignupResponse> signUpCall = usersAPI.registerUser(users);

                signUpCall.enqueue(new Callback<SignupResponse>() {
                    @Override
                    public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SignupResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });            }
        });
    }
}



