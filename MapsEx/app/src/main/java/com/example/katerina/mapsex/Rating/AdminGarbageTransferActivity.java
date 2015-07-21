package com.example.katerina.mapsex.Rating;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.katerina.mapsex.R;

/**
 * Created by 1 on 15.07.2015.
 */
public class AdminGarbageTransferActivity extends Activity{
    TextView command_name;
    TextView  command_score;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_transfer);
        command_name=(TextView) findViewById(R.id.command_name);
        command_score=(TextView) findViewById(R.id.command_score);
        Bundle extras = getIntent().getExtras();
        String name; int score;
        if (extras == null) {
            name = null;
            score= 0;
        } else {
            name = extras.getString("name");
            score =  extras.getInt("score");

        }

        command_score.append(""+score);
        command_name.append(name);

        final Button button1 = (Button) findViewById(R.id.button_submit);
        final EditText garbage1=(EditText)findViewById(R.id.garbage1);
        final EditText garbage2=(EditText)findViewById(R.id.garbage2);
        final EditText garbage3=(EditText)findViewById(R.id.garbage3);
        final EditText garbage4=(EditText)findViewById(R.id.garbage4);
        final EditText garbage5=(EditText)findViewById(R.id.garbage5);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {










            }


        });

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage1.getText().toString());
                if (temp>0){
                    temp--;
                    garbage1.getText().clear();
                    garbage1.getText().append(temp.toString());}
            }

        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage1.getText().toString());
                temp++;
                garbage1.getText().clear();
                garbage1.getText().append(temp.toString());
            }

        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage2.getText().toString());
                if (temp>0){
                    temp--;
                    garbage2.getText().clear();
                    garbage2.getText().append(temp.toString());}
            }

        });

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage2.getText().toString());
                temp++;
                garbage2.getText().clear();
                garbage2.getText().append(temp.toString());
            }

        });

        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage3.getText().toString());
                if (temp>0){
                    temp--;
                    garbage3.getText().clear();
                    garbage3.getText().append(temp.toString());}
            }

        });

        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage3.getText().toString());
                temp++;
                garbage3.getText().clear();
                garbage3.getText().append(temp.toString());
            }

        });

        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage4.getText().toString());
                if (temp>0){
                    temp--;
                    garbage4.getText().clear();
                    garbage4.getText().append(temp.toString());}
            }

        });

        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage4.getText().toString());
                temp++;
                garbage4.getText().clear();
                garbage4.getText().append(temp.toString());
            }

        });

        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage5.getText().toString());
                if (temp>0){
                    temp--;
                    garbage5.getText().clear();
                    garbage5.getText().append(temp.toString());}
            }

        });

        final Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer temp= Integer.parseInt(garbage5.getText().toString());
                temp++;
                garbage5.getText().clear();
                garbage5.getText().append(temp.toString());
            }

        });
    }

}
