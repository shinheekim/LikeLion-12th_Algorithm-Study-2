package boj_1700;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static ArrayList<Integer> array = new ArrayList<>();
    public static int[] holes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        holes = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            array.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;

        for (int i = 0; i < k; i++) {
            int now = array.get(i);
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (holes[j] == now) {
                    flag = true;
                    break;
                } else if (holes[j] == 0) {
                    holes[j] = now;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                int mostFarIdx = -1;
                int changeIdx = -1;

                for (int j = 0; j < n; j++) {
                    int nextUse = Integer.MAX_VALUE;
                    for (int l = i + 1; l < k; l++) {
                        if (holes[j] == array.get(l)) {
                            nextUse = l;
                            break;
                        }
                    }

                    if (nextUse > mostFarIdx) {
                        mostFarIdx = nextUse;
                        changeIdx = j;
                    }
                }

                holes[changeIdx] = now;
                answer++;
            }
        }

        System.out.println(answer);
    }
}