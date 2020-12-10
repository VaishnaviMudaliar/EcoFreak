package com.example.ecofreak;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class trackonactivity extends AppCompatActivity {

    //Initialise the variables

    EditText et_source,et_destination;
    Button  display_track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign values to the variables
        et_source = findViewById(R.id.et_source);
        et_destination = findViewById(R.id.et_destination);
        display_track = findViewById(R.id.btn_track);

        display_track.setOnClickListener(v -> {
            //Get value from edit text
            String Source = et_source.getText().toString().trim();
            String Destination = et_destination.getText().toString().trim();

            //Check the condition

            if(Source.equals(" ") && Destination.equals(" ")){
                //When both the values entered are blank
                Toast.makeText(getApplicationContext(), "Enter both the locations",Toast.LENGTH_SHORT).show();
            }
            else{
                //When both the values are entered
                //Displaying the track
                DisplayTrack(Source,Destination);


            }
        });
    }

    private void DisplayTrack(String source, String destination) {
        // If the device does not have google maps installed then redirecting it to google playstore
        try {
            //When Google Maps is installed
            //Initialising the Uri
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+ source + "/" + destination);

            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);

            //Set Package
            intent.setPackage("com.google.android.apps.maps");

            //set flags

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //start activity
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            //When google maps is not installed
            //initialising the uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/detailes?id=com.google.android.apps.maps");

            //Initialising intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);

            //set flag

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            //Start Activity

            startActivity(intent);
        }
    }
}