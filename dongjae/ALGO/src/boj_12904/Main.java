package boj_12904;

import java.io.*;

public class Main {
    public static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        StringBuilder sb = new StringBuilder(t);
        while (sb.length() > s.length()) {
            int lastIndex = sb.length() - 1;

            if (sb.charAt(lastIndex) == 'A') {
                sb.deleteCharAt(lastIndex);
            } else {
                sb.deleteCharAt(lastIndex);
                sb.reverse();
            }
        }

        if (sb.toString().equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
