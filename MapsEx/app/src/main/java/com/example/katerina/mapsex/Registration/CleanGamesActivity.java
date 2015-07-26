package com.example.katerina.mapsex.Registration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.katerina.mapsex.DBAdapter;
import com.example.katerina.mapsex.Game.GamesActivity;
import com.example.katerina.mapsex.LocalBackUp;
import com.example.katerina.mapsex.R;
import com.datamodel.datamodels.Team;
import com.datamodel.datamodels.User;
import com.vk.sdk.VKSdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CleanGamesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_clean_games);
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
                */
            }
        });

    }
}
