package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1032 {
    static String [] files;
    static int fileLen;
    static boolean check = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        files = new String[n];
        for (int i = 0; i < n; i++) {
            files[i] = br.readLine();
        }
        fileLen = files[0].length();
        for (int i = 0; i < fileLen; i++) {
            check = true;
            char target = files[0].charAt(i);
            for (int j = 1; j < n; j++) {
                char compTarget = files[j].charAt(i);
                if (target != compTarget) {
                    check = false;
                    break;
                }
            }
            if (check) {
                sb.append(target);
            } else {
                sb.append("?");
            }
        }
        System.out.println(sb.toString());

    }
}
