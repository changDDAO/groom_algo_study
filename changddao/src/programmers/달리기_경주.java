package programmers;

import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
    /*
* 입출력 예
players
["mumu", "soe", "poe", "kai", "mine"]
* clallings
* ["kai", "kai", "mine", "mine"]
* result
* ["mumu", "kai", "mine", "soe", "poe"]
입출력 예 설명
4등인 "kai" 선수가 2번 추월하여 2등이 되고 앞서 3등, 2등인 "poe", "soe" 선수는 4등, 3등이 됩니다.
*  5등인 "mine" 선수가 2번 추월하여 4등, 3등인 "poe", "soe" 선수가 5등, 4등이 되고 경주가 끝납니다.
*  1등부터 배열에 담으면 ["mumu", "kai", "mine", "soe", "poe"]이 됩니다.
 * */
    public String[] solution(String[] players, String[] callings) {
        /*사고하기
        * 1. 현재위치를 기반으로 HashMap에 String (선수이름) Integer(현재위치)타입으로 저장한다.
        * 2. callings에서 이름이 불리는 선수의 현재위치(인덱스)를 가지고와서 인덱스-1의 선수와 바꿔준다.
        * 3. callings배열에서 한번만 값이 불리는게 아니기 때문에 바뀐 인덱스값을 다시 HashMap에 저장한다.*/
        Map<String, Integer> curPos = new HashMap<String, Integer>();
        //1등이 불리면 어떻게 처리하지??
        //경주 진행중 1등인 선수의 이름은 불리지 않습니다.(제한사항) 고려 필요X
        for (int i = 0; i < players.length; i++) {
            curPos.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            int idx = curPos.get(callings[i]);
            String prevPlayer = players[idx-1];
            players[idx - 1] = players[idx];
            players[idx] = prevPlayer;
            curPos.put(players[idx - 1], idx - 1);
            curPos.put(players[idx], idx);
        }
        return players;
    }
}
