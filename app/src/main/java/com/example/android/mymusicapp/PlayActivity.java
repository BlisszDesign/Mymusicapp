package com.example.android.mymusicapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    @Nullable
    public String artist;
    @Nullable
    public String song;
    @Nullable
    public String length;
    private ImageView artistMenu;
    private ImageView songMenu;
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
        song = songs.getString("songName");
        length = timer.getString("trackLength");
        artistMenu = (ImageView) findViewById(R.id.artist_menu);
        artistCover = (ImageView) findViewById(R.id.artist_cover);
        artistName = (TextView) findViewById(R.id.artist_name);
        songTitle = (TextView) findViewById(R.id.song_title);
        trackLength = (TextView) findViewById(R.id.end_time);
        songMenu = (ImageView) findViewById(R.id.songs_menu);

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
        if (song != null) {
            String getName = (String) songs.get("song");
            songTitle.setText(getName);
        }
        artistName.setText(String.valueOf(artist));
        songTitle.setText(String.valueOf(song));
        trackLength.setText(String.valueOf(length));

        final ImageView playOrPause = (ImageView) findViewById(R.id.play);
        playOrPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = playOrPause.getDrawable();
                if (drawable.getConstantState().equals(getResources().getDrawable(R.drawable.play).getConstantState())) {
                    playOrPause.setImageResource(R.drawable.pause);
                } else {
                    playOrPause.setImageResource(R.drawable.play);
                }
            }
        });

        artistMenu.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the artist menu image is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the MainActivity
                Intent artistMenuIntent = new Intent(PlayActivity.this, MainActivity.class);
                startActivity(artistMenuIntent);
            }
        });

        songMenu.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the song menu image is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the SongActivity
                Intent songMenuIntent = new Intent(PlayActivity.this, SongActivity.class);
                songMenuIntent.putExtra("artist", artist);
                startActivity(songMenuIntent);
            }
        });
    }
}
