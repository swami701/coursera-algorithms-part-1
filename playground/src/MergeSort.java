public class MergeSort {
    private static final int[] input = {7, 3, 4, 5, 1};

    public static void main(String[] args) {
        System.out.println("Merge sort!!");
        System.out.print("Input Array: ");
        for (int i : input) {
            System.out.print("\t" + i);
        }
        System.out.println();
        int[] sortedArray = mergeSort(input, 0, input.length - 1);
        System.out.print("Sorted Array: ");
        for (int i : sortedArray) {
            System.out.print("\t" + i);
        }
    }

    private static int[] mergeSort(int[] input, int first, int last) {
        if (last - first < 0) {
            return new int[]{};
        }
        if (last - first == 0) {
            return new int[]{input[first]};
        }
        int mid = (first + last) / 2;
        int[] left = mergeSort(input, first, mid);
        int[] right = mergeSort(input, mid + 1, last);
        return mergeTwoSortedArrays(left, right);
    }

    private static int[] mergeTwoSortedArrays(int[] first, int[] second) {
        int[] auxArr = new int[first.length + second.length];
        for (int i = 0, j = 0, k = 0; k < auxArr.length; k++) {
            if (i >= first.length) {
                auxArr[k] = second[j++];
            } else if (j >= second.length) {
                auxArr[k] = first[i++];
            } else if (first[i] < second[j]) {
                auxArr[k] = first[i++];
            } else {
                auxArr[k] = second[j++];
            }
        }
        return auxArr;
    }
}
