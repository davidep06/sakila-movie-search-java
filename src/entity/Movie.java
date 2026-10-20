package entity;

public class Movie {
    private int movieID;
    private String title;
    private int releaseYear;
    private int length;

    public Movie(int movieID, String title, int releaseYear, int length) {
        this.movieID = movieID;
        this.title = title;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    public int getMovieID() { return this.movieID; }

    public String getTitle() {
        return this.title;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID=" + movieID +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", length=" + length +
                '}';
    }
}