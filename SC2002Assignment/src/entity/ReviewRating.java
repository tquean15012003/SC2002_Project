package entity;

import java.util.Scanner;

public class ReviewRating {
    /**
	 * The minimum possible rating value
	 */
	public static final int MIN_RATING = 1;

	/**
	 * The maximum possible rating value
	 */
	public static final int MAX_RATING = 5;

    /**
	 * The movie goer who made the review rating
	 */
	private MovieGoer movieGoer;

    /**
	 * The rating
	 */
    private Integer rating;

    /**
	 * Creates a {@code ReviewRating} object with the given movie goer, review and rating
	 * @param movieGoer the movie goer who made the review rating
	 */
    ReviewRating(MovieGoer movieGoer) {
        this.movieGoer = movieGoer;

        Scanner input = new Scanner(System.in);
		
		System.out.println("Enter rating from 1 to 5:");
		try { 
            Integer rating = input.nextInt();
            if (rating > 5) {
                this.rating = 5;
            } else if (rating < 0) {
                this.rating = 0;
            } else {
                this.rating = rating;
            }
        } catch(Exception e) {
            this.rating = 0;
        }

        input.close();
    }

    public Integer getRating() {
        return this.rating;
    }

    public MovieGoer getMovieGoer() {
        return this.movieGoer;
    }
}
