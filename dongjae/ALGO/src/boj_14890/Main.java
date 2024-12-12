package boj_14890;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, l;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (checkRow(i)) count += 1;
            if (checkCol(i)) count += 1;
        }

        System.out.println(count);
    }

    public static boolean checkRow(int r) {
        boolean[] rampArr = new boolean[n];
        for (int i = 0; i < (n - 1); i++) {
            int diff = map[r][i + 1] - map[r][i];
            if (diff == 1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0) return false;
                    else if (rampArr[i - j]) return false;
                    else if (map[r][i] != map[r][i - j]) return false;
                }
                for (int j = 0; j < l; j++) {
                    rampArr[i - j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i + j + 1 >= n) return false;
                    else if (rampArr[i + j + 1]) return false;
                    else if (map[r][i + 1] != map[r][i + j + 1]) return false;
                }
                for (int j = 0; j < l; j++) {
                    rampArr[i + j + 1] = true;
                }
            } else if (Math.abs(diff) > 1) return false;
        }
        return true;
    }

    public static boolean checkCol(int c) {
        boolean[] rampArr = new boolean[n];
        for (int i = 0; i < (n - 1); i++) {
            int diff = map[i + 1][c] - map[i][c];
            if (diff == 1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0) return false;
                    else if (rampArr[i - j]) return false;
                    else if (map[i][c] != map[i - j][c]) return false;
                }
                for (int j = 0; j < l; j++) {
                    rampArr[i - j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i + j + 1 >= n) return false;
                    else if (rampArr[i + j + 1]) return false;
                    else if (map[i + 1][c] != map[i + 1 + j][c]) return false;
                }
                for (int j = 0; j < l; j++) {
                    rampArr[i + j + 1] = true;
                }
            } else if (Math.abs(diff) > 1) return false;
        }
        return true;
    }
}

