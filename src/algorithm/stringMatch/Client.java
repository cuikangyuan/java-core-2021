package algorithm.stringMatch;

public class Client {

    public static void main(String[] args) {
        char[] p = {'a', 'b'};
        char[] s = {'a', 'b', 'a', 'b', 'a', 'b'};

        BF bm = new BF();
        KMP kmp = new KMP();

//        bm.find(s, p);
        int m = 6;
        int n = 2;
        p = new char[]{' ', 'a', 'b'};
        s = new char[]{' ', 'a', 'b', 'a', 'b', 'a', 'b'};

        kmp.find(s, m , p, n);
    }

}
