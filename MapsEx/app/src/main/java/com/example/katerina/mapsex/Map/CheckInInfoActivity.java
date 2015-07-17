package com.example.katerina.mapsex.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.katerina.mapsex.datamodels.CheckIn;
import com.example.katerina.mapsex.datamodels.Param;
import com.google.android.gms.maps.model.LatLng;
import com.example.katerina.mapsex.*;

import java.util.ArrayList;

import com.example.katerina.mapsex.R;



public class CheckInInfoActivity extends Activity{
    String a, b;
    EditText commentText;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        commentText = (EditText) findViewById(R.id.EditText01);


        final Button button1 = (Button) findViewById(R.id.button_submit);
        final EditText garbage1=(EditText)findViewById(R.id.garbage1);
        final EditText garbage2=(EditText)findViewById(R.id.garbage2);
        final EditText garbage3=(EditText)findViewById(R.id.garbage3);
        final EditText garbage4=(EditText)findViewById(R.id.garbage4);
        final EditText garbage5=(EditText)findViewById(R.id.garbage5);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    LocationProvider locationProvider=LocationProvider.Initialize();
                    LatLng location=locationProvider.getLocataion();
                    ArrayList<Param> garbage=new ArrayList<Param>();
                    garbage.add(new Param("Пластик",Integer.parseInt(garbage1.getText().toString())));
                    garbage.add(new Param("Металл",Integer.parseInt(garbage2.getText().toString())));
                    garbage.add(new Param("Стекло",Integer.parseInt(garbage3.getText().toString())));
                    garbage.add(new Param("Смешанный мусор",Integer.parseInt(garbage1.getText().toString())));
                    garbage.add(new Param("Батарейки",Integer.parseInt(garbage1.getText().toString())));
                    CheckIn checkIn=new CheckIn(commentText.getText().toString(),garbage,location);
                    locationProvider.setCheckin(checkIn);


                 /*  a = commentText.getText().toString()+" ";
                    b= getResources().getString(R.string.garbage1)+": "+garbage1.getText().toString()+"\n"+getResources().getString(R.string.garbage2)+": "+garbage2.getText()+"\n"+getResources().getString(R.string.garbage3)+": "+garbage3.getText()+"\n"+getResources().getString(R.string.garbage4)+": "+garbage4.getText()+"\n"+getResources().getString(R.string.garbage5)+": "+garbage5.getText();
                    */
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("comment",a);
                    returnIntent.putExtra("garbage",b);
                    setResult(RESULT_OK,returnIntent);
                    finish();







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

        final Button photo = (Button) findViewById(R.id.TakeAPhoto);
        photo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               dispatchTakePictureIntent();
            }

        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }

}

