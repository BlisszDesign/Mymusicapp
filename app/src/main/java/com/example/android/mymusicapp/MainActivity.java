package com.example.android.mymusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    public String artist;
    private ImageView evanescence, enrique, abba, desmod, bryan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        evanescence = (ImageView) findViewById(R.id.evanescence_cover);
        enrique = (ImageView) findViewById(R.id.enrique_cover);
        abba = (ImageView) findViewById(R.id.abba_cover);
        desmod = (ImageView) findViewById(R.id.desmod_cover);
        bryan = (ImageView) findViewById(R.id.bryan_cover);


        //set a click listener for artists
        evanescence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent evanescenceIntent = new Intent(MainActivity.this, SongActivity.class);
                artist = "Evanescence";
                evanescenceIntent.putExtra("artist", artist);
                startActivity(evanescenceIntent);
            }
        });
        enrique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enriqueIntent = new Intent(MainActivity.this, SongActivity.class);
                artist = "Enrique Iglesias";
                enriqueIntent.putExtra("artist", artist);
                startActivity(enriqueIntent);
            }
        });
        abba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abbaIntent = new Intent(MainActivity.this, SongActivity.class);
                artist = "ABBA";
                abbaIntent.putExtra("artist", artist);
                startActivity(abbaIntent);
            }
        });
        desmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent desmodIntent = new Intent(MainActivity.this, SongActivity.class);
                artist = "Desmod";
                desmodIntent.putExtra("artist", artist);
                startActivity(desmodIntent);
            }
        });
        bryan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bryanIntent = new Intent(MainActivity.this, SongActivity.class);
                artist = "Bryan Adams";
                bryanIntent.putExtra("artist", artist);
                startActivity(bryanIntent);
            }
        });

    }

}

