package lesson4;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static lesson4.Function.isHeronFormula;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TriangleTest {

    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    private double HeronFormulaTest(int firstSideLength, int secondSideLength, int thirdSideLength) {

        double p = ((double) (firstSideLength + secondSideLength + thirdSideLength)) / 2;
        return Math.sqrt(p * (p - firstSideLength) * (p - secondSideLength) * (p - thirdSideLength));
    }

    @BeforeAll
    static void BeforeAllTests() { logger.info("All tests started"); }

    @BeforeEach
    public void BeforeEachTests() { logger.info("Test started"); }

    @Test
    @DisplayName("checking that the result is correct ")
    public void resultIsCorrect() {

        int firstSideLength = 2;
        int secondSideLength = 3;
        int thirdSideLength = 4;

        assumeTrue((firstSideLength > 0 && secondSideLength > 0 && thirdSideLength > 0), "invalid value for side length of a triangle ");

        double S = HeronFormulaTest(firstSideLength, secondSideLength, thirdSideLength);

        boolean result = isHeronFormula(firstSideLength, secondSideLength, thirdSideLength) == S;
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("checking that the result is incorrect ")
    public void resultIsInCorrect() {

        int firstSideLength = 2;
        int secondSideLength = 3;
        int thirdSideLength = 4;

        assumeTrue((firstSideLength > 0 && secondSideLength > 0 && thirdSideLength > 0), "invalid value for side length of a triangle ");

        double S = HeronFormulaTest(firstSideLength, secondSideLength, thirdSideLength);

        boolean result = isHeronFormula(firstSideLength + secondSideLength, secondSideLength, thirdSideLength) == S;
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("checking that the result is correct with rearranged sides ")
    public void resultIsCorrectWithRearrangedSides() {

        int firstSideLength = 2;
        int secondSideLength = 3;
        int thirdSideLength = 4;

        assumeTrue((firstSideLength > 0 && secondSideLength > 0 && thirdSideLength > 0), "invalid value for side length of a triangle ");

        double S = HeronFormulaTest(firstSideLength, secondSideLength, thirdSideLength);

        boolean result = isHeronFormula(secondSideLength, thirdSideLength, firstSideLength) == S;
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName(" this test should be skipped ")
    public void negativeMeaning() {

        int firstSideLength = 2;
        int secondSideLength = -3;
        int thirdSideLength = 4;

        assumeTrue((firstSideLength > 0 && secondSideLength > 0 && thirdSideLength > 0), "invalid value for side length of a triangle ");

        double S = HeronFormulaTest(firstSideLength, secondSideLength, thirdSideLength);

        boolean result = isHeronFormula(firstSideLength, secondSideLength, thirdSideLength) == S;
        Assertions.assertTrue(result);
    }

    @AfterEach
    public void AfterEachTest() { logger.info("Test completed"); }

    @AfterAll
    static void AfterAllTests() { logger.info("Tests completed");}

}
