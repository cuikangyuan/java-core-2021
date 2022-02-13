package algorithm.acwing.ch2_data_structure.trie;


public class Client {

    public static void main(String[] args) {
        Trie trie = new Trie();
        char[] abc = new char[]{'a', 'b', 'c'};
        char[] abd = new char[]{'a', 'b', 'd'};
        char[] ab = new char[]{'a', 'b'};

        trie.insert(abc);
        System.out.println("abc = " + trie.query(abc));
        System.out.println("ab = " + trie.query(ab));
        System.out.println("abd = " + trie.query(abd));

        System.out.println("=====================");

        trie.insert(abd);
        trie.insert(ab);
        trie.insert(abc);
        System.out.println("abc = " + trie.query(abc));
        System.out.println("ab = " + trie.query(ab));
        System.out.println("abd = " + trie.query(abd));

    }
}
