package com.example.katerina.mapsex.Registration;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.katerina.mapsex.Game.GamesActivity;
import com.example.katerina.mapsex.R;
import com.example.katerina.mapsex.datamodels.Team;
import com.example.katerina.mapsex.datamodels.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.ulogin.sdk.UloginAuthActivity;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

             }

        });
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }


    public void onClick(View view) {
        Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
        startActivity(intent);
    }

    //button JUMP
    public void onClick_demo(View view) {
        Intent intent = new Intent(LoginActivity.this, GamesActivity.class);
        UserProvider_temp provider = UserProvider_temp.Initialize(new User("1","Саша","Александров", new Team(),true));
        startActivity(intent);
    }



    public void authorize(View view) {
        runUlogin();
    }

    public final int REQUEST_ULOGIN = 1;

    public void runUlogin() {
        Intent intent = new Intent(getApplicationContext(),UloginAuthActivity.class);

        String[] providers		= new String[] {"vkontakte", "facebook" };
        String[] mandatory_fields	= new String[] {"first_name", "last_name" };
        String[] optional_fields	= new String[] {"nickname","photo"};

        intent.putExtra(
                UloginAuthActivity.PROVIDERS,
                new ArrayList(Arrays.asList(providers))
        );
        intent.putExtra(
                UloginAuthActivity.FIELDS,
                new ArrayList(Arrays.asList(mandatory_fields))
        );
        intent.putExtra(
                UloginAuthActivity.OPTIONAL,
                new ArrayList(Arrays.asList(optional_fields))
        );

        startActivityForResult(intent, REQUEST_ULOGIN);
    }

}

