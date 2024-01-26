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
            "name, 1000, 2, 5, 17.52776005", //loan integer, interest integer
            "name, 2000.50, 2, 5, 35.06428399", //loan double, interest integer
            "name, 3000, 2.5, 5, 53.24208482", //loan integer, interest double
            "name, 4000.50, 2.5, 5, 70.9983201" //loan double, interest double
    })
    void calcPaymentTest(String name, double loan, double interest, int years, double expResult) {
        Customer customer = new Customer(name,loan,interest,years);
        assertEquals(expResult, customer.calcPayment(),1e-7);
    }
}