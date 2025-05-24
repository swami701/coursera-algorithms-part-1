import java.util.LinkedList;
import java.util.Queue;

class Node {
    private static final int R = 26;
    Node[] childNodes = new Node[R];
    Object value;
}

class TrieST {
    private Node root = new Node();

    public void put(String key, Object value) {
        root = put(root, key, value, 0);
    }

    /**
     * put(root, hello, 0, 0)
     * ch = h
     * node = root
     * len = 5
     * root[h] = put(null, hello, 0, 1)
     * ch = e
     * node = null
     * return newNode
     * root
     * 
     * @param node
     * @param key
     * @param value
     * @param digit
     * @return
     */
    private Node put(Node node, String key, Object value, int digit) {
        if (node == null)
            node = new Node();
        if (digit >= key.length()) {
            node.value = value;
            return node;
        }
        char ch = key.charAt(digit);
        node.childNodes[getIndexForAlphabets(ch)] = put(node.childNodes[getIndexForAlphabets(ch)], key, value,
                digit + 1);
        return node;
    }

    public Object get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        if (x.value != null) {
            return x.value;
        }
        return null;
    }

    private Node get(Node node, String key, int digit) {
        if (node == null) {
            return null;
        }
        if (digit >= key.length()) {
            return node;
        }
        return get(node.childNodes[getIndexForAlphabets(key.charAt(digit))], key, digit + 1);
    }

    public Iterable<String> getKeys() {
        Queue<String> queue = new LinkedList<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node node, String prefix, Queue<String> queue) {
        if (node == null) {
            return;
        }
        if (node.value != null) {
            queue.offer(prefix);
        }
        for (int i = 0; i < node.childNodes.length; i++) {
            if (node.childNodes[i] != null) {
                collect(node.childNodes[i], prefix + (char) (i + 97), queue);
            }
        }
    }

    public Iterable<String> getPrefixMatches(String prefix) {
        Node node = get(root, prefix, 0);
        Queue<String> queue = new LinkedList<>();
        collect(node, prefix, queue);
        return queue;
    }

    private int getIndexForAlphabets(char a) {
        return a - 97;
    }
}

public class Trie {
    public static void main(String[] args) {
        TrieST trieST = new TrieST();
        trieST.put("banana", 100);
        trieST.put("batman", 101);
        trieST.put("bathroom", 102);
        trieST.put("catering", 103);
        trieST.put("apple", 104);
        trieST.put("umbrella", 105);

        System.out.println("Keys: " + trieST.getKeys());
        System.out.println("Prefix match bat: " + trieST.getPrefixMatches("bat"));
        System.out.println("Prefix match ba: " + trieST.getPrefixMatches("ba"));
        System.out.println("Prefix match b: " + trieST.getPrefixMatches("b"));
    }
}

/**
 * hello
 * put(root, hello, 0, 0)
 * ch = h
 * root[h] = put(null, hello, 0, 1)
 * ch = e
 * 
 * 
 */