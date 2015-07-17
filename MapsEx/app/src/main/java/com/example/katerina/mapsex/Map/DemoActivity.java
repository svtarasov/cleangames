package com.example.katerina.mapsex.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.katerina.mapsex.Map.MapFragment;
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

    public  void reload_Click(View view){
        startActivity(new Intent(DemoActivity.this, DemoActivity.class));
    }
}
