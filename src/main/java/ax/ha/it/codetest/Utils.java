package ax.ha.it.codetest;

public class Utils {
    static double power(double base, int exponent){
        double result=1;
        for(int i = exponent; i!=0; i--){
            result=result*base;
        }
        return result;
    }
}
