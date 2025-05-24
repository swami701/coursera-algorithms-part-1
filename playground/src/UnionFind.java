class UnionFindHelper {
    private int[] graphArray = new int[10];
    private int[] sizeArray = new int[10];

    public UnionFindHelper() {
        for(int i = 0; i < graphArray.length; i++) {
            graphArray[i] = i;
            sizeArray[i] = 1;
        }
    }
    
    public void connect(int idx1, int idx2) {
        int root1 = getRoot(idx1);
        int root2 = getRoot(idx2);
        if (sizeArray[root1] < sizeArray[root2]) {
            graphArray[root1] = root2;
            sizeArray[root1] += sizeArray[root2];
        } else {
            graphArray[root2] = root1;
            sizeArray[root2] += sizeArray[root1];
        }
    }
    private int getRoot(int idx) {
        int root = idx;
        while (root != graphArray[idx]) {
            root = graphArray[idx];
        }
        return root;
    }
    public boolean isConnected(int idx1, int idx2) {
        return getRoot(idx1) == getRoot(idx2);
    }
}

public class UnionFind {
    public static void main(String args[]) {
        System.out.println("Hello world!");
        UnionFindHelper uf = new UnionFindHelper();
        uf.connect(1, 2);
        uf.connect(3, 4);
        uf.connect(5, 2);
        System.out.println("isConnected - 5, 1: " + uf.isConnected(5,1));
        System.out.println("isConnected - 4, 1: " + uf.isConnected(4,1));
    }
}
