package programmers;
import java.util.*;
public class 정수삼각형 {
    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            for(int i = 1; i< triangle.length;i++){
                for(int j= 0; j<triangle[i].length;j++){
                    //오른쪽위에서 밖에 올수 없는 경우
                    if(j==0){
                        triangle[i][j]+=triangle[i-1][j];
                    }
                    //왼쪽위에서 밖에 올수 없는 경우
                    else if(j==triangle[i].length-1){
                        triangle[i][j]+= triangle[i-1][j-1];
                    }
                    else{
                        //왼쪽위에서 오는경우
                        int leftUp = triangle[i-1][j-1]+triangle[i][j];
                        //오른쪽위에서 오는경우
                        int rightUp = triangle[i-1][j]+triangle[i][j];
                        triangle[i][j] = Math.max(leftUp, rightUp);
                    }

                }
            }
            return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        }
    }
}
