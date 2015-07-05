package com.example.katerina.mapsex;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class TeamsActivity extends ActionBarActivity {

    public TeamsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);


        final ListView listViewTeams = (ListView) findViewById(R.id.listTeams);
       // listViewTeams.getSelectedItem()
        ArrayList<String> exampleList = new ArrayList<String>();
        exampleList.add("something");
        exampleList.add("anything");
        exampleList.add("nothing");
        mAdapter = new TeamsAdapter(this, R.layout.activity_teams, exampleList);
        listViewTeams.setAdapter(mAdapter);
        listViewTeams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TeamsActivity.this, CertainTeamActivity.class);
                String teamName = (String) parent.getItemAtPosition(position);

                intent.putExtra("Name", teamName);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teams, menu);
        return true;
    }

/*    public void button2OnClick(View view){
        Intent intent1 = new Intent(TeamsActivity.this, MapsActivity.class);
        startActivity(intent1);
    }
    */

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
