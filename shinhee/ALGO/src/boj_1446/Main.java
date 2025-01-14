package ALGO.src.boj_1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, D, result;
    static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 지름길 개수(12 이하)
        D = Integer.parseInt(st.nextToken());   // 고속도로 길이(만 이하)

        input = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 지름길 시작위치, 도착위치, 지름길 길이
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }

        result = D;
        for (int i = 0; i < N; i++) {
            if (input[i][0] <= D) {
                dfs(input[i][0], input[i][0]);
            }
        }
        System.out.println(result);
    }

    private static void dfs(int sum, int road) {
        if (road == D) {
            result = Math.min(sum, result);
        }
        if (road >= D)
            return;
        for (int i = 0; i < N; i++) {
            dfs(sum + D - road, D);
            if (input[i][0] >= road) {
                dfs(sum + input[i][2] + input[i][0] - road, input[i][1]);
            }
        }
    }
}
