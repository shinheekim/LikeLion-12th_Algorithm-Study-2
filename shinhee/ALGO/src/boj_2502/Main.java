package ALGO.src.boj_2502;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[n];

        for(int i = 1; i <= m/2; i++) {
            for(int j = i+1; j < m; j++) {
                dp[0] = i;
                dp[1] = j;
                for(int k = 2; k < n; k++) {
                    dp[k] = dp[k-1] + dp[k-2];
                }
                if(dp[n-1] == m) {
                    System.out.println(dp[0]);
                    System.out.println(dp[1]);
                    System.exit(0);
                }
            }
        }
    }
}
