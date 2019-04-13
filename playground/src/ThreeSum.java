import java.util.HashMap;
import java.util.Map;

public class ThreeSum {
    private static final int[] input = {2, 4, 2, 6, 2};
    private static final int valToCheck = 14;

    public static void main(String[] args) {
        System.out.println("Three Sum Program!!");
        System.out.print("Input Array: ");
        for (int i : input) {
            System.out.print("\t" + i);
        }
        System.out.println();
        System.out.println("Is three sum available for " + valToCheck + " : " + isThreeSum(input, valToCheck));
    }

    private static boolean isThreeSum(int[] arr, int valToCheck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int count = 0;
            if (map.containsKey(i)) {
                count = map.get(i);
            }
            map.put(i, ++count);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isAvailableInMap(map, arr[i], arr[j], valToCheck)) return true;
            }
        }
        return false;
    }

    private static boolean isAvailableInMap(Map<Integer, Integer> map, int val1, int val2, int destVal) {
        int compliment = destVal - (val1 + val2);
        if (compliment == val1 && val1 == val2) {
            return map.containsKey(compliment) && map.get(compliment) > 2;
        } else if (compliment == val1 || compliment == val2) {
            return map.containsKey(compliment) && map.get(compliment) > 1;
        } else {
            return map.containsKey(compliment);
        }
    }
}
