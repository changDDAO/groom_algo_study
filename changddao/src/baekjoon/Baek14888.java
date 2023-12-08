package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14888 {
    static int n;
    static int [] nums;
    static int []calcList = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    //https://www.acmicpc.net/problem/14888
    public static void main(String[] args) throws IOException {
    //모든 경우를 탐색
        // 여러식중 가장 큰값과 가장 작은값을 출력
         // 앞에서부터 순서대로 연산 진행
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calcList[i] = Integer.parseInt(st.nextToken());
        }
        //처음부터
        dfs(nums[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }
    static void dfs(int num, int depth) {
        if (depth == n) {
          MAX =  Math.max(num, MAX);
            MIN = Math.min(num, MIN);
        }

        for (int i = 0; i < 4; i++) {
            if (calcList[i] >0) {
                calcList[i]--;

                if (i == 0) dfs(num+nums[depth], depth+1);
                if (i == 1) dfs(num-nums[depth], depth+1);
                if (i == 2) dfs(num*nums[depth], depth+1);
                if (i == 3) dfs(num/nums[depth], depth+1);
                calcList[i]++;
            }
        }

    }
}
