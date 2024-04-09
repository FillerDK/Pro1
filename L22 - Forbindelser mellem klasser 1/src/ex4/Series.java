package ex4;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast = new ArrayList<>();
    private ArrayList<Episode> episodes = new ArrayList<>();

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public ArrayList<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    public void addEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number, guestActors, lengthMinutes);
        episodes.add(episode);
    }

    /**
     * Return the total length (in minutes)
     * of all the episodes in the series.
     */
    public int totalLength() {
        int totalLength = 0;
        for (Episode episode : episodes) {
            totalLength += episode.getLength();
        }
        return totalLength;
    }

    /**
     * Return the total list of all
     * guest actors from all episodes.
     */
    public ArrayList<String> getGuestActors() {
        ArrayList<String> allGuestActors = new ArrayList<>();
        for (Episode episode : episodes) {
            for (String guestActor : episode.getGuestCast())
            allGuestActors.add(guestActor);
        }
        return allGuestActors;
    }
}
