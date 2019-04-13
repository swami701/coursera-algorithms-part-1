/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] matrix;
    private int openSites;
    private WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int n) {
        if (n == 0) {
            // throw java.lang.IllegalArgumentException;
            return;
        }
        this.matrix = new int[n][n];
        initialiseMatrix();
        this.openSites = 0;
    }      // create n-by-n grid, with all sites blocked

    private void initialiseMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public int numberOfOpenSites() {
        return openSites;
    }    // number of open sites

    private int getNodeIdxForRowColumn(int row, int col) {
        if (!isValid(row, col)) return -1;
        return row * matrix.length - (matrix.length - col) - 1;
    }

    private boolean isValid(int row, int col) {
        return row >= 1 && row <= matrix.length && col >= 1 && col <= matrix.length;
    }

    public void open(int row, int col) {
        if (!isValid()) return;
        if (isOpen(row, col)) return;


        int nodeIdx = getNodeIdxForRowColumn(row, col);

    }   // open site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        // if (!isValid(row, col)) return java.lang.IllegalArgumentException;
        return matrix[row - 1][col - 1] == 1;

    }  // is site (row, col) open?

    public boolean isFull(int row, int col) {
        return false;
    }  // is site (row, col) full?

    public boolean percolates() {
        return true;
    }          // does the system percolate?

    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);

        System.out.println("Percolations Starts....");
        System.out.println("Number of opensites: " + percolation.numberOfOpenSites());
        System.out.println("GetNodeIdx: " + percolation.getNodeIdxForRowColumn(3, 1));
    }   // test client (optional)
}
