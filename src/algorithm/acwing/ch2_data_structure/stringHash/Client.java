package algorithm.acwing.ch2_data_structure.stringHash;


//841.字符串哈希方式-字符串前缀哈希法
public class Client {

    private static final int P = 131;//or 13331
    private static final double Q = Math.pow(2, 64);

    private String string;
    private char[] chars;
    private long[] p;
    private long[] h;

    public Client() {
        string = "aabbaabb";
        chars = string.toCharArray();
        int length = chars.length;

        p = new long[length + 1];
        p[0] = 1;
        h = new long[length + 1];
        for(int i = 0; i < length; i++) {
            p[i+1] = P * p[i];
            h[i+1] = h[i] * P + chars[i];
        }
    
    }

    public long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }


    public void subStringEquals(int l1, int r1, int l2, int r2) {
        long h1 = get(l1, r1);
        long h2 = get(l2, r2);
        if(h1 == h2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
    
        Client client = new Client();
        client.subStringEquals(1, 3, 5, 7);
        client.subStringEquals(1, 3, 6, 8);
        client.subStringEquals(1, 2, 1, 2);
    }
}
