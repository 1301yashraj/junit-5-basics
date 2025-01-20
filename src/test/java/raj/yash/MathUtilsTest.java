package raj.yash; //usually same for organization conviniance

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @Test // tells junit this method to run
    void testAdd() {
        int expectedValue = 3;
        int actualValue = mathUtils.add(1, 2);
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

    // try {
    // mathUtils.divide(1, 0);
    // } catch (ClassCastException c) {

    // }
    // fail("SOme other Type of exception");
    // }

    @Test
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

    @Test
    void testAreaCircle() {
        assertEquals(314.16, mathUtils.area(10), "Area of Circle");
    }

}