public class LSD {
    public static void main(String[] args) {
        String[] input = { "hel", "wor", "bcd", "abc", "cef" };
        int R = 256;
        String[] aux = new String[input.length];
        int W = 3;
        for (int w = W - 1; w >= 0; w--) {
            int[] count = new int[R + 1];
            for (String str : input) {
                count[str.charAt(w) + 1]++;
            }
            for (int i = 0; i < R; i++) {
                count[i + 1] += count[i];
            }
            for (String str : input) {
                aux[count[str.charAt(w)]++] = str;
            }
            System.out.println("Aux: ");
            for (String idx : aux) {
                System.out.print(" " + idx);
            }
            System.out.println();
        }
    }
}
