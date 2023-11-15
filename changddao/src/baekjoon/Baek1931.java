package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baek1931 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> meetings = new ArrayList<int[]>();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String [] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            meetings.add(new int[]{start, end});
        }
        Collections.sort(meetings,(a,b)->{
            if(a[1]==b[1])
                return a[0]-b[0];
            return a[1]-b[1];
        });
        int result = 0;
        int prevEnd = 0;
        for (int i = 0; i < n; i++) {
            if(prevEnd<=meetings.get(i)[0]){
                result++;
                prevEnd = meetings.get(i)[1];
            }
        }
        System.out.println(result);
    }
}
