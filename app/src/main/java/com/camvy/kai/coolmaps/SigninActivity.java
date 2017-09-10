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

                AuthCallback ac = new AuthCallback() {
                    @Override
                    public void completion(boolean success) {
                        if (success) {
                            Intent mapIntent = new Intent(getBaseContext(), MapsActivity.class);
                            startActivity(mapIntent);
                            finish();
                        }
                    }
                };

                LoginCred userCred = new LoginCred(txtEmail.getText().toString(), txtPassword.getText().toString());
                PoxyServer.login(userCred, ac);
            }
        });
        //DEBUG
//        Cred fakeCred = new Cred("sam@uncle.com", "12345678", "12345678");
//        PoxyServer.register(fakeCred, new AuthCallback() {
//            @Override
//            public void completion(boolean success) {
//                if (success){
//                    Toast.makeText(getBaseContext(), "Sign up Sucess! You can use the app", Toast.LENGTH_LONG).show();
//                    Intent parklistIntent = new Intent(getBaseContext(), ParkListActivity.class);
//                    startActivity(parklistIntent);
//                }else {
//                    //Display Why user cannot signup
//                    Toast.makeText(getBaseContext(), "Sign up failed, please try again", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        //DEBUG login
        LoginCred fakelogin = new LoginCred("sam@uncle.com", "12345678");
        PoxyServer.login(fakelogin, new AuthCallback() {
            @Override
            public void completion(boolean success) {
                if (success){
                    Toast.makeText(getBaseContext(), "You are logged in! You can use the app", Toast.LENGTH_LONG).show();
                    Intent parklistIntent = new Intent(getBaseContext(), ParkListActivity.class);
                    startActivity(parklistIntent);
                }else{
                    //Display Why user cannot signup
                    Toast.makeText(getBaseContext(), "Login failed, please try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
