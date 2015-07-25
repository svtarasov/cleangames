package com.example.katerina.mapsex.Team;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.katerina.mapsex.R;
import com.example.katerina.mapsex.Repository;


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
        final Context context = this;
        findViewById(R.id.Create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NameOfTeam.getText().length() == 0) {
                    NoName.setText("Input the name of the team!");
                } else {
                    NameOfTeam.setText(Repository.createNewTeam(NameOfTeam.getText().toString(), context,3));
                    //startActivity(new Intent(NewTeamActivity.this, TeamsActivity.class));
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
