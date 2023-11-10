package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/7568 문제출처
public class Baek7568 {
    static int n;
    static int [][]  hw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        hw = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            hw[i][0] = Integer.parseInt(temp[0]);
            hw[i][1] = Integer.parseInt(temp[1]);
        }
        //완전탐색하면서 순서 매기기
        for (int i = 0; i < n; i++) {
            int order = 1;
            for (int j = 0; j < n; j++) {
                if(i==j) continue;
                if (hw[i][0] < hw[j][0] && hw[i][1] < hw[j][1]) {
                    order++;
                }
            }
            sb.append(order).append(" ");
        }
        System.out.println(sb.toString());
    }
}
