package com.example.android.bumtziplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Calin Tesu on 3/16/2018.
 */

public class SongsAdapter extends ArrayAdapter<Songs> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   A List of Songs objects to display in a list
     */
    public SongsAdapter(Activity context, ArrayList<Songs> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View songsItemView = convertView;
        if (songsItemView == null) {
            songsItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_song, parent, false);
        }

        //Get the data item for this position
        Songs currentSong = getItem(position);

        //Find the TextView in the list_song.xml layout with the ID song_title_text_view
        TextView tvTitleSong = songsItemView.findViewById(R.id.song_title_text_view);
        //Set the title
        tvTitleSong.setText(currentSong.getTitleSong());

        //Find the TextView in the list_song.xml layout with the ID song_artist_text_view and set the artist name
        TextView tvArtistSong = songsItemView.findViewById(R.id.song_artist_text_view);
        tvArtistSong.setText(currentSong.getArtistSong());

        //Find the TextVuew in the list_song.xml layout with the ID genre_tet_view and set the genre type of the song
        TextView tvGenre = songsItemView.findViewById(R.id.genre_text_view);
        tvGenre.setText(currentSong.getGenre());

        //Return the whole list item layout (containing 2 TextViews) so it can be shown in the ListView (to render on the screen)
        return songsItemView;
    }
}
