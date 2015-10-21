package com.example.katerina.mapsex.Rating;

/**
 * Created by Katerina on 13.07.2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.katerina.mapsex.R;
import com.datamodel.datamodels.Team;

import java.util.ArrayList;

public class RatingAdapter extends ArrayAdapter<Team> {
    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */


    public RatingAdapter(Context context, ArrayList<Team> ratings) {
        super(context, 0, ratings);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Team team = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_rating, parent, false);
        }
        // Lookup view for data population
        TextView teamName = (TextView) convertView.findViewById(R.id.teamNameRate);
        TextView teamId = (TextView) convertView.findViewById(R.id.teamIdRate);
        TextView teamRating = (TextView) convertView.findViewById(R.id.teamRating);
        // Populate the data into the template view using the data object
        teamName.setText(team.name);
        teamId.setText(team.id);
        teamRating.setText(Integer.toString(team.total_scores));
        // Return the completed view to render on screen
        return convertView;
    }

}
