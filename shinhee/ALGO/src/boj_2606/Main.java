package ALGO.src.boj_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int map[][];
    static boolean visit[];
    static int N, M, V;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        V = 1;

        map = new int[N +1][N +1];
        visit = new boolean[N +1];

        for(int i = 0; i< M; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            map[a][b] = map[b][a]= 1;
        }

        System.out.println(dfs(1));
    }


    public static int dfs(int i) {
        visit[i] = true;

        for(int j = 1; j<= N; j++) {
            if(map[i][j] == 1 && !visit[j]) {
                count ++;
                dfs(j);
            }
        }
        return count;
    }
}
