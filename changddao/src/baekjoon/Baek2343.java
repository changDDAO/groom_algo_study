package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2343 {
    static int n, m;
    static int [] videos;
    static int shortTime, longTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        videos = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            longTime+=videos[i];
            shortTime = Math.max(shortTime, videos[i]);
        }
        System.out.println(biSearch(shortTime,longTime));
    }
    static int biSearch(int shortTime, int longTime) {
        while(shortTime<=longTime) {
            int mid = (shortTime + longTime) / 2;
            int count = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum+=videos[i];
                if (sum > mid) {
                    count++;
                    sum = videos[i];
                }
            }
            if (count <= m) {
                longTime = mid-1;
            }else{
                shortTime = mid+1;
            }
        }
        return shortTime;
    }
}
