package programmers;

import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }//사람별 그리움 점수 저장완료
        int idx =0;
        for(String[] p: photo){
            int sum = 0;
            for(int i = 0; i<p.length;i++){
                if(map.containsKey(p[i]))
                    sum+=map.get(p[i]);
            }
            answer[idx++]=sum;
        }
        return answer;
    }
}
