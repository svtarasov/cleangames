package com.example.katerina.mapsex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;


public class GamesActivity extends ActionBarActivity {
    private ProgressDialog pDialog;

    JSONParser jParser = new JSONParser();//(пока нет парсера)

    ArrayList<HashMap<String, String>> gamesList;

    private static final String url_all_games = "";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_GAMES = "games";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";

    JSONArray games = null;
    public GamesAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        setTitle("Games");

        ListView listViewGames = (ListView) findViewById(R.id.listGames);

        // listViewTeams.getSelectedItem()
        ArrayList<Game> exampleList = new ArrayList<Game>();
        exampleList.add(new Game("1", "Clean Peterhof1"));
        exampleList.add(new Game("2", "Clean Peterhof2"));
        exampleList.add(new Game("3", "nothing"));
        mAdapter = new GamesAdapter(this,exampleList);
        listViewGames.setAdapter(mAdapter);
        listViewGames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GamesActivity.this, TeamsActivity.class);
                Game game = (Game) parent.getItemAtPosition(position);

                intent.putExtra("Name", game.name);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_games, menu);
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
    class LoadAllGames extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(GamesActivity.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            JSONObject json = jParser.makeHttpRequest(url_all_games, "GET", params);

            Log.d("All Games: ", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    games = json.getJSONArray(TAG_GAMES);

                    for (int i = 0; i < games.length(); i++) {
                        JSONObject c = games.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);

                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_ID, id);
                        map.put(TAG_NAME, name);

                        gamesList.add(map);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all games
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter = new SimpleAdapter(
                            GamesActivity.this, gamesList,
                            R.layout.row_game, new String[]{TAG_ID,
                            TAG_NAME},
                            new int[]{R.id.gameId, R.id.gameName});
                    // updating listview
                    setListAdapter(adapter);
                }
            });
        }
    }
}
