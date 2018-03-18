package com.example.android.bumtziplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        TextView songsMenu = findViewById(R.id.songs);
        TextView artistsMenu = findViewById(R.id.artists);

        //Get the string array of genres from resources and store it in an ArrayList
        String[] genres = getResources().getStringArray(R.array.genres_array);
        final List<String> musicalGenres = new ArrayList<>(Arrays.asList(genres));

        // Create an {@link artistsAdapter}, whose data source is a list of {@link artistsList}. The
        // adapter knows how to create list items for each item in the list.
        final ArrayAdapter<String> genreAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musicalGenres);
        final GridView genreGridView = findViewById(R.id.grid_genres);
        genreGridView.setAdapter(genreAdapter);

        //Set a click listener on the views
        artistsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(GenresActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });

        //Set a click listener on the views
        songsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(GenresActivity.this, MainActivity.class);
                startActivity(songsIntent);
            }
        });

        //Set onClick for the items in the artists list
        genreGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String clickedGenre = musicalGenres.get(position).toString();
                Intent nowPlaying = new Intent(GenresActivity.this, NowPlayingActivity.class);
                nowPlaying.putExtra("Genre", clickedGenre);
                startActivity(nowPlaying);
            }
        });
    }
}
