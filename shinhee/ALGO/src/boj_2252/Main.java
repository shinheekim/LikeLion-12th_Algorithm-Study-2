package ALGO.src.boj_2252;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edge = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");
            graph.get(Integer.parseInt(arr[0])).add(Integer.parseInt(arr[1]));
            edge[Integer.parseInt(arr[1])]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 값 큐에 넣기
        for (int i = 1; i < edge.length; i++) {
            if (edge[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int studentNo = q.poll();
            System.out.println(studentNo + " ");

            List<Integer> list = graph.get(studentNo);

            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                edge[temp]--;
                if (edge[temp] == 0) {
                    q.offer(temp);
                }
            }
        }
    }
}
