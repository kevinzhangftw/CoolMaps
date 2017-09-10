package com.camvy.kai.coolmaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.camvy.kai.coolmaps.Networking.AuthCallback;
import com.camvy.kai.coolmaps.Networking.Badge;
import com.camvy.kai.coolmaps.Networking.BadgeCallback;
import com.camvy.kai.coolmaps.Networking.Cred;
import com.camvy.kai.coolmaps.Networking.PoxyServer;
import com.camvy.kai.coolmaps.Networking.UserState;

/**
 * Created by Jonathan on 9/3/2017.
 */




public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtPasswordConfirm;
    private Cred userCred;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        connectFormElements();
    }

    private void connectFormElements(){
        txtEmail = (EditText)findViewById(R.id.etEmail);
        txtPassword = (EditText)findViewById(R.id.etPassword);
        txtPasswordConfirm = (EditText)findViewById(R.id.etPasswordConfirm);

        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register(){

        BadgeCallback ac = new BadgeCallback() {
            @Override
            public void completion(boolean success, Badge badge) {

                if (success){
                    UserState.setBadge(badge, getApplicationContext());
                    Intent mapIntent = new Intent(getBaseContext(), MapsActivity.class);
                    startActivity(mapIntent);
                    finish();
                }
                else{
                    Toast.makeText(getBaseContext(), "Registration failed, please try again", Toast.LENGTH_LONG).show();
                }
            }
        };
        userCred = new Cred(txtEmail.getText().toString(), txtPassword.getText().toString(), txtPasswordConfirm.getText().toString());
        PoxyServer.register(userCred, ac);
    }
}
