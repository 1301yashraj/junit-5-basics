package raj.yash; //usually same for organization conviniance

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)  //default
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo info; // Testinfo and TestReport are Dependency injected Interfaces
    TestReporter reporter;

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

    // But if we have instance per class you can make it non static also.
    @BeforeAll
    static void beforeALLInit() {
        // System.out.println("Running only once per test class");
    }

    // This @BeforeEach will run before every @Test annoted method is executed, thus
    // creating an object for all the cases each time a method is run
    @BeforeEach
    void init(TestInfo info, TestReporter reporter) {
        this.info = info;
        this.reporter = reporter;
        // System.out.println("Creating a Instance >>>>>> ");
        mathUtils = new MathUtils();
    }

    @Nested // used for organizing tests into different subsets/groups under different
            // classes
    @DisplayName("Add Test")
    @Tag("Math") // use mvn Test -Dgroups = Math will run all tests with Math Tag
    class AddTest {
        @Test // tells junit this method to run
        @DisplayName("Adding 2 Positive Numbers") // for Ecllipse or intellij to display the name tag
        void testAddPostive() {
            System.out.println(info.getDisplayName() + " is Run for Tag " + info.getTags());
            reporter.publishEntry("TAG >>>>>>>>> " + info.getTags());
            int expectedValue = 3;
            int actualValue = mathUtils.add(1, 2);
            assertEquals(expectedValue, actualValue, "Add two numbers");
        }

        @Test
        @DisplayName("Adding 2 negative numbers")
        void testAddNegative() {
            int expectedValue = -3;
            int actualValue = mathUtils.add(-1, -2);
            assertEquals(expectedValue, actualValue, "Add two numbers");
        }
    }

    // when you run mvn test junit platform runs all the @Test annoted methods.
    // No news is good News >> No failure means success.
    // asserrtions are used to assert that something has happend as we wanted it to.

    // Other methods :
    // assertEquals(expected, actual)
    // assertArrayEquals(expectedArray, actualArray)
    // assertIterableEquals(expectedArray, actualArray)

    @Test
    @DisplayName("Divide Test")
    @Tag("Math")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

    // @Test // other way to check exception , another one is to use equal method to
    // check the class type
    // void testDivide1() {
    // try {
    // mathUtils.divide(1, 0);
    // } catch (ClassCastException c) {
    // }
    // fail("SOme other Type of exception");
    // }

    @Test
    @Disabled
    @DisplayName("Cricle Area Test")
    @Tag("Circle")
    void testAreaCircle() {
        assertEquals(314.16, mathUtils.area(10), "Area of Circle");
    }

    @DisplayName("Repeated Circle Area Test")
    @RepeatedTest(1) // perform this test 3 times example
    @Tag("Circle")
    void testAreaCircleRep(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 1)
            assertEquals(314.16, mathUtils.area(10), "Area of Circle");
        else {
            assertEquals(31415.93, mathUtils.area(100), "Area of Circle");
        }
    }

    @Test
    @DisplayName("Multiply Test >> 4 cases in 1")
    @Tag("Math")
    void testMutliply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1)),
                () -> assertEquals(4, mathUtils.multiply(-2, -2)));
    }

    @AfterEach
    void afterEachMethod() {
        // System.out.println("----Tested----");
    }

}