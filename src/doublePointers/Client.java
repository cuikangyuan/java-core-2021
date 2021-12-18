package doublePointers;

import javax.swing.plaf.TextUI;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {


        Client client = new Client();
//        client.basicDoublePointers();;
    }

    private void basicDoublePointers() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (str == null || str.length() == 0) {
            return;
        }

        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int j = i;
            while (j < length && chars[j] != ' ') j++;

            //certain logic
            System.out.println(str.substring(i, j));
            i = j;
        }
    }
}
