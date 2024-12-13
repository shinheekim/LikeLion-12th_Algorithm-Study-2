package boj_1783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        long N = Long.parseLong(nm[0]);
        long M = Long.parseLong(nm[1]);

        long result;

        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) {
                result = Math.min(4, M);
            } else {
                result = M - 2;
            }
        }

        System.out.println(result);
    }
}
