package com.example.katerina.mapsex;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.example.katerina.mapsex.datamodels.Team;
import com.example.katerina.mapsex.datamodels.User;

import java.util.ArrayList;


public class CertainTeamActivity extends ActionBarActivity {
    public CertainTeamAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certain_team);
        Bundle extras = getIntent().getExtras();
        String str ;
        if(extras == null) {
            str= null;
        } else {
            str= extras.getString("Name");
        }
        setTitle(str);
        findViewById(R.id.Join).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CertainTeamActivity.this, DemoActivity.class));
            }
        });
        final ListView listViewUsers = (ListView) findViewById(R.id.listUsers);
        ArrayList<User> exampleList = Repository.getUsers(new Team());
        mAdapter = new CertainTeamAdapter(this,exampleList);
        listViewUsers.setAdapter(mAdapter);
        findViewById(R.id.button_popup)
                //Следим за нажатиями по кнопке:
                .setOnClickListener(new View.OnClickListener() {

                    //Обрабатываем нажатие кнопки Button:
                    @Override
                    public void onClick(View view) {
                        //Вызываем popup меню, заполняем его с файла popup.xml и настраиваем
                        //слушатель нажатий по пунктам OnMenuItemClickListener:
                        PopupMenu popup_menu = new PopupMenu(CertainTeamActivity.this, view);
                        popup_menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.game_menu:
                                        //Toast.makeText(this, "Выбран пункт 1", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(CertainTeamActivity.this, GamesActivity.class));
                                        return true;
                                    case R.id.teams_menu:
                                        //Toast.makeText(this, "Выбран пункт 2", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(CertainTeamActivity.this, TeamsActivity.class));
                                        return true;
                                    case R.id.map_menu:
                                        //Toast.makeText(this, "Выбран пункт 3", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(CertainTeamActivity.this, DemoActivity.class));
                                        return true;
                                    case R.id.rating_menu:
                                        startActivity(new Intent(CertainTeamActivity.this, RatingActivity.class));
                                        return true;
                                }
                                return true;
                            }
                        });
                        popup_menu.inflate(R.menu.popup_menu);
                        popup_menu.show();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_certain_team, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
