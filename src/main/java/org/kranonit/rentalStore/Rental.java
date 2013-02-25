package org.kranonit.rentalStore;

class Rental {

    public static final int REGULAR_MOVIE_RENT_PRICE = 2;
    public static final int MAX_DAYS_FOR_RENT_REGULAR = 2;
    public static final double OVERDUE_PENALTY = 1.5;
    public static final int NEW_RELEASE_RENT_PRICE = 3;
    public static final double CHILDREN_MOVIE_RENT_PRICE = 1.5;
    public static final int MAX_DAYS_FOR_RENT_CHILDREN = 3;
    private Movie _movie;

    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

	public double getCharge() {
		double result = 0;
		// determine rental price for movie by his type
		switch (getMovie().getPriceCode()) {
			case Movie.REGULAR:
				result = getPriceForRegularMovie();
				break;
			case Movie.NEW_RELEASE:
				result = getPriceForNewRelease();
				break;
			case Movie.CHILDRENS:
				result = getPriceForChildrenMovie();
				break;
		}
		return result;
	}

    private double getPriceForRegularMovie(){
        double result = REGULAR_MOVIE_RENT_PRICE;
        if (getDaysRented() > MAX_DAYS_FOR_RENT_REGULAR)
            result += (getDaysRented() - MAX_DAYS_FOR_RENT_REGULAR) * OVERDUE_PENALTY;
        return result;
    }

    private double getPriceForNewRelease(){
        return getDaysRented() * NEW_RELEASE_RENT_PRICE;
    }

    private double getPriceForChildrenMovie(){
        double result = CHILDREN_MOVIE_RENT_PRICE;
        if (getDaysRented() > MAX_DAYS_FOR_RENT_CHILDREN)
            result += (getDaysRented() - MAX_DAYS_FOR_RENT_CHILDREN) * OVERDUE_PENALTY;
        return result;
    }

	public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public boolean isRentNewReleaseTwoDays() {
        return (getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && getDaysRented() > 1;
    }

    public String getNameAndPriceAsString() {
        return "\t" + getMovie().getTitle() + "\t"
                + String.valueOf(getCharge()) + "\n";
    }
}