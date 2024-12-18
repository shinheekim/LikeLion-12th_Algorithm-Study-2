package ALGO.src.boj_1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N - 1; i > 0; i--) {
            int a = 0;
            if (arr[i] <= arr[i - 1]) {
                a = arr[i - 1] - arr[i] + 1;
                arr[i - 1] -= a;
                count += a;
            }
        }
        System.out.println(count);
    }
}
