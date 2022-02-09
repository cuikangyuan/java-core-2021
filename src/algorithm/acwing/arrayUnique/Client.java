package algorithm.acwing.arrayUnique;

public class Client {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 5, 5, 6, 7};
        Client client = new Client();
        int unique = client.unique(a);
    
        System.out.println(unique);

        for(int i = 0; i < unique; i++) {
            System.out.print(a[i] + " ");
        }
    }

    //return the number of unique element int certain array
    private int unique(int[] a) {
        int aL = a.length;
        int j = 0;
        for(int i = 0; i < aL; i++) {
            if(i <= 0 || a[i] != a[i-1]) {
                a[j++] = a[i];
            }
        }

        return j;
    }
}