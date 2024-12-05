package boj_14500;

import java.util.*;
import java.io.*;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    public static int n, m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int max = Integer.MIN_VALUE;
    public static int sum = 0;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                sum = map[i][j];
                dfs(1, new Node(i, j));
                sum -= map[i][j];
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void dfs(int depth, Node node) {
        if (depth == 4) {
            max = Math.max(sum, max);
            return;
        }

        int x = node.getX();
        int y = node.getY();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny]) {
                    if (depth == 2) {
                        visited[nx][ny] = true;
                        sum += map[nx][ny];
                        dfs(depth + 1, new Node(x, y));
                        sum -= map[nx][ny];
                        visited[nx][ny] = false;
                    }
                    visited[nx][ny] = true;
                    sum += map[nx][ny];
                    dfs(depth + 1, new Node(nx, ny));
                    sum -= map[nx][ny];
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
