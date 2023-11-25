package programmers;

import java.util.HashMap;
import java.util.Map;

public class PCCP기출문제1번 {

    static int curHealth;
    static Map<Integer, Integer> attackMap = new HashMap<>();
    static int maintainTime;
    static int endTime;

    public int solution(int[] bandage, int health, int[][] attacks) {
        curHealth = health;
        endTime = attacks[attacks.length - 1][0];
        //공격시간 별 데미지 맵으로 초기화 해주기
        for (int i = 0; i < attacks.length; i++) {
            attackMap.put(attacks[i][0], attacks[i][1]);
        }
        //0초는 초기상태이기 때문에 굳이 for문으로 순회할 필요가 없고, 1초부터 endTime까지 순회하자.
        for (int i = 1; i <= endTime; i++) {
            //공격을 받는 시간대라면
            if (attackMap.containsKey(i)) {
                curHealth -= attackMap.get(i);
                maintainTime = 0;
            }//공격을 받는 시간이 아니라면
            else {
                maintainTime++;
                curHealth += bandage[1];
                if (maintainTime == bandage[0]) {
                    curHealth += bandage[2];
                    maintainTime = 0;
                }
                if (curHealth > health)
                    curHealth = health;
            }
            if (curHealth <= 0) return -1;
        }
        return curHealth;

    }
}

