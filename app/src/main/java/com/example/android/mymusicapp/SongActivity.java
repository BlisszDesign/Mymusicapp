package com.example.android.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {
    public String artist;
    public String song;
    public String length;
    private ImageView artistMenu;
    private ImageView artistCover;
    final Bundle songs = new Bundle();
    final Bundle timer = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_tracks);
        Bundle extras = getIntent().getExtras();
        artist = extras.getString("artist");
        song = songs.getString("songName");
        length = timer.getString("trackLength");
        artistMenu = (ImageView) findViewById(R.id.artist_menu);

        ArrayList<Song> songs = new ArrayList<Song>();
        artistCover = (ImageView) findViewById(R.id.artist_cover);

        switch (artist) {
            case "Evanescence":
                artistCover.setImageResource(R.drawable.evanescence);
                songs.add(new Song("Evanescence", "Bring Me to Life", "4:12", R.drawable.play_list));
                songs.add(new Song("Evanescence", "Going Under", "4:12", R.drawable.play_list));
                songs.add(new Song("Evanescence", "My Immortial", "4:12", R.drawable.play_list));
                songs.add(new Song("Evanescence", "Everbody´s Fool", "4:12", R.drawable.play_list));
                songs.add(new Song("Evanescence", "Lithium", "4:12", R.drawable.play_list));
                songs.add(new Song("Evanescence", "Lost in Paradise", "4:12", R.drawable.play_list));
                songs.add(new Song("Evanescence", "Imperfection", "4:12", R.drawable.play_list));
                break;
            case "Enrique Iglesias":
                artistCover.setImageResource(R.drawable.enrique);
                songs.add(new Song("Enrique Iglesias", "Hero", "4:30", R.drawable.play_list));
                songs.add(new Song("Enrique Iglesias", "Escape", "4:30", R.drawable.play_list));
                songs.add(new Song("Enrique Iglesias", "Do You Know,", "4:30", R.drawable.play_list));
                songs.add(new Song("Enrique Iglesias", "Bailamos", "4:30", R.drawable.play_list));
                songs.add(new Song("Enrique Iglesias", "Be with you", "4:30", R.drawable.play_list));
                songs.add(new Song("Enrique Iglesias", "I Like It", "4:30", R.drawable.play_list));
                songs.add(new Song("Enrique Iglesias", "Bailando", "4:30", R.drawable.play_list));
                break;
            case "ABBA":
                artistCover.setImageResource(R.drawable.abba);
                songs.add(new Song("ABBA", "Dancing Queen", "3:52", R.drawable.play_list));
                songs.add(new Song("ABBA", "Fernando", "3:52", R.drawable.play_list));
                songs.add(new Song("ABBA", "Honey, Honey", "3:52", R.drawable.play_list));
                songs.add(new Song("ABBA", "Mamma Mia", "3:52", R.drawable.play_list));
                songs.add(new Song("ABBA", "Money, Money, Money", "3:52", R.drawable.play_list));
                songs.add(new Song("ABBA", "Ring, Ring", "3:52", R.drawable.play_list));
                songs.add(new Song("ABBA", "SOS", "3:52", R.drawable.play_list));
                break;
            case "Desmod":
                artistCover.setImageResource(R.drawable.desmod);
                songs.add(new Song("Desmod", "Zostane ticho", "3:13", R.drawable.play_list));
                songs.add(new Song("Desmod", "V dolinách", "3:13", R.drawable.play_list));
                songs.add(new Song("Desmod", "Aby bolo jasné", "3:13", R.drawable.play_list));
                songs.add(new Song("Desmod", "Pár dní", "3:13", R.drawable.play_list));
                songs.add(new Song("Desmod", "Kamenné ruže", "3:13", R.drawable.play_list));
                songs.add(new Song("Desmod", "Zober ma domov", "3:13", R.drawable.play_list));
                songs.add(new Song("Desmod", "Zhorí všetko čo mám", "3:13", R.drawable.play_list));
                break;
            case "Bryan Adams":
                artistCover.setImageResource(R.drawable.bryan);
                songs.add(new Song("Bryan Adams", "Heaven", "4:39", R.drawable.play_list));
                songs.add(new Song("Bryan Adams", "Summer of ´69", "4:39", R.drawable.play_list));
                songs.add(new Song("Bryan Adams", "Here I Am", "4:39", R.drawable.play_list));
                songs.add(new Song("Bryan Adams", "All for Love", "4:39", R.drawable.play_list));
                songs.add(new Song("Bryan Adams", "Please Forgive Me", "4:39", R.drawable.play_list));
                songs.add(new Song("Bryan Adams", "I Do It For You", "4:39", R.drawable.play_list));
                songs.add(new Song("Bryan Adams", "Somebody", "4:39", R.drawable.play_list));
                break;
        }
        final SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        //set a click listener for songsMenu
        artistMenu.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs menu image is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the SongActivity
                Intent songsMenuIntent = new Intent(SongActivity.this, MainActivity.class);
                startActivity(songsMenuIntent);
            }
        });

      /*  //set a click listener for playMenu
        playMenu.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play menu image is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the PlayActivity
                Intent playMenuIntent = new Intent(SongActivity.this, PlayActivity.class);
                startActivity(playMenuIntent);
            }
        });*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SongActivity.this, PlayActivity.class);
                intent.putExtra("artist", artist);
                Song clickedSong = (Song) adapter.getItem(position);
                song = clickedSong.getSongTitle();
                intent.putExtra("songName", song);
                length = clickedSong.getTrackLength();
                intent.putExtra("trackLength", length);
                startActivity(intent);
            }
        });
    }
}
