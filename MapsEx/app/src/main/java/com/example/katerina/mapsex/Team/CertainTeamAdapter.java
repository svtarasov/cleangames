package com.example.katerina.mapsex.Team;

/**
 * Created by Katerina on 06.07.2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.katerina.mapsex.R;
import com.datamodel.datamodels.User;

import java.util.ArrayList;

public class CertainTeamAdapter extends ArrayAdapter<User> {
    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */


    public CertainTeamAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_user, parent, false);
        }
        // Lookup view for data population
        TextView userName = (TextView) convertView.findViewById(R.id.userName);
        TextView userId = (TextView) convertView.findViewById(R.id.userId);
        // Populate the data into the template view using the data object
        userName.setText(user.name);
        userId.setText(user.id);
        // Return the completed view to render on screen
        return convertView;
    }

}
