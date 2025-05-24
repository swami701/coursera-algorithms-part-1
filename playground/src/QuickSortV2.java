
import java.util.Random;

public class QuickSortV2 {

    public static void main(String[] args) {
        int[] input = {1, 2, 7, 9, 11, 3, 4, 5, 6, 8, 10};
        // int[] input = { 1, 7, 2, 10, 9 };
        // int[] input = { 2, 7, 1, 10, 3 };
        System.out.println("Input");
        print(input);
        shuffle(input);
        System.out.println("Shuffled Input");
        print(input);
        quickSort(input);
        System.out.println("Result: ");
        print(input);
    }

    private static void shuffle(int[] input) {
        for (int i = 1; i < input.length; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(i);
            int temp = input[i];
            input[i] = input[randomIndex];
            input[randomIndex] = temp;
        }
    }

    private static void quickSort(int[] input) {
        sort(0, input, input.length - 1);
    }

    private static void sort(int start, int[] input, int end) {
        if (start >= end) {
            return;
        }
        int idx = partition(input, start, end);
        sort(start, input, idx);
        sort(idx+1, input, end);
    }

    private static int partition (int[] input, int start, int end) {
        int i = start + 1, j = end;
        while (i <= j) {
            if (input[i] < input[start]) {
                i++;
            } else if (input[j] > input[start]) {
                j--;
            } else {
                swap(input, i, j);
            }
        }
        swap(input, start, j);
        System.out.println("Partition Input");
        print(input);
        return j;
    }

    /**
    * 2 7 1 10 3
    * 0 1 2  3 4
    * 
    * sort(0, 4)
    *  i = 1, j = 4
    *  i = 1, j = 3
    *  i = 1, j = 2
    *  2 1 7 10 3
    *  0 1 2  3 4
    *  i = 2, j = 2
    */
    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void print(int[] input) {
        for (int i : input) {
            System.out.print("\t" + i);
        }
        System.out.println();
    }
}
