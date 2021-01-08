import org.junit.*;

public class MovieRentalTest extends junit.framework.TestCase {

    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;
    @Before
    public void setUp() {
        theManWhoKnewTooMuch =
                new RegularMovie( " The Man Who Knew Too Much" );
        mulan = new ChildrensMovie( " Mulan" );
        slumdogMillionaire =
                new NewReleaseMovie( "Slumdog Millionaire" );

    }


    @Test
    public void testGetDaysRented() {
        assertEquals(2, new MovieRental(theManWhoKnewTooMuch, 2).getDaysRented());
    }

    @Test
    public void testGetMovie() {
        assertEquals(theManWhoKnewTooMuch, new MovieRental(theManWhoKnewTooMuch, 2).getMovie());
    }

    @Test
    public void testGetName() {
        String name = "John Doe"; 
        assertEquals(name, new Customer(name)._name);
    }

    @Test
    public void testStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        MovieRental movieRental = new MovieRental(theManWhoKnewTooMuch, 2);
        johnDoe.addMovieRental(movieRental);
        String start = "Rental Record for "+johnDoe._name;
        String statement = start+"\n\t"+movieRental.getMovie().get_title()+"\t"+movieRental.getCharge()+
                "\nAmount owed is " + 2.0 + "\n"
                + "You earned " + 1
                + " frequent renter points";
        assertEquals(statement, johnDoe.statement());
        MovieRental movieRental2 = new MovieRental(theManWhoKnewTooMuch, 3);
        johnDoe.addMovieRental(movieRental2);
        statement = start+"\n\t"+movieRental.getMovie().get_title()+"\t"+movieRental.getCharge()+
                "\n\t"+movieRental2.getMovie().get_title()+"\t"+movieRental2.getCharge()+
                "\nAmount owed is " + 5.5 + "\n"
                + "You earned " + 1
                + " frequent renter points";
        assertEquals(statement, johnDoe.statement());
    }

    @Test
    public void testStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        MovieRental movieRental = new MovieRental(mulan, 2);
        johnDoeJr.addMovieRental(movieRental);
        String start = "Rental Record for "+johnDoeJr._name;
        String statement = start+"\n\t"+movieRental.getMovie().get_title()+"\t"+movieRental.getCharge()+
                "\nAmount owed is " + 1.5 + "\n"
                + "You earned " + 1
                + " frequent renter points";
        assertEquals(statement, johnDoeJr.statement());
        MovieRental movieRental2 = new MovieRental(mulan, 2);
        johnDoeJr.addMovieRental(movieRental2);
        statement = start+"\n\t"+movieRental.getMovie().get_title()+"\t"+movieRental.getCharge()+
                "\n\t"+movieRental2.getMovie().get_title()+"\t"+movieRental2.getCharge()+
                "\nAmount owed is " + 3.0 + "\n"
                + "You earned " + 1
                + " frequent renter points";
        assertEquals(statement, johnDoeJr.statement());
    }

    @Test
    public void testStatementNewReleaseOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");
        MovieRental movieRental = new MovieRental(slumdogMillionaire, 1);
        janeDoe.addMovieRental(movieRental);
        String start = "Rental Record for "+janeDoe._name;
        String statement = start+"\n\t"+movieRental.getMovie().get_title()+"\t"+movieRental.getCharge()+
                "\nAmount owed is " + 3.0 + "\n"
                + "You earned " + 1
                + " frequent renter points";
        assertEquals(statement, janeDoe.statement());
        MovieRental movieRental2 = new MovieRental(slumdogMillionaire, 1);
        janeDoe.addMovieRental(movieRental2);
        statement = start+"\n\t"+movieRental.getMovie().get_title()+"\t"+movieRental.getCharge()+
                "\n\t"+movieRental2.getMovie().get_title()+"\t"+movieRental2.getCharge()+
                "\nAmount owed is " + 6.0 + "\n"
                + "You earned " + 1
                + " frequent renter points";
        assertEquals(statement, janeDoe.statement());
    }
}