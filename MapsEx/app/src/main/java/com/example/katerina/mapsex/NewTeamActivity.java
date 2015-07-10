package com.example.katerina.mapsex;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class NewTeamActivity extends ActionBarActivity {

    EditText NameOfTeam;
    TextView NoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_team);
        setTitle("New Team");
        NameOfTeam = (EditText) findViewById(R.id.NameOfTeam);
        NoName = (TextView) findViewById(R.id.NoName);
        findViewById(R.id.Create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NameOfTeam.getText().length() == 0) {
                    NoName.setText("Input the name of the team!");
                } else {
                    startActivity(new Intent(NewTeamActivity.this, TeamsActivity.class));
                }
            }
        });
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_team, menu);
        return true;
    }*/

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
