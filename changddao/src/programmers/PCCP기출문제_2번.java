package programmers;

import java.util.ArrayList;
import java.util.List;

public class PCCP기출문제_2번 {
    //처음에 문제를 풀이할 때, map을 복사하여 석유량을 Count하였으나, 시간초과 발생
    //다른방법을 찾아보자 map을 순회하면서 석유가 매장되어 있는 부분의 값을 Unique한 값으로 바꿔주자.
    static int width, height;
    static List<Integer> oilAmount;
    static int[][] srcMap, countMap;
    static boolean [] visited;
    static int count;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    public int solution(int[][] land) {
        //초기화 해주기
        int answer =0;
        srcMap = land;
        width = land[0].length;
        height = land.length;
        oilAmount = new ArrayList<Integer>();
        oilAmount.add(0);// 각 인덱스로 값을 맞춰주기 위함
        countMap = new int[height][width];
        int index = 1;
        for(int i = 0 ; i<height; i++){
            for(int j = 0; j<width; j++){
                if(land[i][j]==1 && countMap[i][j]==0){
                    count = 0;
                    makeUnique(i, j, index);
                    oilAmount.add(count);
                    index++;
                }
            }
        }
        //각 col을 순회하면서 방문표시를 초기화 해주며 석유매장량을 탐사
        for(int i= 0 ; i<width; i++){
            int sum = 0;
            visited = new boolean[oilAmount.size()];
            for(int j = 0; j<height; j++){
                int uniqueVal = countMap[j][i];
                if(!visited[uniqueVal]&&uniqueVal!=0){
                    visited[uniqueVal] = true;
                    sum+=oilAmount.get(uniqueVal);
                }
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
    static void makeUnique(int x, int y, int unique){
        count++;
        countMap[x][y] = unique;
        for(int i =0; i<4; i++){
            int nx = x+ dx[i];
            int ny = y + dy[i];
            //맵의 범위를 벗어난다면
            if(nx<0||nx>=height||ny<0||ny>=width) continue;
            //맵에 표시된 영역이 오일부분이 아니라면
            if(srcMap[nx][ny]!=1) continue;
            //이미 방문한 오일영역이라면
            if(countMap[nx][ny]!=0)continue;
            makeUnique(nx, ny, unique);
        }
    }
}
