package raj.yash; //usually same for organization conviniance

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test // tells junit this method to run
    void testAdd() {
        MathUtils mathUntils = new MathUtils();
        int expectedValue = 3;
        int actualValue = mathUntils.add(1, 2);
        assertEquals(expectedValue, actualValue, "Add two numbers");
    }

    // when you run mvn test junit platform runs all the @Test annoted methods.
    // No news is good News >> No failure means success.
    // asserrtions are used to assert that something has happend as we wanted it to.

    // Other methods :
    // assertEquals(expected, actual)
    // assertArrayEquals(expectedArray, actualArray)
    // assertIterableEquals(expectedArray, actualArray)

    // @Test
    // void testDivide1() {
    // MathUtils mathUtils = new MathUtils();
    // try {
    // mathUtils.divide(1, 0);
    // } catch (ClassCastException c) {

    // }
    // fail("SOme other Type of exception");
    // }

    @Test
    void testDivide() {
        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

    @Test
    void testAreaCircle() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.16, mathUtils.area(10), "Area of Circle");
    }

}