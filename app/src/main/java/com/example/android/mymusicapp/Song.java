package com.example.android.mymusicapp;

public class Song {
    private String mArtistName;
    private String mSongTitle;
    private String mTrackLength;
    private int mImageResourceId;

    public Song (String artistName, String songTitle, String trackLength, int imageResourceId) {
        mArtistName = artistName;
        mSongTitle = songTitle;
        mTrackLength = trackLength;
        mImageResourceId = imageResourceId;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getTrackLength() {
        return mTrackLength;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
