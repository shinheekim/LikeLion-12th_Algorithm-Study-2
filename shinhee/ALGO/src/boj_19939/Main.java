package ALGO.src.boj_19939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int ball = (N - ((K * (K + 1)) / 2));

        if (ball < 0) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (ball / K);
            N -= (ball / K);
        }
        if (N == ((K * (K + 1)) / 2)) {
            System.out.println(K - 1);
        } else {
            System.out.println(K);
        }
    }
}
