public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }
    private int NUM_DAYS_BASE_CONST = 3;
    private double BASE_RENTAL_COST = 3;
    private double LONG_TERM_RENTAL_COST = 1.25;
    private int FREQUENT_RENTER_POINTS = 1;
    public double getCharge(int _daysRented) {
        return _daysRented * BASE_RENTAL_COST;
    }

    public int getFrequentRenterPoints(int _daysRented) {
        if (_daysRented > FREQUENT_RENTER_POINTS)
            return FREQUENT_RENTER_POINTS*2;
        return FREQUENT_RENTER_POINTS;
    }
}
