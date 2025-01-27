package ALGO.src.boj_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static Integer[][] arr = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            dp(N);
            sb.append(arr[N][0] + " " + arr[N][1]).append('\n');
        }
        System.out.println(sb);
    }

    static Integer[] dp(int N) {
        if(arr[N][0] == null || arr[N][1] == null) {
            arr[N][0] = dp(N - 1)[0] + dp(N - 2)[0];
            arr[N][1] = dp(N - 1)[1] + dp(N - 2)[1];
        }
        return arr[N];

    }

}
