package programmers;

import java.util.*;

public class 가장_먼_노드 {

    List<List<Integer>> graph;
    int[] distance;
    boolean[] visited;

    public int solution(int n, int[][] edge) {
        int cnt = 0;
        graph = new ArrayList<>(n + 1);
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        bfs(1);
        Arrays.sort(distance);
        int max = distance[distance.length - 1];
        for (int i = distance.length - 1; i >= 0; i--) {
            if (distance[i] == max)
                cnt++;
            else if (distance[i] < max) break;
        }
        return cnt;
    }

    void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int curNode = q.poll();
            for (int i = 0; i < graph.get(curNode).size(); i++) {
                int node = graph.get(curNode).get(i);
                if (!visited[node]) {
                    visited[node] = true;
                    q.offer(node);
                    distance[node] = distance[curNode] + 1;
                }
            }
        }
    }
}