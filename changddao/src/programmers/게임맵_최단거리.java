package programmers;

import java.util.LinkedList;
import java.util.Queue;
//https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class 게임맵_최단거리 {
    int [][]nextDir = {{0,1},{0,-1},{1,0},{-1,0}};
    class Position{
        int x;
        int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    //벽이 있는자리는 0 벽이 없으면 1 //방문했는지 체크하고,
    public int solution(int[][] maps) {
        int answer = 0;
        int height = maps.length;
        int width = maps[0].length;
        int [][] count = new int[height][width];
        boolean [][] visited = new boolean[height][width];
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0,0));
        visited[0][0] = true;
        count[0][0]=1;
        Position cur;
        while(!q.isEmpty()){
            cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for(int[] nextGo : nextDir){
                int nx = cur.x+nextGo[0];
                int ny = cur.y+nextGo[1];
                if(nx<0||nx>=height||ny<0||ny>=width) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx][ny]==0)continue;
                count[nx][ny] = count[x][y]+1;
                visited[nx][ny]= true;
                q.offer(new Position(nx,ny));
            }

        }
        answer = count[height-1][width-1]==0?-1:count[height-1][width-1];

        return answer;
    }
}
