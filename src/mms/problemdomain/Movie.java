package src.mms.problemdomain;

public class Movie {
    // Creates the movie attributes.
    private int duration;
    private String title;
    private int year;

    // Sets the parameters.
    public Movie(int duration, String title, int year) {
        this.duration = duration;
        this.title = title;
        this.year = year;
    }

    // Movie attribute getters.
    public int getDuration() {
        return duration;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }

    // Returns the Movie object's attributes formatted for a table.
    @Override
    public String toString() {
        return String.format("%-12s", duration) + year + "  " + title;
    }
}
