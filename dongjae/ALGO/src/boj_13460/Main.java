package boj_13460;

import java.io.*;
import java.util.*;

class Marbles {
    public int rx;
    public int ry;
    public int bx;
    public int by;
    public int cnt;

    public Marbles(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}

public class Main {
    public static int n, m;
    public static char[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }

                if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        int result = bfs(new Marbles(rx, ry, bx, by, 0));

        System.out.println(result);
    }

    public static int bfs(Marbles start) {
        Queue<Marbles> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Marbles now = q.poll();

            if (now.cnt == 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                boolean isRedHole = false;
                boolean isBlueHole = false;

                int redX = now.rx;
                int redY = now.ry;
                int blueX = now.bx;
                int blueY = now.by;

                while (true) {
                    int newRx = redX + dx[i];
                    int newRy = redY + dy[i];

                    if (map[newRx][newRy] == '#') {
                        break;
                    }

                    if (map[newRx][newRy] == 'O') {
                        isRedHole = true;
                        break;
                    }

                    redX = newRx;
                    redY = newRy;
                }

                while (true) {
                    int newBx = blueX + dx[i];
                    int newBy = blueY + dy[i];

                    if (map[newBx][newBy] == '#') {
                        break;
                    }

                    if (map[newBx][newBy] == 'O') {
                        isBlueHole = true;
                        break;
                    }

                    blueX = newBx;
                    blueY = newBy;
                }

                if (isBlueHole) {
                    continue;
                }

                if (isRedHole && !isBlueHole) {
                    return now.cnt + 1;
                }

                if (redX == blueX && redY == blueY) {
                    if (i == 0) {
                        if (now.rx < now.bx) {
                            blueX++;
                        } else {
                            redX++;
                        }
                    } else if (i == 2) {
                        if (now.rx < now.bx) {
                            redX--;
                        } else {
                            blueX--;
                        }
                    } else if (i == 1) {
                        if (now.ry < now.by) {
                            blueY++;
                        } else {
                            redY++;
                        }
                    } else {
                        if (now.ry < now.by) {
                            redY--;
                        } else {
                            blueY--;
                        }
                    }
                }

                q.offer(new Marbles(redX, redY, blueX, blueY, now.cnt + 1));
            }
        }

        return -1;
    }
}