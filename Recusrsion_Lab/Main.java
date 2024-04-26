class Main {
    /** <b> Problem 1</b>  
     * 
     * Coutdown function 
     */
    static void countdown(int n) {
        // Output the number
        System.out.println(n);
        // Base case
        if (n <= 0) {
            return;
        }
        // General case
        countdown(n-1);
    }

    /**
     * <b>Problem 2</b>
     * 
     * Countup function.
     */
    static void countup(int start, int end) {
        // Base case
        if (start > end){
            return;
        }

        // Output the number
        System.out.println(start);
        // Increment the number in the general case
        countup(++start, end);
    }

    /**
     * Problem 3
     * 
     * Sum up numbers from 1 to n inclusive.
     */
    static long sum(long n) {
        // Base case
        if (n <= 1) {
            return n;
        }
        // General case
        return n+sum(n-1);
    }

    // A faster implementation of the sum function without recursion (for fun)
    static int fastSum(int n) {
        double x = n;
        return (int)((x/2.0)*(1+n));
    }

    public static void main(String args[]) {
        System.out.println(fastSum(9));
    }
}