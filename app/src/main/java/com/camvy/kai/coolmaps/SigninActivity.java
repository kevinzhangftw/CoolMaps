package com.camvy.kai.coolmaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.camvy.kai.coolmaps.Networking.AuthCallback;
import com.camvy.kai.coolmaps.Networking.Cred;
import com.camvy.kai.coolmaps.Networking.LoginCred;
import com.camvy.kai.coolmaps.Networking.PoxyServer;

public class SigninActivity extends AppCompatActivity {

    private Button registerButton;
    private Button signInButton;
    private EditText txtEmail;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        connectFormElements();
    }

    private void connectFormElements(){
        txtEmail = (EditText)findViewById(R.id.etEmail);
        txtPassword = (EditText)findViewById(R.id.etPassword);

        registerButton = (Button)findViewById(R.id.btnRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        signInButton = (Button)findViewById(R.id.btnSignIn);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    private void signIn(){
        AuthCallback ac = new AuthCallback() {
            @Override
            public void completion(boolean success) {
                if (success) {
                    Intent mapIntent = new Intent(getBaseContext(), MapsActivity.class);
                    startActivity(mapIntent);
                    finish();
                }
                else{
                    Toast.makeText(getBaseContext(), "Login failed, please try again", Toast.LENGTH_LONG).show();
                }
            }
        };

        LoginCred userCred = new LoginCred(txtEmail.getText().toString(), txtPassword.getText().toString());
        PoxyServer.login(userCred, ac);
    }
}
