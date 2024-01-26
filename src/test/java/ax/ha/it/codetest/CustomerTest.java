package ax.ha.it.codetest;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class CustomerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvSource({
            "name, 1000, 2, 5, 28.76796583", //loan integer, interest integer
            "name, 2000.50, 2, 5, 57.55031563", //loan double, interest integer
            "name, 3000, 2.5, 5, 97.0601877", //loan integer, interest double
            "name, 4000.50, 2.5, 5, 129.4297603" //loan double, interest double
    })
    void calcPayment(String name, double loan, double interest, int years, double expResult) {
        Customer customer = new Customer(name,loan,interest,years);
        assertEquals(expResult, customer.calcPayment(),1e-7);
    }
}