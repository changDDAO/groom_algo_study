package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2252 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] inDegree;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }// graph 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            graph.get(prev).add(next);
            inDegree[next]++;
        }
        topologySort(inDegree);
        System.out.println(sb.toString());

    }
    static void topologySort(int [] degree) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
            while (!q.isEmpty()) {
                int high = q.poll();
                sb.append(high).append(" ");
                for (int i = 0; i < graph.get(high).size(); i++) {
                    int less = graph.get(high).get(i);
                    degree[less]--;
                    if (degree[less] == 0) {
                        q.offer(less);
                    }
                }
            }
    }
}
