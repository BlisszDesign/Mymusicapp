package com.example.android.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    public String artist;
    public String song ="";
    public String length;
    private ImageView artistMenu;
    private ImageView artistCover;
    private TextView artistName;
    private TextView songTitle;
    private TextView trackLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_song);
        Bundle extras = getIntent().getExtras();
        Bundle songs = getIntent().getExtras();
        Bundle timer = getIntent().getExtras();
        artist = extras.getString("artist");
        song = songs.getString("song");
        length = timer.getString("trackLength");
        artistMenu = (ImageView) findViewById(R.id.artist_menu);
        artistCover = (ImageView) findViewById(R.id.artist_cover);
        artistName = (TextView) findViewById(R.id.artist_name);
        songTitle = (TextView) findViewById(R.id.song_title);
        trackLength = (TextView) findViewById(R.id.end_time);

        switch (artist) {
            case "Evanescence":
                artistCover.setImageResource(R.drawable.evanescence);
                break;
            case "Enrique Iglesias":
                artistCover.setImageResource(R.drawable.enrique);
                break;
            case "ABBA":
                artistCover.setImageResource(R.drawable.abba);
                break;
            case "Desmod":
                artistCover.setImageResource(R.drawable.desmod);
                break;
            case "Bryan Adams":
                artistCover.setImageResource(R.drawable.bryan);
                break;
        }
        artistName.setText(String.valueOf(artist));
        songTitle.setText(String.valueOf(song));
        trackLength.setText(String.valueOf(length));

        artistMenu.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs menu image is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the SongActivity
                Intent songsMenuIntent = new Intent(PlayActivity.this, MainActivity.class);
                startActivity(songsMenuIntent);
            }
        });
    }
}
