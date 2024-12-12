package boj_2818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int top = 1, front = 2, right = 3;
		long sum = 1;

		for (int row = 0; row < R; row++) {
			if (row % 2 == 0) {
				for (int col = 1; col < C; col++) {
					int tmp = top;
					top = 7 - right;
					right = tmp;
					sum += top;
				}
			} else {
				for (int col = C - 2; col >= 0; col--) {
					int tmp = top;
					top = right;
					right = 7 - tmp;
					sum += top;
				}
			}

			if (row < R - 1) {
				int tmp = top;
				top = 7 - front;
				front = tmp;
				sum += top;
			}
		}

		System.out.println(sum);
		br.close();
	}
}
