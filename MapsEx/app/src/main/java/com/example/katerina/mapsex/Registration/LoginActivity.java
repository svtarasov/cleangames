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
            VKScope.FRIENDS,
            VKScope.WALL,
            VKScope.PHOTOS,
            VKScope.NOHTTPS
    };

    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;

    private static String sTokenKey = "VK_ACCESS_TOKEN";
    private static String[] vkScope = new String[]{ "email" };

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


    public void onClick(View view) {
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
    public void onClick_demo(View view) {
        Intent intent = new Intent(LoginActivity.this, GamesActivity.class);
        UserProvider provider = UserProvider.Initialize(new User("1", "Саша", "Александров", new Team(), true));
        startActivity(intent);
    }

    //uLogin Authorziation
    public void uLoginAuth(View view) {
        runUlogin();
    }

    public final int REQUEST_ULOGIN = 1;

    public void runUlogin() {
        Intent intent = new Intent(getApplicationContext(), UloginAuthActivity.class);

        String[] providers = new String[]{"vkontakte", "facebook"};
        String[] mandatory_fields = new String[]{"first_name", "last_name", "email"};
        String[] optional_fields = new String[]{"nickname", "photo"};

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

 /*   //Getting uLogin data
    @SuppressWarnings("unchecked")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // requestCode должно сравниваться со значением константы,
        //   указанной при инициализации Intent
        if (requestCode == 1) {
            //получаем данные ответа:
            HashMap userdata =
                    (HashMap) intent.getSerializableExtra (UloginAuthActivity.USERDATA);

            switch (resultCode) {
                case RESULT_OK:
                    //если авторизация прошла успешно, то приветствуем пользователя
                    Toast.makeText(this,
                            "Hello, " + userdata.get("first_name") + " "
                                    + userdata.get("last_name") + "!",
                            Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    //если авторизация завершилась с ошибкой, то выводим причину
                    if(userdata.get("error").equals("canceled")) {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Error: "+userdata.get("error"),
                                Toast.LENGTH_SHORT).show();
                    }
            }
        }
    }
*/
    //Listener for VK SDK initialization
 /*   private VKSdkListener sdkListener = new VKSdkListener() {
        @Override
        public void onCaptchaError(VKError captchaError) {
            new VKCaptchaDialog(captchaError).show();
        }

        @Override
        public void onTokenExpired(VKAccessToken expiredToken) {
            VKSdk.authorize(vkScope);
        }

        @Override
        public void onAccessDenied(VKError authorizationError) {
            new AlertDialog.Builder(LoginActivity.this)
                    .setMessage(authorizationError.errorMessage)
                    .show();
            Log.e("VK", "access denied");
        }

        @Override
        public void onReceiveNewToken(VKAccessToken newToken) {
            newToken.saveTokenToSharedPreferences(LoginActivity.this, sTokenKey);
            Intent i = new Intent(LoginActivity.this, CleanGamesActivity.class);
            startActivity(i);
        }

        @Override
        public void onAcceptUserToken(VKAccessToken token) {
            Intent i = new Intent(LoginActivity.this, CleanGamesActivity.class);
            startActivity(i);
        }
    };*/

    //VK SDK Authorization
    public void authorize(View view) {
        VKSdk.login(this, sMyScope);

       /* VKSdk.authorize(vkScope, true, false);
        VKRequest nameRequest = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "id"));
        final Context context = this;

        nameRequest.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                Toast.makeText(context, "complete: " + response.responseString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(context, "error: " + error.errorMessage, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                Toast.makeText(context, "Attempt failed", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}

