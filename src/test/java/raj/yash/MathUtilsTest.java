package raj.yash; //usually same for organization conviniance

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)  //default
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
    MathUtils mathUtils;

    public MathUtilsTest() {
        // Using the below you can check TestInstance behaviour
        // TestInstance tells when to create the object of the class
        // System.out.println("-------Constructor for the class-----");
    }

    // BeforeAll , AfterALL runs even before MathUtilTest Instance is created,
    // because
    // MathUtilTest is created for all the Test methods separately.
    // so to run a method even before its instance is created the method must be
    // static.

    // But if we have instance per class you can make it no static also.
    @BeforeAll
    static void beforeALLInit() {
        // System.out.println("Running only once per test class");
    }

    // This @BeforeEach will run before every @Test annoted method is executed, thus
    // creating an object for all the cases each time a method is run
    @BeforeEach
    void init() {
        // System.out.println("Creating a Instance >>>>>> ");
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

    @AfterEach
    void afterEachMethod() {
        // System.out.println("----Tested----");
    }

}