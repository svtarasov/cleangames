package com.example.katerina.mapsex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TeamsActivity extends ActionBarActivity {

    public TeamsAdapter mAdapter;
    private ProgressDialog pDialog;

    JSONParser jParser = new JSONParser();

    JSONArray teams = null;

    ArrayList<HashMap<String, String>> teamsList;

    private static final String url_all_teams = "";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_TEAMS = "teams";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        Bundle extras = getIntent().getExtras();
        String str ;
        if(extras == null) {
            str= null;
        } else {
            str= extras.getString("Name");
        }
        setTitle("Teams in game : " + str);

        final ListView listViewTeams = (ListView) findViewById(R.id.listTeams);
       // listViewTeams.getSelectedItem()
        ArrayList<Team> exampleList = new ArrayList<Team>();
        exampleList.add(new Team("1", "something"));
        exampleList.add(new Team("2", "anything"));
        exampleList.add(new Team("3", "nothing"));
        mAdapter = new TeamsAdapter(this,exampleList);
        listViewTeams.setAdapter(mAdapter);
        listViewTeams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TeamsActivity.this, CertainTeamActivity.class);
                Team team = (Team) parent.getItemAtPosition(position);

                intent.putExtra("Name", team.name);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonCreateTeam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeamsActivity.this, NewTeamActivity.class));
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

    class LoadAllTeams extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(TeamsActivity.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            JSONObject json = jParser.makeHttpRequest(url_all_teams, "GET", params);//(пока нет парсера)

            Log.d("All Teams: ", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    teams = json.getJSONArray(TAG_TEAMS);

                    for (int i = 0; i < teams.length(); i++) {
                        JSONObject c = teams.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);

                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_ID, id);
                        map.put(TAG_NAME, name);

                        teamsList.add(map);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter = new SimpleAdapter(
                            TeamsActivity.this, teamsList,
                            R.layout.row_game, new String[] { TAG_ID,
                            TAG_NAME},
                            new int[] { R.id.gameId, R.id.gameName });
                    // updating listview
                    setListAdapter(adapter);
                }
            });
        }
    }
}
