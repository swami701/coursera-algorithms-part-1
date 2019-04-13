/**
 * Search in a bitonic array. An array is bitonic if it is comprised of an increasing sequence of integers followed
 * immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of nn
 * distinct integer values, determines whether a given integer is in the array.
 * <p>
 * Standard version: Use ∼3lgn compares in the worst case.
 * <p>
 * Signing bonus: Use ∼2lgn compares in the worst case (and prove that no algorithm can guarantee to perform fewer
 * than ∼2lgn compares in the worst case).
 */
public class BitonicArraySearch {
    private static final int[] input = {0, 3, 4, 5, 2, 1};
    private static final int valToFind = 1;

    public static void main(String[] args) {
        System.out.println("Bitonic Array Search!!");
        System.out.print("Input Array: ");
        for (int i : input) {
            System.out.print("\t" + i);
        }
        System.out.println();
        System.out.println("Is Value " + valToFind + " present: " + isValuePresent(input, valToFind));
    }

    /**
     * Check if the value present - 3 logn passes
     *
     * @param arr       array
     * @param valToFind int
     * @return boolean
     */
    private static boolean isValuePresent(int[] arr, int valToFind) {
        if (arr.length == 0) return false;

        // Find the biggest
        int first = 0, last = arr.length - 1, mid = (first + last) / 2;
        while (first <= last && mid > 0 && mid < arr.length - 1) {
            if (arr[mid - 1] > arr[mid]) {
                last = mid - 1;
                mid = (first + last) / 2;
            } else if (arr[mid + 1] > arr[mid]) {
                first = mid + 1;
                mid = (first + last) / 2;
            } else {
                break;
            }
        }

        // Traverse the left part of big
        int bigIdx = mid;
        if (valToFind > arr[bigIdx]) return false;

        first = 0;
        last = bigIdx;
        mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < valToFind) {
                first = mid + 1;
                mid = (first + last) / 2;
            } else if (arr[mid] > valToFind) {
                last = mid - 1;
                mid = (first + last) / 2;
            } else {
                return true;
            }
        }

        // Traverse the right part of the big
        first = bigIdx;
        last = arr.length - 1;
        mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] > valToFind) {
                first = mid + 1;
                mid = (first + last) / 2;
            } else if (arr[mid] < valToFind) {
                last = mid - 1;
                mid = (first + last) / 2;
            } else {
                return true;
            }
        }
        return false;
    }


}
