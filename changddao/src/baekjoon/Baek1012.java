package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1012 {
    static int tc;
    static int[][] canGo = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] srcMap;
    static int cnt;
    static int n, m, cabbages;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            cnt=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            srcMap = new int[n][m];
            cabbages =Integer.parseInt(st.nextToken());
            for (int cabbage = 0; cabbage < cabbages; cabbage++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                srcMap[x][y]=1; // 맵에서 cabbage 영역표시하기
            }
            for (int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if (srcMap[j][k] == 1) {
                        bfs(j,k);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<int[]>();
        srcMap[i][j]=0;//일종의 방문표시
        cnt++;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for (int[] next : canGo) {
                int nx = x+next[0];
                int ny = y+next[1];
                if(nx<0||ny<0||nx>=n||ny>=m)continue;//bfs를 수행하면서 맵밖의 영역으로 벗어난다면 continue
                if(srcMap[nx][ny]==0)continue;
                srcMap[nx][ny]=0;
                q.offer(new int[]{nx, ny});
            }
        }

    }
}
