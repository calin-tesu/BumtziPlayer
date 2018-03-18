package com.example.android.bumtziplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.bumtziplayer.R.layout.activity_artists;

public class ArtistsActivity extends AppCompatActivity {

    //Stores the list of artists
    ArrayList<String> artistsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_artists);

        TextView songsMenu = findViewById(R.id.songs);
        TextView genresMenu = findViewById(R.id.genres);

        //Generates a hypothetical list of artists
        if (artistsList.isEmpty()) {
            for (int artist = 0; artist < 20; artist++) {
                //the names of the artist should start from "John Doe 1" not from "John Doe 0"
                //That's why i have used artist + 1
                artistsList.add("John Doe " + (artist + 1));
            }
        }

        // Create an {@link artistsAdapter}, whose data source is a list of {@link artistsList}. The
        // adapter knows how to create list items for each item in the list.
        ArrayAdapter<String> artistsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, artistsList);
        ListView artistListView = findViewById(R.id.list);
        artistListView.setAdapter(artistsAdapter);

        //Set a click listener on the views
        songsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(ArtistsActivity.this, MainActivity.class);
                startActivity(songsIntent);
            }
        });

        genresMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent genresIntent = new Intent(ArtistsActivity.this, GenresActivity.class);
                startActivity(genresIntent);
            }
        });

        //Set onClick for the items in the artists list
        artistListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String clickedArtist = artistsList.get(position).toString();
                Intent nowPlaying = new Intent(ArtistsActivity.this, NowPlayingActivity.class);
                nowPlaying.putExtra("Song Artist", clickedArtist);
                startActivity(nowPlaying);
            }
        });

    }
}
