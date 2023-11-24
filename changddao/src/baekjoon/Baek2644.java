package baekjoon;

import java.io.*;
import java.util.*;

public class Baek2644 {
    static int n, m;
    static int start, end;
    static int [] distance;
    static boolean [] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        distance = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        bfs(start);
        if(distance[end]!=0)
            System.out.println(distance[end]);
        else System.out.println(-1);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i<graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if (!visited[next]) {
                    visited[next]=true;
                    q.offer(next);
                    distance[next]= distance[current]+1;
                }
            }
        }
    }
}
