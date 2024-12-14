package boj_2212;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static ArrayList<Integer> sensors = new ArrayList<>();
    public static ArrayList<Integer> distances = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensors.add(Integer.parseInt(st.nextToken()));
        }

        if (k >= n) {
            System.out.println(0);
        } else {
            Collections.sort(sensors);

            for (int i = 1; i < sensors.size(); i++) {
                distances.add(sensors.get(i) - sensors.get(i - 1));
            }

            Collections.sort(distances);

            int sum = 0;
            for (int i = 0; i < distances.size() - (k - 1); i++) {
                sum += distances.get(i);
            }

            System.out.println(sum);
        }
    }
}
