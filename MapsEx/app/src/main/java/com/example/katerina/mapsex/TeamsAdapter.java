package com.example.katerina.mapsex;

/**
 * Created by Katerina on 05.07.2015.
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

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

public class TeamsAdapter extends ArrayAdapter<String> {
    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;
    public ArrayList<String> itemsArrayList;

    public TeamsAdapter(Context context, int layoutResourceId, ArrayList<String> listOfItems) {
        super(context, layoutResourceId);
        mContext = context;
        mLayoutResourceId = layoutResourceId;
        this.itemsArrayList =listOfItems;
    }

    /**
     * Returns the view for a specific item on the list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final String currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        ListView item = (ListView) row.findViewById(R.id.listTeams);
        //item.setText(currentItem.toString());
        //item.se
        item.setEnabled(true);


        return row;
    }

}
