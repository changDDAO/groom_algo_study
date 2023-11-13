package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek11725{
    static boolean [] visited;
    static int n;
    static List<List<Integer>> graph;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        graph= new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        //graph 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }//노드별로 연관관계설정

        dfs(1);
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]+"\n");
        }
        System.out.println(sb.toString());


    }
    static void dfs(int parentNum) {
        visited[parentNum]=true;
        for (int child: graph.get(parentNum)) {
            if (!visited[child]) {
                parent[child]= parentNum;
                dfs(child);
            }

        }

    }

}

