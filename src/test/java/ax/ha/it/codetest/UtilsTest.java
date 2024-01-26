package ax.ha.it.codetest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @ParameterizedTest
    @CsvSource({
            "0,5,0", //base=0 --> result=0
            "5,0,1", //exponent=0 --> result=1
            "5,2,25", //base arbitrary integer, 5^2=25
            "0.5,2,0.25" //base arbitrary double, 0.5^2=0.25
    })
    void testPower (double base, int exponent, double expectedResult) {
        double result = Utils.power(base,exponent);
        assertEquals(expectedResult,result);
    }
}