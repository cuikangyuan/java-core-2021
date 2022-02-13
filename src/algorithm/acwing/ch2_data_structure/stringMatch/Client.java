package algorithm.acwing.ch2_data_structure.stringMatch;

public class Client {

    public static void main(String[] args) {
        char[] p = {'a', 'b'};
        char[] s = {'a', 'b', 'a', 'b', 'a', 'b'};

        BF bm = new BF();
        KMP kmp = new KMP();

//        bm.find(s, p);
        int m = 5;
        int n = 2;
        p = new char[]{' ', 'a', 'b'};
        s = new char[]{' ', 'a', 'b', 'a', 'b', 'a'};

        kmp.find(s, m , p, n);
    }

}
