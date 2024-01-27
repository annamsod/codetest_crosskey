package ax.ha.it.codetest;

/**
 * Class for utils used by the application
 */
public class Utils {
    /**
     * Method for calculating an exponential function x^y
     * Needed since usage of Java.math was not allowed
     * This method is used instead of the math.pow() method
     * @param base the base of the exponential function, a double
     * @param exponent the exponent of the exponential function, an integer
     * @return returns the result of the function: '(base) to the power of (exponent)'
     */
    static double power(double base, int exponent){
        double result=1;
        for(int i = exponent; i!=0; i--){
            result=result*base;
        }
        return result;
    }
}
