package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1541 {
    static int sum;

    public static void main(String[] args) throws IOException {
        //-를 기준으로 나누자!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                sb.append(s.charAt(i));
            } else {//-라면
                String temp = sb.toString();
                sb.setLength(0);
                int sum = Arrays.stream(temp.split("[+]"))
                        .mapToInt(Integer::parseInt).sum();
                nums.add(sum);
            }
        }
        if (!sb.isEmpty()) {
            String last = sb.toString();
            int lastNum = Arrays.stream(last.split("[+]")).mapToInt(Integer::parseInt)
                    .sum();
            nums.add(lastNum);
        }


        int answer =nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            answer-=nums.get(i);
        }
        System.out.println(answer);

    }


}

