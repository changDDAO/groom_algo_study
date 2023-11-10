package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2630 {
    //문제 출처: https://www.acmicpc.net/problem/2630
    static int whiteCnt =0;
    static int blueCnt =0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        //맵 초기화 해주기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divideMap(0,0,n);
        sb.append(whiteCnt).append("\n");
        sb.append(blueCnt);
        System.out.println(sb.toString());
    }
    static void divideMap(int row, int col, int size){
        if (check(row, col, size)) {
            if(map[row][col]==1)
                blueCnt++;
            else whiteCnt++;
            return;
        }
        //split and conquer 시작
        int dividedSize = size/2;
        //나뉜후 왼쪽 위 정사각형
        divideMap(row,col,dividedSize);
        //나뉜후 오른쪽 위 정사각형
        divideMap(row,col+dividedSize,dividedSize);
        //나뉜후 왼쪽 아래 정사각형
        divideMap(row+dividedSize,col, dividedSize);
        //나뉜후 오른쪽 아래 정사각형
        divideMap(row+dividedSize, col+dividedSize, dividedSize);
    }
    static boolean check(int row, int col, int dividedSize) {
        int curColor = map[row][col];
        for (int startRow = row; startRow < row + dividedSize; startRow++) {
            for (int stratCol = col; stratCol < col + dividedSize; stratCol++) {
                if(curColor!=map[startRow][stratCol])return false;
            }
        }
        return true;
    }
}
