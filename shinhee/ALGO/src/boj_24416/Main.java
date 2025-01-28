package ALGO.src.boj_24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int dp[];
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        StringBuilder sb = new StringBuilder();

        fib(N);
        sb.append(cnt).append(" ");

        cnt = 0;
        fibo(N);
        sb.append(cnt);

        System.out.println(sb);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibo(int n) {
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            cnt++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
