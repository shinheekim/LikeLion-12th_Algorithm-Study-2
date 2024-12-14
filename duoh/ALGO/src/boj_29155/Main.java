package boj_29155;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 5;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] P = new int[SIZE];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < SIZE; i++)
			P[i] = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {k, t});
		}

		int time = 0;
		for (int i = 0; i < SIZE; i++) {

			int prev = 0;
			while (P[i] > 0 && !pq.isEmpty()) {
				int[] cur = pq.poll();

				if (cur[0] != i + 1) continue;
				if (prev > 0)
					time += cur[1] - prev;

				time += cur[1];
				prev = cur[1];
				P[i]--;
			}
			time += 60;
		}

		System.out.println(time - 60);
		br.close();
	}
}
