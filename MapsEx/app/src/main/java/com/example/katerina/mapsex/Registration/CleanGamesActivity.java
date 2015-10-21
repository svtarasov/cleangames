package com.example.katerina.mapsex.Registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.katerina.mapsex.DBAdapter;
import com.example.katerina.mapsex.Game.GamesActivity;
import com.example.katerina.mapsex.LocalBackUp;
import com.example.katerina.mapsex.R;
import com.datamodel.datamodels.Team;
import com.datamodel.datamodels.User;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CleanGamesActivity extends FragmentActivity {
    final DBAdapter db = new DBAdapter(this);
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] fingerprint = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        Log.e("Fingerprint", fingerprint[0]);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
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
       /* super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_games_login);
        Button jump = (Button)findViewById(R.id.button_jump);
        Button auth = (Button)findViewById(R.id.button_auth);

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CleanGamesActivity.this, GamesActivity.class);

                UserProvider provider = UserProvider.Initialize(new User("1","Саша","Александров", new Team(),true));

                startActivity(intent);
            }
        });
        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (VKSdk.isLoggedIn()) {
                     intent = new Intent(CleanGamesActivity.this, GamesActivity.class);
                } else {
                     intent = new Intent(CleanGamesActivity.this, LoginActivity.class);
                }


                startActivity(intent);
            }
        });

        //---Work with SQLite DB
        try {
            String destPath = "/data/data/" + getPackageName() + "/databases/CleanGamesDB";
            File f = new File(destPath);
            if (!f.exists()) {
                LocalBackUp.CopyDB(getBaseContext().getAssets().open("mydb"), new FileOutputStream(destPath));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        final DBAdapter db = new DBAdapter(this);
        final Context context = this;

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalBackUp.add_Assignments(db,32, "gfhfjg333");
                LocalBackUp.get_all_records(db, context);
                /*
                Intent intent = new Intent(CleanGamesActivity.this, GamesActivity.class);
                UserProvider_temp provider = UserProvider_temp.Initialize(new User("1","Иван","Иванов", new Team(),true));
                startActivity(intent);

            }
        });

    }*/

    private void showLogout() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LogoutFragment())
                .commit();
    }

    private void showLogin() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LoginFragment())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (VKSdk.isLoggedIn()) {
            showLogout();
        } else {
            showLogin();
        }

    }
    public static class LoginFragment extends android.support.v4.app.Fragment {


        public LoginFragment() {
            super();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_clean_games_login, container, false);
            v.findViewById(R.id.button_auth).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent;
                    intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);

                }
            });
            Button jump = (Button)v.findViewById(R.id.button_jump);
            jump.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), GamesActivity.class);

                    UserProvider provider = UserProvider.Initialize(new User("1","Саша","Александров", new Team(),true));

                    startActivity(intent);
                /*
                Intent intent = new Intent(CleanGamesActivity.this, GamesActivity.class);
                UserProvider_temp provider = UserProvider_temp.Initialize(new User("1","Иван","Иванов", new Team(),true));
                startActivity(intent);
                */
                }
            });


            return v;
        }

    }

    public static class LogoutFragment extends android.support.v4.app.Fragment {
        public LogoutFragment() {
            super();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_clean_games_logout, container, false);
            Button jump = (Button)v.findViewById(R.id.button_jump);
            jump.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), GamesActivity.class);

                    UserProvider provider = UserProvider.Initialize(new User("1","Саша","Александров", new Team(),true));

                    startActivity(intent);    }
            });

            v.findViewById(R.id.button_logout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VKSdk.logout();
                    if (!VKSdk.isLoggedIn()) {
                        ((CleanGamesActivity) getActivity()).showLogin();
                    }
                }
            });
            return v;
        }
    }
}

