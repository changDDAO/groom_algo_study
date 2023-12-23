package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://www.acmicpc.net/problem/1946
public class Baek1946{
    static int tc;
    static int n;
    static List<Applicant> applicants = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());
        for(int t =0; t< tc; t++){
            applicants.clear();
            n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                String[] scores = br.readLine().split(" ");
                applicants.add(new Applicant(Integer.parseInt(scores[0]), Integer.parseInt(scores[1])));
            }
            Collections.sort(applicants);
            int passCount = 1; //첫번 째 합격자는 무조건 합격
            int compareRank = applicants.get(0).rRank;
            for (int i = 1; i < n; i++) {
                int targetRank = applicants.get(i).rRank;
                if (targetRank < compareRank) { // 이전지원자 보다 면접 순위는 더 높은 순위라면
                    compareRank = targetRank;
                    passCount++;
                }
            }
            sb.append(passCount).append("\n");
        }
        System.out.println(sb.toString());
    }
    static class Applicant implements Comparable<Applicant>{
        private int lRank;// 서류성적 순
        private int rRank; // 인터뷰 성적 순

        Applicant(int l, int r) {
            this.lRank = l;
            this.rRank = r;
        }
        @Override
        public int compareTo(Applicant o) {
            return this.lRank - o.lRank;
        }
    }
}
