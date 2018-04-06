package com.example.android.mymusicapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);
        TextView artistView = (TextView) listItemView.findViewById(R.id.artist_view);
        artistView.setText(currentSong.getArtistName());

        TextView songView = (TextView) listItemView.findViewById(R.id.song_view);
        songView.setText(currentSong.getSongTitle());

        TextView trackView = (TextView) listItemView.findViewById(R.id.track_length);
        trackView.setText(currentSong.getTrackLength());

        ImageView playView = (ImageView) listItemView.findViewById(R.id.play);
        playView.setImageResource(currentSong.getImageResourceId());
        return listItemView;
        }

    }

