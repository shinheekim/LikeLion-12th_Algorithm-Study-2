package boj_28078;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		Deque<String> q = new ArrayDeque<>();
		int dir = 0, ball = 0, wall = 0;
		int Q = Integer.parseInt(br.readLine());

		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();

			switch (op) {
				case "push": {
					String val = st.nextToken();
					if (val.equals("w")) {
						q.offerLast(val);
						wall++;
					} else if (dir == 1) {
						if (!q.isEmpty() && q.peekFirst().equals("w")) {
							q.offerLast(val);
							ball++;
						}
					} else if (dir == 0 || dir == 2) {
						q.offerLast(val);
						ball++;
					}
					break;
				}
				case "pop": {
					if (!q.isEmpty()) {
						if (q.pollFirst().equals("w")) {
							wall--;
						} else {
							ball--;
						}
					}

					if (dir == 1) {
						while (!q.isEmpty() && q.peekFirst().equals("b")) {
							q.pollFirst();
							ball--;
						}
					}
					break;
				}
				case "rotate": {
					String val = st.nextToken();
					dir = val.equals("l") ? (dir + 3) % 4 : (dir + 1) % 4;

					if (dir == 1) {
						while (!q.isEmpty() && q.peekFirst().equals("b")) {
							q.pollFirst();
							ball--;
						}
					} else if (dir == 3) {
						while (!q.isEmpty() && q.peekLast().equals("b")) {
							q.pollLast();
							ball--;
						}
					}
					break;
				}
				case "count": {
					String val = st.nextToken();
					sb.append(val.equals("b") ? ball : wall).append('\n');
					break;
				}
			}
		}

		System.out.println(sb);
		br.close();
	}
}
