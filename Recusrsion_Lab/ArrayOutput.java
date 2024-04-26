/**
 * <b>Problem 4</b>
 * 
 * ArrayOutput
 */
public class ArrayOutput {
    /*
     * Basic array output using recursion
     */
    static <T> void _outputArray(T arr[], int index) {
        // Base case
        if (index == arr.length) {
            return;
        }
        System.out.println(arr[index]);
        _outputArray(arr, ++index);
    }

    /*
     * Array output function that hides recursive function\
     * Works for any object type except primitives (int, double, long, char, ...)
     */
    static <T> void outputArray(T arr[]) {
        // Call the recursive function.
        _outputArray(arr, 0);
    }

    public static void main(String args[]) {
        Integer arr[] = { 1, 2, 3, 4, 5, 6 };
        outputArray(arr);

        String arrS[] = { "Hello", "World!", "How are you?" };
        outputArray(arrS);
    }
}