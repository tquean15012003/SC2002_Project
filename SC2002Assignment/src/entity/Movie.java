package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable{

	/**
	 * The title of the movie
	 */
	private String title;

	/**
	 * The synopsis of the movie
	 */
	private String synopsis;

	/**
	 * The director of the movie
	 */
	private String director;

	/**
	 * The list of cast names of the movie
	 */
	private ArrayList<String> cast = new ArrayList<String>();;

	/**
	 * The showing status of the movie
	 */
	private String showingStatus;

	/**
	 * The movie type of the movie
	 */
	private String movieType;

	/**
	 * The list of review ratings of the movie
	 */
	private ArrayList<ReviewRating> reviewRatings = new ArrayList<ReviewRating>();

	/**
	 * The duration of the movie
	 */
	private String duration;

    private Integer sales = 0;
	
	/**
	 * Creates a {@code Movie} object with the given title, synopsis, director, cast, showing status, release rating, movie type
	 */
	public Movie(String title, String synopsis, String director, ArrayList<String> cast, String showingStatus, String movieType, String duration) {
        this.title = title;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.showingStatus = showingStatus;
        this.movieType = movieType;
        this.duration = duration;
	}
	
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

     
    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }
    
    public String getShowingStatus() {
        return showingStatus;
    }

    public void setShowingStatus(String showingStatus) {
        this.showingStatus = showingStatus;
    }

    public String getMovieType() {
        return movieType;
    }
    
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<ReviewRating> getReviewRatings() {
        return this.reviewRatings;
    }
    
    public double getOverallRating() {
        if (this.reviewRatings.size() == 0) {
            return 0;
        }
        
        double overallRatings = 0;
        for (int i = 0; i < this.reviewRatings.size(); i++) {
            overallRatings +=  this.reviewRatings.get(i).getRating();
        }
        return overallRatings / this.reviewRatings.size();
    }
    
    public void addReviewRating(ReviewRating reviewRating) {
        this.reviewRatings.add(reviewRating);
    }

    public Integer getSales() {
       return this.sales;
    }
    
    public void increaseSales() {
        this.sales++;
    }
}

