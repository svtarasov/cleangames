package com.example.katerina.mapsex;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import com.example.katerina.mapsex.R;

public class DemoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);


        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container_map_fragment, new MapFragment())
                    .commit();
        }
    }
}
