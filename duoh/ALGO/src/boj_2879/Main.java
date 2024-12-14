package boj_2879;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] diff = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			diff[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			diff[i] -= Integer.parseInt(st.nextToken());

		int count = 0;
		while (true) {
			boolean flag = false;

			for (int i = 0; i < N; i++) {
				if (diff[i] == 0) continue;

				flag = true;
				int v = diff[i], j = i;

				while (j < N && diff[i] * diff[j] > 0) {
					if (Math.abs(diff[j]) < Math.abs(v))
						v = diff[j];
					j++;
				}

				for (int k = i; k < j; k++)
					diff[k] -= v;

				count += Math.abs(v);
				i = j - 1;
			}

			if (!flag) break;
		}

		System.out.println(count);
		br.close();
	}
}
