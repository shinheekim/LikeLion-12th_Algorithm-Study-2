package boj_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {-1, 0, 0, 1};
	private static final int[] dy = {0, -1, 1, 0};
	private static int[][] arr;
	private static int N, shark = 2, eat = 0, time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int startX = 0, startY = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 9) {
					startX = i;
					startY = j;
					arr[i][j] = 0;
				}
			}
		}

		bfs(startX, startY);
		br.close();
	}

	private static void bfs(int startX, int startY) {
		while (true) {
			PriorityQueue<int[]> pq = new PriorityQueue<>(
				Comparator.comparingInt((int[] o) -> o[2])
					.thenComparing(o -> o[0])
					.thenComparing(o -> o[1])
			);

			boolean[][] visited = new boolean[N][N];
			pq.offer(new int[] {startX, startY, 0});
			visited[startX][startY] = true;
			boolean flag = false;

			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int x = cur[0], y = cur[1], dist = cur[2];

				if (arr[x][y] > 0 && arr[x][y] < shark) {
					arr[x][y] = 0;
					time += dist;
					startX = x;
					startY = y;

					if (++eat == shark) {
						shark++;
						eat = 0;
					}

					flag = true;
					break;
				}

				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] <= shark) {
						pq.offer(new int[] {nx, ny, dist + 1});
						visited[nx][ny] = true;
					}
				}
			}

			if (!flag) break;
		}

		System.out.println(time);
	}
}
