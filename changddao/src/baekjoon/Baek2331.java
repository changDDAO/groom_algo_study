package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2331 {
    static int a, p;
    static int answer =0;
    static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        numList.add(a);
        calcNext(a,p);
        System.out.println(answer);
    }

    static void calcNext(int prev, int p) {
        while (true) {
            int sum = 0;
            while (prev != 0) {
                int eachNum = prev%10;
                sum += (int) Math.pow(eachNum, p);
                prev/=10;
            }
            if (numList.contains(sum)) {
                answer= numList.indexOf(sum);
                break;
            } else {
                numList.add(sum);
                prev = sum;
            }
        }
    }

}
