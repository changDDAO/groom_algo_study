package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2560 {
    static int n, m, start;
    static List<List<Integer>> graph;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        graph = new ArrayList<>(n + 1); // 0 인덱스는 빈 리스트
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); //graph 초기화 해주기
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);// 그래프는 양방향 그래프이기 때문에
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i)); // 단, 방문할 수 있는 정점이 여러개인 경우 정점번호가 작은거 부터 방문하기 위함
        }
        dfs(start);
        System.out.println(sb.toString());
        Arrays.fill(visited, false);
        sb.setLength(0);// dfs를 수행하면서, visited 배열의 값이 토글되었으므로 bfs 수행 전 초기화
        bfs(start);
        System.out.println(sb.toString());
    }
    static void dfs(int start) {
        visited[start]= true;
        sb.append(start).append(" ");
        for (int i = 0; i < graph.get(start).size(); i++) {
            int nextVertex = graph.get(start).get(i);
            if (!visited[nextVertex]) {
                visited[nextVertex]= true;
                dfs(nextVertex);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        sb.append(start).append(" ");
        visited[start]= true;
        while (!q.isEmpty()) {
            int vertex = q.poll();
            for (int i = 0; i < graph.get(vertex).size(); i++) {
                int nextVertex = graph.get(vertex).get(i);
                if (!visited[nextVertex]) {
                    q.offer(nextVertex);
                    visited[nextVertex]=true;
                    sb.append(nextVertex).append(" ");
                }
            }
        }

    }

}
