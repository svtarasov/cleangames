package com.example.katerina.mapsex.Registration;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.katerina.mapsex.Game.GamesActivity;
import com.example.katerina.mapsex.R;
import com.datamodel.datamodels.Team;
import com.datamodel.datamodels.User;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKSdkListener;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.dialogs.VKCaptchaDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ru.ulogin.sdk.UloginAuthActivity;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private static final String[] sMyScope = new String[]{
            VKScope.NOHTTPS,
            "email"
    };

    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

            }

        });

        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        VKSdk.wakeUpSession(this, new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                switch (res) {
                    case LoggedOut:
                        showLogin();
                        break;
                    case LoggedIn:
                        showLogout();
                        break;
                    case Pending:
                        break;
                    case Unknown:
                        break;
                }
            }

            @Override
            public void onError(VKError error) {

            }
        });

    }
    private void showLogout() {

    }

    private void showLogin() {

    }

    public void rememberPassword(View view) {
        Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
        startActivity(intent);
    }

    protected void onResume() {
        super.onResume();
        if (VKSdk.isLoggedIn()) {
            showLogout();
        } else {
            showLogin();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VKCallback<VKAccessToken> callback = new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // User passed Authorization
                startTestActivity();
            }

            @Override
            public void onError(VKError error) {
                // User didn't pass Authorization
            }
        };

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, callback) ) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void startTestActivity() {
        startActivity(new Intent(this, GamesActivity.class));
    }

    //button JUMP
    public void jump(View view) {
        Intent intent = new Intent(LoginActivity.this, GamesActivity.class);
        UserProvider provider = UserProvider.Initialize(new User("1", "Саша", "Александров", new Team(), true));
        startActivity(intent);
    }

    //VK SDK Authorization
    public void vkAuthorize(View view) {
        VKSdk.login(this, sMyScope);
    }
}

