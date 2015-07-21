package com.example.katerina.mapsex.Registration;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.katerina.mapsex.Game.GamesActivity;
import com.example.katerina.mapsex.R;
import com.example.katerina.mapsex.datamodels.Team;
import com.example.katerina.mapsex.datamodels.User;

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
    }
}
