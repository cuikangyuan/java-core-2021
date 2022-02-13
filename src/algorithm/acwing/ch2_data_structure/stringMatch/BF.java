package algorithm.acwing.ch2_data_structure.stringMatch;

public class BF {

    public void find(char[] s, char[] p) {
        int sLength = s.length;
        int pLength = p.length;

        int i = 0;
        int j = 0;
        while (i < sLength) {
            while (j < pLength && i < sLength) {
                if (s[i] != p[j]) {
                    i = i - j + 1;
                    j = 0;
                    break;
                } else {
                    i++;
                    j++;
                }
            }
            if (j >= pLength) {
                j = 0;
                System.out.print(i - pLength + " ");
            }
        }
    }
}
