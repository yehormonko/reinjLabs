class MovieRental {

    private Movie _movie;
    private int _daysRented;

    public MovieRental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

//    double amountFor() {
//        double result = 0;
//        getMovie()
//        // determine amounts for eRental line
//        switch (getMovie().getPriceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if (getDaysRented() > 2)
//                    result += (getDaysRented() - 2) * 1.5;
//                break;
//            case Movie.NEW_RELEASE:
//                result += getDaysRented() * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (getDaysRented() > 3)
//                    result += (getDaysRented() - 3) * 1.25;
//                break;
//        }
//        return result;
//    }


    public double getCharge() {
        return _movie.getCharge( _daysRented) ;
    }
    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints( _daysRented) ;
    }
}
