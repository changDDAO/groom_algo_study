package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1940 {
    //첫 번째 dfs를 이용하여 문제를 풀이함. 하지만 효율성 측면에서 좋지못함.
  /*  static int n, target;
    static int[] parts;
    static int [] selectedNums = new int[2];
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        parts = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            parts[i]= Integer.parseInt(st.nextToken());
        }
    dfs(0,0);
        System.out.println(result);

    }
    static void dfs(int index, int depth) {
        if (depth == 2) {
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum+=selectedNums[i];
            }
            if (sum == target) {
                result++;
                return;
            }
            return;
        }
        for (int i = index; i < n; i++) {
           selectedNums[depth]=parts[i];
            dfs(index+1, depth+1);
          }
    }*/

    //2번째 방식 BinarySearch의 원리를 이용하여 문제를 풀이함
    static int n, target;
    static int[] parts;
    static int answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parts = new int[n];
        target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            parts[i] = Integer.parseInt(st.nextToken());
        }
        biSearch();
        System.out.println(answer);

    }
    static void biSearch() {
        Arrays.sort(parts);
        int start = 0;
        int end = n-1;
        while (start < end) {
            int sum = parts[start] + parts[end];
            if (sum < target) start++;
            else if (sum == target) {
                answer++;
                start++;
                end--;
            } else{
                end--;
            }
        }
    }

}
