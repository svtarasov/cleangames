package com.example.katerina.mapsex.Registration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.katerina.mapsex.DBAdapter;
import com.example.katerina.mapsex.Game.GamesActivity;
import com.example.katerina.mapsex.LocalBackUp;
import com.example.katerina.mapsex.R;
import com.example.katerina.mapsex.datamodels.Team;
import com.example.katerina.mapsex.datamodels.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.DoubleBuffer;

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

                UserProvider_temp provider = UserProvider_temp.Initialize(new User("1","Саша","Александров", new Team(),true));

                startActivity(intent);
            }
        });
        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CleanGamesActivity.this, LoginActivity.class);
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
