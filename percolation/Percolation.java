/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class Percolation {
    private int[][] matrix;

    public Percolation(int n) {
        this.matrix = new int[n][n];
    }      // create n-by-n grid, with all sites blocked

    public void open(int row, int col) {

    }   // open site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        return false;

    }  // is site (row, col) open?

    public boolean isFull(int row, int col) {
        return false;
    }  // is site (row, col) full?

    public int numberOfOpenSites() {
        return 0;
    }    // number of open sites

    public boolean percolates() {
        return true;
    }          // does the system percolate?

    private boolean isValid(int row, int col) {
        return row >= 1 && row <= matrix.length && col >= 1 && col < matrix.length;
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);


        System.out.println("Percolations Starts....");
    }   // test client (optional)
}