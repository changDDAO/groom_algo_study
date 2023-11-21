package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2583 {
    static int m, n, k;
    static int[][] canGo = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int [][] map;
    static List<Integer> sectionSizes = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());//y
        n = Integer.parseInt(st.nextToken());//x
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        for (int i = 0; i < k; i++) { //색깔 칠하기
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x]=1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==0)
                    bfs(i, j);
            }
        }
        //영역의 크기를 오름차순 정렬하기 위함
        Collections.sort(sectionSizes);
        sb.append(sectionSizes.size()).append("\n");
        for (int i = 0; i < sectionSizes.size(); i++) {
            sb.append(sectionSizes.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int y, int x) {
        Queue<int []> q = new LinkedList<>();
        int size = 1;
        q.offer(new int[]{y, x});
        map[y][x]=1;
        while (!q.isEmpty()) {
            int[] prev = q.poll();
             //일종의 방문표시
            for (int[] nextDir : canGo) {
                int ny = prev[0]+nextDir[0];
                int nx = prev[1]+nextDir[1];
                if(ny<0||ny>=m||nx<0||nx>=n) continue;
                if (map[ny][nx] == 0) {
                    q.offer(new int[]{ny, nx});
                    map[ny][nx]=1;
                    size++;
                }
            }
        }
        sectionSizes.add(size);
    }

}
