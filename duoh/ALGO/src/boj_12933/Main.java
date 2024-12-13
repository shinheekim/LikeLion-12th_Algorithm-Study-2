package boj_12933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final char[] DUCK = {'q', 'u', 'a', 'c', 'k'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] ch = br.readLine().toCharArray();
		boolean[] used = new boolean[ch.length];

		if (ch.length % 5 != 0) {
			System.out.println(-1);
			return;
		}

		int count = 0;
		while (true) {
			boolean flag = false;
			int j = 0;

			for (int i = 0; i < ch.length; i++) {
				if (!used[i] && ch[i] == DUCK[j]) {
					used[i] = true;
					j++;

					if (j == DUCK.length) {
						flag = true;
						j = 0;
					}
				}
			}

			if (!flag) break;
			count++;
		}

		for (boolean u : used) {
			if (!u) {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(count);
		br.close();
	}
}
