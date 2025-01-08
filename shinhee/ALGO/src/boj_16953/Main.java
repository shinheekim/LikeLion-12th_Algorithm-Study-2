package ALGO.src.boj_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long current = queue.poll();

                if (current == B) {
                    return count + 1;
                }

                if (current * 2 <= B) {
                    queue.add(current * 2);
                }

                if (current * 10 + 1 <= B) {
                    queue.add(current * 10 + 1);
                }
            }
            count++;
        }
        return -1;
    }
}
