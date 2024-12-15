package boj_1437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static final int MOD = 10_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> list = new ArrayDeque<>();

		while (N > 4) {
			N -= 3;
			list.offer(3);
		}
		list.offer(N);

		int ans = 1;
		while (!list.isEmpty()) {
			ans *= list.poll();
			ans %= MOD;
		}

		System.out.println(ans);
		br.close();
	}
}
