public class MergeSortV2 {
    public static void main(String[] args) {
        int[] input = { 1, 2, 7, 9, 11, 3, 4, 5, 6, 8, 10 };
        // int[] input = { 1, 7, 2, 10, 9 };
        // int[] input = { 2, 7, 1, 10, 3 };
        System.out.println("Input");
        print(input);
        mergeSort(input);
        System.out.println("Result: ");
        print(input);
    }

    private static void print(int[] result) {
        for (int i : result) {
            System.out.print("\t" + i);
        }
        System.out.println();
    }

    private static int[] mergeSort(int[] input) {
        int[] aux = new int[input.length];
        sort(input, 0, input.length - 1, aux);
        return input;
    }

    private static void sort(int[] input, int strt, int end, int[] aux) {
        if (strt >= end) {
            return;
        }
        int mid = (strt + end) / 2;
        sort(input, strt, mid, aux);
        sort(input, mid+1, end, aux);
        merge(input, aux, strt, mid, end);
    }  
    
    private static void merge(int[] input, int[] aux, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            aux[i] = input[i];
        }
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                input[k] = aux[j++];
            } else if (j > end) {
                input[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                input[k] = aux[j++];
            } else {
                input[k] = aux[i++];
            }
        }
    }
}

/**
 * 1 7 2 10 9
 * 0 1 2 3 4
 * start = 0
 * end = 4
 * mid = 2
 * start = 0
 * end = 2
 * mid = 1
 * start = 0
 * end = 1
 * mid = 0
 * start = 0
 * end = 0
 * mid = 0
 * return
 * start = 1
 * end = 1
 * mid = 1
 * return
 * [1, 7, 0, 0, 0]
 * start = 1
 * end = 2
 * mid = 1
 * start = 1
 * end = 1
 * mid = 1
 * return
 * start = 2
 * end = 2
 * mid = 2
 * return
 * [1, 2, 7, 0, 0]
 * start = 3
 * end = 4
 * mid = 3
 * start = 3
 * end = 3
 * mid = 3
 * return
 * 
 * start = 4
 * end = 4
 * mid = 4
 * return
 * [1, 2, 7, 9, 10]
 * 
 * 
 * 1 7 2 10 9
 * 0 1 2  3 4
 * 1 7 2
 * 0 1 2
 *    1 7
 *    0 1
 *       0
 *       0
 *     2
 *     2
 *    
 * 
 * 
 */