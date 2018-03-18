package com.example.android.bumtziplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Songs> songsList = new ArrayList<Songs>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Stores a few musical genres in a string array
        String[] musicalGenres = getResources().getStringArray(R.array.genres_array);

        TextView artistsMenu = findViewById(R.id.artists);
        TextView genresMenu = findViewById(R.id.genres);

        /**
         * Generates a hypothetical list of songs, with artist names, songs title, and a random genres
         */
        if (songsList.isEmpty()) {
            for (int song = 0; song < 5; song++) {
                for (int artist = 0; artist < 6; artist++) {
                    double genreRandom = Math.random() * musicalGenres.length;
                    int genreIndex = (int) genreRandom;
                    //the names of the song should start from "BUMZI BUMTZI BUMZI 1" not from "BUMZI BUMTZI BUMZI 0"
                    //That's why i have used song + 1
                    //Same for the name of the artists
                    songsList.add(new Songs("BUMTZI BUMTZI BUMTZI " + (song + 1), "John Doe " + (artist + 1), musicalGenres[genreIndex]));
                }
            }
        }

        // Create an {@link SongsAdapter}, whose data source is a list of {@link Songs}. The
        // adapter knows how to create list items for each item in the list.
        SongsAdapter adapter = new SongsAdapter(this, songsList);
        ListView songListView = findViewById(R.id.list);
        songListView.setAdapter(adapter);

        //Set a click listener on the views
        artistsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });

        genresMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent genresIntent = new Intent(MainActivity.this, GenresActivity.class);
                startActivity(genresIntent);
            }
        });

        //Set onClick for the items in the songs list
        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Songs clickedSong = songsList.get(position);
                Intent nowPlaying = new Intent(MainActivity.this, NowPlayingActivity.class);
                nowPlaying.putExtra("Song Title", clickedSong.getTitleSong());
                nowPlaying.putExtra("Song Artist", clickedSong.getArtistSong());
                nowPlaying.putExtra("Genre", clickedSong.getGenre());
                startActivity(nowPlaying);
            }
        });
    }
}
