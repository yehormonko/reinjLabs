import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private static ShoppingCart emptyShoppingCart;
    private static ShoppingCart shoppingCart;

    private static Item regular3;
    private static Item regular100;
    private static Item second1;
    private static Item second2;
    private static Item second100;
    private static Item discount2;
    private static Item discount30;
    private static Item discount90;
    private static Item discount100;
    private static Item sale1;
    private static Item sale300;

    @BeforeAll
    static void init() {
        emptyShoppingCart = new ShoppingCart();

        shoppingCart = new ShoppingCart();
        shoppingCart.addItem("bread", 2.5, 2, Item.Type.REGULAR);
        shoppingCart.addItem("Same very long string", 5, 1, Item.Type.SECOND);

        regular3 = new Item("regular3", 10, Item.Type.REGULAR, 3);
        regular100 = new Item("regular100", 10, Item.Type.REGULAR, 100);
        second1 = new Item("second1", 50, Item.Type.SECOND, 1);
        second2 = new Item("second2", 50, Item.Type.SECOND, 2);
        second100 = new Item("second100", 50, Item.Type.SECOND, 100);
        discount2 = new Item("discount2", 50, Item.Type.DISCOUNT, 2);
        discount30 = new Item("discount30", 50, Item.Type.DISCOUNT, 30);
        discount90 = new Item("discount90", 50, Item.Type.DISCOUNT, 90);
        discount100 = new Item("discount100", 50, Item.Type.DISCOUNT, 100);
        sale1 = new Item("sale1", 50, Item.Type.SALE, 1);
        sale300 = new Item("sale300", 50, Item.Type.SALE, 300);
    }

    @Test
    void testToStringEmpty() {
        assertEquals("No items.", emptyShoppingCart.toString());
    }

    @Test
    void testToString() {
        String expected = " # Item Price Quan. Discount Total\n" +
                "---------------------------------------------------------\n" +
                " 1 bread                  $2.50    2  -      $5.00\n" +
                " 2 Same very long st...   $5.00    1  -      $5.00\n" +
                "---------------------------------------------------------\n" +
                " 2     $10.00";
        assertEquals(expected, shoppingCart.toString());
    }

    static class Params implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(regular3),
                    Arguments.of(regular100),
                    Arguments.of(second1),
                    Arguments.of(second2),
                    Arguments.of(second100),
                    Arguments.of(discount2),
                    Arguments.of(discount30),
                    Arguments.of(discount90),
                    Arguments.of(discount100),
                    Arguments.of(sale1),
                    Arguments.of(sale300)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(Params.class)
    void calculateDiscountTest(Item item) {
        int actual = ShoppingCart.calculateDiscount(item);
        if (item == regular3) {
            assertEquals(0, actual);
        } else if (item == regular100) {
            assertEquals(10, actual);
        } else if (item == second1) {
            assertEquals(0, actual);
        } else if (item == second2) {
            assertEquals(40, actual);
        } else if (item == second100) {
            assertEquals(50, actual);
        } else if (item == discount2) {
            assertEquals(10, actual);
        } else if (item == discount30) {
            assertEquals(25, actual);
        } else if (item == discount90) {
            assertEquals(40, actual);
        } else if (item == discount100) {
            assertEquals(50, actual);
        } else if (item == sale1) {
            assertEquals(80, actual);
        } else if (item == sale300) {
            assertEquals(85, actual);
        }
    }
}
