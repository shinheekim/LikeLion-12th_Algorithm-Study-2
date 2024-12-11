package boj_14713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[][] S = new String[N][];
		int[] idx = new int[N];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = st.countTokens();
			S[i] = new String[size];

			for (int j = 0; j < size; j++)
				S[i][j] = st.nextToken();
		}

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			String L = st.nextToken();
			boolean flag = false;

			for (int i = 0; i < N; i++) {
				if (idx[i] < S[i].length && S[i][idx[i]].equals(L)) {
					idx[i]++;
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.println("Impossible");
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (idx[i] < S[i].length) {
				System.out.println("Impossible");
				return;
			}
		}

		System.out.println("Possible");
	}
}
