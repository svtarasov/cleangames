package com.example.katerina.mapsex;

/**
 * Created by Katerina on 06.07.2015.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

public class GamesAdapter extends ArrayAdapter<Game> {
    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */


    public GamesAdapter(Context context, ArrayList<Game> games) {
        super(context, 0, games);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Game game = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_game, parent, false);
        }
        // Lookup view for data population
        TextView gameName = (TextView) convertView.findViewById(R.id.gameName);
        TextView gameId = (TextView) convertView.findViewById(R.id.gameId);
        // Populate the data into the template view using the data object
        gameName.setText(game.name);
        gameId.setText(game.id);
        // Return the completed view to render on screen
        return convertView;
    }

}

