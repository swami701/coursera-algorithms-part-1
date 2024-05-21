public class MergeSortV2 {
    public static void main(String[] args) {
        // int[] input = new int[] { 10, 4, 7, 9, 2, 3, 8, 1, 6, 5 };
        int[] input = new int[] { 10, 4, 7, 9, 2};
        int[] result = mergeSort(input, 0, input.length / 2, input.length);
        System.out.println("Mergesort: " + result);
    }

    private static int[] mergeSort(int[] input, int start, int mid, int end) {
        int arr1[] = new int[mid - start];
        if (start < mid) {
            arr1 = mergeSort(input, start, mid - start / 2, mid);
        }
        int[] arr2 = new int[end - (mid + 1)];
        if (mid < end) {
            arr2 = mergeSort(input, mid + 1, end - (mid + 1), end);
        }
        return combine(arr1, arr2);

    }

    private static int[] combine(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }
}
