package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12865 {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 물품의 수
        k = Integer.parseInt(st.nextToken()); //버틸수 있는 무게

        int[] dp = new int[k + 1];
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = k; j - weight[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[k]);


    }
}
