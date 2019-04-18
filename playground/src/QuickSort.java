public class QuickSort {
    private static final int[] input = {9, 1, 10, 7, 8, 3, 2, 4, 6, 5};

    public static void main(String[] args) {
        System.out.println("Quick sort!!");
        System.out.print("Input Array: ");
        for (int i : input) {
            System.out.print("\t" + i);
        }
        shuffleArray(input);
        System.out.println();
        System.out.print("Shuffled List: ");
        for (int i : input) {
            System.out.print("\t" + i);
        }
        System.out.println();
        quickSort(input, 0, input.length - 1);
        System.out.print("Sorted Array: ");
        for (int i : input) {
            System.out.print("\t" + i);
        }
    }

    private static void quickSort(int[] input, int start, int end) {
        if (end - start < 1) return;
        int pivotIdx = getPivotIdx(input, start, end);
        quickSort(input, start, pivotIdx - 1);
        quickSort(input, pivotIdx + 1, end);
    }

    private static int getPivotIdx(int[] input, int start, int end) {
        if (end - start < 1) return start;
        int i = start + 1, j = i;
        while (j <= end) {
            if (input[j] <= input[start]) {
                swap(input, i, j);
                i++;
            }
            j++;
        }

        if (i > start + 1) {
            swap(input, start, i - 1);
            return i - 1;
        }

        return start;
    }

    private static void shuffleArray(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int randIdx = (int) Double.doubleToLongBits(Math.random()) % i;
            swap(input, Math.abs(randIdx), i);
        }

    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
