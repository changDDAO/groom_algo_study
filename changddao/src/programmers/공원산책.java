package programmers;

public class 공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int x = park.length;
        int y = park[0].length();
        int [] startPos={0,0};
        //동서남북 정의하기
        char [][]map = new char[x][y];
        for(int i = 0 ; i< park.length;i++){
            map[i] = park[i].toCharArray();
            if(park[i].contains("S")){
                startPos[0]=i;
                startPos[1]=park[i].indexOf("S");
            }
        }
        for(String route: routes){
            String []temp = route.split(" ");
            char dir = temp[0].charAt(0);
            int size = Integer.parseInt(temp[1]);
            int nx = startPos[0];
            int ny = startPos[1];
            for(int i=0; i<size;i++){
                if(dir=='E')
                    ny++;
                if(dir=='W')
                    ny--;
                if(dir=='S')
                    nx++;
                if(dir=='N')
                    nx--;
                if(nx<0||nx>=x||ny<0||ny>=y) break;
                if(map[nx][ny]=='X') break;
                //범위를 벗어나지 않으면서 가는길에 장애물이없고 주어진 size만큼 움직였다면
                //현재위치 초기화 해주기
                if(i== size-1){
                    startPos[0]=nx;
                    startPos[1]=ny;

                }
            }
        }


        int []answer = {startPos[0],startPos[1]};
        return answer;
    }
}
