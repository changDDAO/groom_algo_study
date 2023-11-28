package programmers;
class PCCP4번문제 {
    //bactracking 문제인데 4시간정도 할애한 것 같다. 변수를 줄이고 싶지만 변수를 줄이면 가독성이 많이 떨어질 것 같아
    // 최소한의 변수를 생성하면서 그나마 가독성 있게 코드를 작성하려면 이정도는 필요하지 않을까?

    static int n, m;
    static int [][] start; //red coin과 blue coin을 담을 배열
    static int dx[] = {0,1,0,-1}; //y축 방향
    static int dy[] = {1,0,-1,0}; // x축 방향
    static int [][] cMaze; // static 으로 maze[][] 을 참조할 배열
    static boolean [][] redVisited; //red coin 이 지나온 길에 방문표시를 할 배열
    static boolean [][] blueVisited; //blue coin 이 지나온 길에 방문표시를 할 배열
    static int answer = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        cMaze = maze;
        n = maze.length;
        m = maze[0].length;
        // red, blue coin 방문표시 배열
        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];
        start = new int[2][2];
        // x: y축 y: x축 red: 0 index,  blue: 1 index
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                //빨간코인 시작칸
                if(cMaze[i][j]==1){
                    start[0][0]=i;
                    start[0][1] = j;
                }   //블루코인 시작칸
                if(cMaze[i][j]==2){
                    start[1][0] = i;
                    start[1][1]= j;
                }
            }
        }
        /*시작지점이지만 방문표시를 해야 하는 이유는?
         4방향 순회를 할 때, 방문표시를 이용하여 왔던 길을 돌아가지 않기 위해 check하는데 시작 지점이 false로 처리
        되어있다면 문제가 생기겠죠?*/
        redVisited[start[0][0]][start[0][1]] = true;
        blueVisited[start[1][0]][start[1][1]] = true;
        dfs(start, 1);
        /* dfs를 수행하면서 answer를 최솟값으로 초기화 해가는데 answer값이 변화가 없다면?
         최종 목표지점까지 도달할 수 없다는 의미니까 문제에서 0을 return 해주라고 했죠.*/
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    //dfs 정의
    static void dfs(int [][]prevCoins, int depth){
        int redX = prevCoins[0][0]; //이전 red coin의 x값(row)
        int redY = prevCoins[0][1]; //이전 red coin의 y값(col)
        int blueX = prevCoins[1][0]; //이전 blue coin의 x값(row)
        int blueY = prevCoins[1][1]; //이전 blue coin의 y값(col)
        /* dfs를 수행하면서 계속 depth가 깊어지는데(+1) answer 값과 같아진다면 더이상 dfs를 수행할 이유가 없어지죠?
        최솟값을 return하는 것이니까.. */
        if(depth==answer) return;
        for(int i=0; i<4;i++){
            //cMaze[redX][redY]가 3이라는 것은 이미 red coin 도착지점에 도달했다는 것
            int nextRedX = cMaze[redX][redY]==3? redX : redX+dx[i];
            int nextRedY = cMaze[redX][redY]==3? redY : redY+dy[i];
            // red coin이 갈 수 있는 길이 아니라면 for문 다음 인덱스부터 수행
            if(!canGo(nextRedX, nextRedY)) continue;
             /*red coin이 아직 목표지점까지 도달하지 않았고, red coin의 다음 가야할 지점이 이미 방문했던 지점이라면
            for문 다음 인덱스부터 수행*/
            if(cMaze[redX][redY]!=3 && redVisited[nextRedX][nextRedY])
                continue;
            for(int j =0; j<4; j++){
                //cMaze[blueX][blueY]가 4라는 것은 이미 blue coin 도착지점에 도달했다는 것
                int nextBlueX = cMaze[blueX][blueY] == 4 ? blueX : blueX + dx[j];
                int nextBlueY = cMaze[blueX][blueY] == 4 ? blueY : blueY + dy[j];
                // blue coin이 갈 수 있는 길이 아니라면 for문 다음 인덱스부터 수행
                if(!canGo(nextBlueX, nextBlueY)) continue;
                 /*blue coin이 아직 목표지점까지 도달하지 않았고, red coin의 다음 가야할 지점이 이미 방문했던 지점이라면
            for문 다음 인덱스부터 수행*/
                if(cMaze[blueX][blueY] !=4&& blueVisited[nextBlueX][nextBlueY])
                    continue;
                //레드 코인과 블루 코인이 겹쳐진다면 for문 다음 인덱스부터 수행(다음 블루코인 방향 탐색)
                if(nextRedX==nextBlueX && nextRedY == nextBlueY)
                    continue;
                /* 다음으로 나아갈 red coin과 이미 목표지점에 도달한 blue coin이 겹쳐지거나
                 반대로 나아갈 blue coin과 이미 목표지점에 도달한 red coin이 겹쳐진다면*/
                if((nextRedX ==blueX && nextRedY == blueY)
                        &&(nextBlueX == redX && nextBlueY == redY) )
                    continue;
                /* red coin과 blue coin이 모두 목표지점에 도달했다면
                 현재까지 수행된 depth값과 answer값 비교후 최솟값을 answer 값으로 갱신 및 (특정 brunch의 dfs)종료*/
                if(cMaze[nextRedX][nextRedY]==3 && cMaze[nextBlueX][nextBlueY]==4){
                    answer = Math.min(answer, depth);
                    return;
                }
                // 왔던 길을 거슬러서 탐색하면 안되므로 방문표시
                redVisited[nextRedX][nextRedY] = true;
                blueVisited[nextBlueX][nextBlueY] = true;
                //dfs 수행 (다음으로 나아갈 red coin 위치정보와 blue coin 위치정보를 넘겨줌)
                dfs(new int[][]{{nextRedX, nextRedY}, {nextBlueX, nextBlueY}}, depth+1);
                //더 이상 주변을 탐색하면서 나아갈 수 없을 때, 이전 상태로 돌아와 다른 방향을 탐색 후 현재지점을 다시
                //탐색할 수 있도록 하기위함( dfs와 backtracking 문제를 좀 더 다뤄보면 이해할 수 있어요)
                redVisited[nextRedX][nextRedY] = false;
                blueVisited[nextBlueX][nextBlueY] = false;
            }
        }
    }
    //다음으로 나아갈 next red coin과 next blue coin이
    // maze의 범위를 벗어나지 않으면서, 벽이 아닌지 check하기 위한 메서드
    static boolean canGo(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m||cMaze[x][y]==5) return false;
        return true;
    }

}