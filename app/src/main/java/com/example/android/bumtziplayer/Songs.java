package com.example.android.bumtziplayer;

/**
 * {@link Songs} represents the song that the user wants to play.
 * It contain song title and song artist.
 */

public class Songs {

    /**
     * Song title
     */
    private String mTitleSong;

    /**
     * Song artist
     */
    private String mArtistSong;

    /**
     * Song genre
     */
    private String mGenre;

    /**
     * Create a new Song object.
     *
     * @param titleSong  is the song title
     * @param artistSong is the song artist
     */
    public Songs(String titleSong, String artistSong, String genre) {
        mTitleSong = titleSong;
        mArtistSong = artistSong;
        mGenre = genre;
    }

    /**
     * Get the song title
     */
    public String getTitleSong() {
        return mTitleSong;
    }

    /**
     * Get the song artist name
     */
    public String getArtistSong() {
        return mArtistSong;
    }

    /**
     * Get genre type of the song
     */
    public String getGenre() {
        return mGenre;
    }
}
