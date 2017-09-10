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
import com.camvy.kai.coolmaps.Networking.Cred;
import com.camvy.kai.coolmaps.Networking.PoxyServer;

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
                AuthCallback ac = new AuthCallback() {
                    @Override
                    public void completion(boolean success) {
                        Log.d("TSTCMP", "TESTING COMPLETION");

                        if (success){
                            Intent mapIntent = new Intent(getBaseContext(), MapsActivity.class);
                            startActivity(mapIntent);
                            finish();
                        }
                        else{
                            //Error Message goes here.
                        }

                        //Success:
                        //09-10 14:29:15.958 11492-11492/com.camvy.kai.coolmaps D/Response Success: {}

                        //no form data
                        //Response: 09-10 14:05:17.537 3696-3696/? D/Response Err Code: {"rawResponse":{"body":{"contentLength":27},"code":502,"handshake":{"cipherSuite":{"javaName":"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"},"localCertificates":[],"peerCertificates":[{"type":"X.509"},{"type":"X.509"},{"type":"X.509"}],"tlsVersion":"TLS_1_2"},"headers":{"namesAndValues":["server","nginx/1.10.1","date","Sun, 10 Sep 2017 21:05:16 GMT","content-length","27"]},"message":"","networkResponse":{"code":502,"handshake":{"cipherSuite":{"javaName":"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"},"localCertificates":[],"peerCertificates":[{"type":"X.509"},{"type":"X.509"},{"type":"X.509"}],"tlsVersion":"TLS_1_2"},"headers":{"namesAndValues":["server","nginx/1.10.1","date","Sun, 10 Sep 2017 21:05:16 GMT","content-length","27"]},"message":"","protocol":"HTTP_2","receivedResponseAtMillis":1505077517466,"request":{"cacheControl":{"immutable":false,"isPrivate":false,"isPublic":false,"maxAgeSeconds":-1,"maxStaleSeconds":-1,"minFreshSeconds":-1,"mustRevalidate":false,"noCache":false,"noStore":false,"noTransform":false,"onlyIfCached":false,"sMaxAgeSeconds":-1},"headers":{"namesAndValues":["Accept","application/json","Content-Type","application/json; charset\u003dUTF-8","Content-Length","53","Host","poxy.localtunnel.me","Connection","Keep-Alive","Accept-Encoding","gzip","User-Agent","okhttp/3.8.0"]},"method":"POST","tag":{"headers":{"namesAndValues":["Accept","application/json"]},"method":"POST","url":{"host":"poxy.localtunnel.me","password":"","pathSegments":["users"],"port":443,"scheme":"https","url":"https://poxy.localtunnel.me/users","username":""}},"url":{"host":"poxy.localtunnel.me","password":"","pathSegments":["users"],"port":443,"scheme":"https","url":"https://poxy.localtunnel.me/users","username":""}},"sentRequestAtMillis":1505077517334},"protocol":"HTTP_2","receivedResponseAtMillis":1505077517466,"request":{"headers":{"namesAndValues":["Accept","application/json"]},"method":"POST","url":{"host":"poxy.localtunnel.me","password":"","pathSegments":["users"],"port":443,"scheme":"https","url":"https://poxy.localtunnel.me/users","username":""}},"sentRequestAtMillis":1505077517334}}

                        //with example usr and password
                        //09-10 14:05:57.628 3696-3696/? D/Response Err Code: {"rawResponse":{"body":{"contentLength":27},"code":502,"handshake":{"cipherSuite":{"javaName":"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"},"localCertificates":[],"peerCertificates":[{"type":"X.509"},{"type":"X.509"},{"type":"X.509"}],"tlsVersion":"TLS_1_2"},"headers":{"namesAndValues":["server","nginx/1.10.1","date","Sun, 10 Sep 2017 21:05:57 GMT","content-length","27"]},"message":"","networkResponse":{"code":502,"handshake":{"cipherSuite":{"javaName":"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"},"localCertificates":[],"peerCertificates":[{"type":"X.509"},{"type":"X.509"},{"type":"X.509"}],"tlsVersion":"TLS_1_2"},"headers":{"namesAndValues":["server","nginx/1.10.1","date","Sun, 10 Sep 2017 21:05:57 GMT","content-length","27"]},"message":"","protocol":"HTTP_2","receivedResponseAtMillis":1505077557524,"request":{"cacheControl":{"immutable":false,"isPrivate":false,"isPublic":false,"maxAgeSeconds":-1,"maxStaleSeconds":-1,"minFreshSeconds":-1,"mustRevalidate":false,"noCache":false,"noStore":false,"noTransform":false,"onlyIfCached":false,"sMaxAgeSeconds":-1},"headers":{"namesAndValues":["Accept","application/json","Content-Type","application/json; charset\u003dUTF-8","Content-Length","88","Host","poxy.localtunnel.me","Connection","Keep-Alive","Accept-Encoding","gzip","User-Agent","okhttp/3.8.0"]},"method":"POST","tag":{"headers":{"namesAndValues":["Accept","application/json"]},"method":"POST","url":{"host":"poxy.localtunnel.me","password":"","pathSegments":["users"],"port":443,"scheme":"https","url":"https://poxy.localtunnel.me/users","username":""}},"url":{"host":"poxy.localtunnel.me","password":"","pathSegments":["users"],"port":443,"scheme":"https","url":"https://poxy.localtunnel.me/users","username":""}},"sentRequestAtMillis":1505077557381},"protocol":"HTTP_2","receivedResponseAtMillis":1505077557524,"request":{"headers":{"namesAndValues":["Accept","application/json"]},"method":"POST","url":{"host":"poxy.localtunnel.me","password":"","pathSegments":["users"],"port":443,"scheme":"https","url":"https://poxy.localtunnel.me/users","username":""}},"sentRequestAtMillis":1505077557381}}
                    }
                };
                userCred = new Cred(txtEmail.getText().toString(), txtPassword.getText().toString(), txtPasswordConfirm.getText().toString());
                PoxyServer.register(userCred, ac);
                Log.d("TSTCMP", "TESTING BTN PRESS");
            }
        });
    }
}
