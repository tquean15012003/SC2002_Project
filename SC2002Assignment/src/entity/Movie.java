package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains all the information of a movie
 */

public class Movie implements Serializable{
    
    /**
     * The serialization version number
     */
    private static final long serialVersionUID = 5L;


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
	private ShowingStatus showingStatus;

	/**
	 * The movie type of the movie
	 */
	private MovieType movieType;

	/**
     * The movie type of the movie
     */
    private ReleaseRating releaseRating;
    
	/**
	 * The list of review ratings of the movie
	 */
	private ArrayList<ReviewRating> reviewRatings = new ArrayList<ReviewRating>();

	/**
	 * The duration of the movie
	 */
	private String duration;

	/**
     * The total sales of the movie
     */
    private Integer sales = 0;
	
	/**
	 * Creates a {@code Movie} object with the given title, synopsis, director, cast, showing status, release rating, movie type
	 * @param tittle the title of the movie
	 * @param synopsis the synopsis of the movie
	 * @param director the director of the movie
	 * @param cast the cast list of the movie
	 * @param showingStatus the showingStatus of the movie
	 * @param movieType the movie type
	 * @param releaseRating the release rating of the movie
	 * @param duration the duration of the movie
	 */
	public Movie(String title, String synopsis, String director, ArrayList<String> cast, ShowingStatus showingStatus, MovieType movieType, ReleaseRating releaseRating, String duration) {
        this.title = title;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.showingStatus = showingStatus;
        this.movieType = movieType;
        this.releaseRating = releaseRating;
        this.duration = duration;
	}
	
	 /**
     * This method returns the title of the movie
     * @return the title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets the title of the movie
     * @param title the title of the movie
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * This method returns the synopsis of the movie
     * @return the synopsis of the movie
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * This method sets the synopsis of the movie
     * @param synopsis the synopsis of the movie
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * This method returns the director of the movie
     * @return the director of the movie
     */
    public String getDirector() {
        return director;
    }

    /**
     * This method sets the director of the movie
     * @param director the director of the movie
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * This method returns the list of cast
     * @return the list of cast
     */
    public ArrayList<String> getCast() {
        return cast;
    }

    /**
     * This method sets the list of cast
     * @param cast the list of cast
     */
    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }
    
    /**
     * This method returns the showing status of the movie
     * @return the showing status of the movie
     */
    public ShowingStatus getShowingStatus() {
        return showingStatus;
    }

    /**
     * This method sets the showing status of the movie
     * @param showingStatus the showing status of the movie
     */
    public void setShowingStatus(ShowingStatus showingStatus) {
        this.showingStatus = showingStatus;
    }

    /**
     * This method returns the movie type
     * @return the movie type
     */
    public MovieType getMovieType() {
        return movieType;
    }
    
    /**
     * This method returns the movie type
     * @param movieType the movie type
     */
    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
    
    /**
     * This method returns the release rating of the movie
     * @return the release rating of the movie
     */
    public ReleaseRating getReleaseRating() {
        return this.releaseRating;
    }
    
    /**
     * This method sets the release rating of the movie
     * @param releaseRating the release rating of the movie
     */
    public void setReleaseRating(ReleaseRating releaseRating) {
        this.releaseRating = releaseRating;
    }

    /**
     * This method returns the duration of the movie
     * @return the duration of the movie
     */
    public String getDuration() {
        return duration;
    }

    /**
     * This method sets the duration of the movie
     * @param duration the duration of the movie
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * This method returns the review list
     * @return the review list
     */
    public ArrayList<ReviewRating> getReviewRatings() {
        return this.reviewRatings;
    }
    
    /**
     * This method returns the overall rating
     * @return the overall rating
     */
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
    
    /**
     * This method adds a review into the list
     * @param reviewRating an instance of ReviewRating
     */
    public void addReviewRating(ReviewRating reviewRating) {
        this.reviewRatings.add(reviewRating);
    }

    /**
     * This method returns the total of sales of the movie
     * @return the total of sales of the movie
     */
    public Integer getSales() {
       return this.sales;
    }
    
    /**
     * This method increases the total sales by 1
     */
    public void increaseSales() {
        this.sales++;
    }
}

