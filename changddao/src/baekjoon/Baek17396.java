package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek17396 {
    static int n, m;
    static long result;
    static long[] dist;
    static boolean[] visited;
    static int[] visible;
    static List<List<Node>> graph = new ArrayList<>();
   //https://www.acmicpc.net/problem/17396
    public static void main(String[] args) throws IOException {
        //코드 작성전 테스트
       /* PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Long.compare(b.weight,a.weight));
        pq.offer(new Node(1, 10));
        pq.offer(new Node(2, 20));
        //20이 나와야함
        System.out.println(pq.poll().weight);*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            //그래프 초기화
        }
        dist = new long[n];
        visited = new boolean[n];
        visible = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            visible[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        dijkstra(0);

        result = dist[n-1]==Long.MAX_VALUE ? -1: dist[n-1];
        System.out.println(result);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.num]) continue;
            if (visible[current.num] == 1) continue;
            visited[current.num] = true;
            List<Node> nextNodes = graph.get(current.num);
            for (Node next : nextNodes) {
                if (dist[next.num] > dist[current.num] + next.weight) {
                    dist[next.num] = dist[current.num] + next.weight;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

    }

}
class Node {
    int num;
    long weight;


    public Node(int num, long weight) {
        this.num = num;
        this.weight = weight;
    }


}


