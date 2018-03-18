package com.example.android.bumtziplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Store the song that is currently played
        final String songCurrentlyPlayed;

        TextView songsMenu = findViewById(R.id.songs);
        TextView artistsMenu = findViewById(R.id.artists);
        TextView genresMenu = findViewById(R.id.genres);
        ImageButton playButton = findViewById(R.id.play_button);
        ImageButton stopButton = findViewById(R.id.stop_button);

        //Get the song to be played from the previous activities
        Intent nowPlaying = getIntent();
        //NOTE: when i lunch an Intent from the ArtistsActivity i only put one extra (Song_Artist), so the String songCurrentlyPlayed is like "John Doe 3 - null - null"
        songCurrentlyPlayed = nowPlaying.getStringExtra("Song Artist") + " - " + nowPlaying.getStringExtra("Song Title") + " - " + nowPlaying.getStringExtra("Genre");

        //Set a click listener on the views
        songsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(artistsIntent);
            }
        });

        artistsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(NowPlayingActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });

        genresMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent genresIntent = new Intent(NowPlayingActivity.this, GenresActivity.class);
                startActivity(genresIntent);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv_song_played = findViewById(R.id.tv_song_played);
                tv_song_played.setText(songCurrentlyPlayed);
                tv_song_played.setSelected(true);
                tv_song_played.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                tv_song_played.setHorizontallyScrolling(false);
                tv_song_played.setSingleLine(true);

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv_song_played = findViewById(R.id.tv_song_played);
                tv_song_played.setText("Nothing is playing!");
            }
        });
    }
}
