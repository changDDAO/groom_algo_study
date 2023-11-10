package programmers;

import java.util.Arrays;

public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        //targets의 끝나는 지점을 기준으로 정렬을 하고 끝나는지점이 같다면?
        // 시작지점을 기준으로 오름차순 정렬을 한다 => 왜? 밑에서 알려드림
        Arrays.sort(targets, (tar1, tar2)->{
            if(tar1[1]==tar2[1])
                return tar1[0]-tar2[0];
            return tar1[1]-tar2[1];
        });
        int end = targets[0][1];// 오름차순 정렬후 첫번째 미사일의 끝나는 지점
        answer++;
        for(int [] target : targets){
            // equal 표현을 해주어야 하는 이유는 개구간은 요격불가
            if(target[0]>=end){
                answer++;
                end = target[1];
            }
        }
        return answer;
    }
}
