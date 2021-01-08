
public class Xbox360Game extends VideoGame{
	private static double CONSOLE_COST = 249.99 ;
	private static double CONSOLE_RENTAL_COST = 29.99 ;
	private static int NUM_DAYS_BASE_PRICE = 3;
	private static int MODIFIER = 1;
	private static double BASE_PRICE = 3.5;
	private static double EXTRA_PRICE = 1.50;
	private static int FREQUENT_RENTER_POINTS = 2;
	private static String CONSOLE_NAME = "Xbox 360";
	

	public Xbox360Game(String name) {
		super(CONSOLE_COST,
				CONSOLE_RENTAL_COST,
				MODIFIER,
				NUM_DAYS_BASE_PRICE,
				BASE_PRICE,
				EXTRA_PRICE,
				FREQUENT_RENTER_POINTS,
				CONSOLE_NAME,
				name
		);
	}
}
