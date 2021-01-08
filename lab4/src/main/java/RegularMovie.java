public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }
    private int NUM_DAYS_BASE_CONST = 2;
    private double BASE_RENTAL_COST = 2;
    private double LONG_TERM_RENTAL_COST = 1.5;
    private int FREQUENT_RENTER_POINTS = 1;
    public double getCharge(int _daysRented) {
        double result = BASE_RENTAL_COST;
        if (_daysRented > NUM_DAYS_BASE_CONST)
            result += (_daysRented - NUM_DAYS_BASE_CONST) * LONG_TERM_RENTAL_COST;
        return result;
    }

    public int getFrequentRenterPoints(int _daysRented) {
        return FREQUENT_RENTER_POINTS;
    }
}
