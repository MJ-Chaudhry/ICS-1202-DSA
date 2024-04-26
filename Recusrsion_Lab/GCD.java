/**
 * <b>Problem 5</b>
 * 
 * GCD calculator
 */
public class GCD {
    static long getGDC(long num1, long num2) {
        int i = 2;
        boolean lcmFound = false;
        for (; i < 10; i++) {
            if (num1%i == 0 && num2 % i == 0) {
                lcmFound = true;
                break;
            }
        }

        if (!lcmFound) {
            return 1;
        }

        return i*getGDC(num1/i, num2/i);
    }

    public static void main(String[] args) {
        System.out.println(getGDC(52, 144));
    }
}
