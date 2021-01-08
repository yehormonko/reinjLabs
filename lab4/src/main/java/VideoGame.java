public abstract class  VideoGame {
    private double CONSOLE_COST;
    private double CONSOLE_RENTAL_COST;
    private double MODIFIER;
    private int NUM_DAYS_BASE_PRICE;
    private double BASE_PRICE;
    private double EXTRA_PRICE;
    private int FREQUENT_RENTER_POINTS;
    private String CONSOLE_NAME;
    private String _gameName;

    public VideoGame(double CONSOLE_COST,
                     double CONSOLE_RENTAL_COST,
                     double MODIFIER,
                     int NUM_DAYS_BASE_PRICE,
                     double BASE_PRICE,
                     double EXTRA_PRICE,
                     int FREQUENT_RENTER_POINTS,
                     String CONSOLE_NAME,
                     String _gameName) {
        this.CONSOLE_COST = CONSOLE_COST;
        this.CONSOLE_RENTAL_COST = CONSOLE_RENTAL_COST;
        this.MODIFIER = MODIFIER;
        this.NUM_DAYS_BASE_PRICE = NUM_DAYS_BASE_PRICE;
        this.BASE_PRICE = BASE_PRICE;
        this.EXTRA_PRICE = EXTRA_PRICE;
        this.FREQUENT_RENTER_POINTS = FREQUENT_RENTER_POINTS;
        this.CONSOLE_NAME = CONSOLE_NAME;
        this._gameName = _gameName;
    }

    public String get_gameName() {
        return _gameName;
    }

    public String get_consoleName() {
        return CONSOLE_NAME;
    }

    public double getCharge(int _daysRented, boolean _consoleRented) {
        double result = 0;
        result += BASE_PRICE;
        if(_daysRented > NUM_DAYS_BASE_PRICE)
            result += (_daysRented - NUM_DAYS_BASE_PRICE)*EXTRA_PRICE;
        if(_consoleRented){
            result += MODIFIER;
            result += CONSOLE_RENTAL_COST + _daysRented;
        }
        return result;
    }

    public int getFrequentRenterPoints(int _daysRented, boolean _consoleRented) {
        if(_consoleRented)
            return FREQUENT_RENTER_POINTS + _daysRented;
        else
            return FREQUENT_RENTER_POINTS;
    }
    public String toString() {
        return _gameName;
    }

}
