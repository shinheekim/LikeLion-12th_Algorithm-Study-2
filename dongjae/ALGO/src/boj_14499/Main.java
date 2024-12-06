package boj_14499;

import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k;
    public static int x, y;
    public static int[][] map = new int[20][20];
    public static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    public static int[] dx = {0, 0,-1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < k; i++) {
            int result = roll(Integer.parseInt(st.nextToken()));
            if (result != -1) {
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int roll(int dir) {
        int nx = x + dx[dir-1];
        int ny = y + dy[dir-1];
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            if (dir == 1) {
                int tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
            } else if (dir == 2) {
                int tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
            } else if (dir == 3) {
                int tmp = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = dice[1];
                dice[1] = tmp;
            } else {
                int tmp = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = dice[1];
                dice[1] = tmp;
            }

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;
            return dice[1];
        } else {
            return -1;
        }
    }
}
