package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2512 {
    static int n, m;
    static int optimizedBudget;
    static int [] requestedBudget;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        requestedBudget = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            requestedBudget[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        Arrays.sort(requestedBudget);
        biSearch();
        System.out.println(optimizedBudget);
    }
    static void biSearch() {
        int start = 0;
        int end = requestedBudget[n-1];
        while (start <= end) {
            int mid = (start+end)/2; //상한액
            int sum=0;
            for (int i = 0; i < n; i++) {
                if(requestedBudget[i]>mid)
                    sum+=mid;
                else sum+=requestedBudget[i];
            }
            if(sum>m) end = mid -1;
            else {
                start = mid+1;
                optimizedBudget = mid;
            }
        }
    }
}
