package boj_1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long num = Long.parseLong(str);
        int [] count = new int[10];

        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'0']++;
        }

        int sixNineCount = (count[6]+count[9] + 1)/2 ;
        int maxCount = 0;

        for(int j=0;j<10;j++){
            if(j == 6 || j == 9)
                continue;
            if(count[j]>maxCount){
                maxCount = count[j];
            }
        }

        maxCount = Math.max(sixNineCount, maxCount);

        System.out.println(maxCount);
    }
}
