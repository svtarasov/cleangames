package com.example.katerina.mapsex.Registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.katerina.mapsex.R;


public class RegisterActivity extends Activity {

    private Button btnRegister;
    private Button btnLinkToLogin;
    private EditText inputFirstName;
    private EditText inputLastName;
    private EditText inputEmail;
    private EditText inputPassword;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        inputFirstName = (EditText) findViewById(R.id.firstName);
        inputLastName = (EditText) findViewById(R.id.lastName);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view) {
                String firstName = inputFirstName.getText().toString();
                String lastName = inputLastName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
            }
        });

        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

