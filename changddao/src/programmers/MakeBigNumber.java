package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeBigNumber {
    static String number;
    static int k;
    String answer;

    public static void main(String[] args) throws IOException {
        System.out.println("숫자 number와 제거할 수의 개수를 입력하시오.(입력 예시: 1924 2)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        number = st.nextToken();
        k = Integer.parseInt(st.nextToken());
        int index = 0; //처음에 가장 큰 수를 담을 변수.
        for (int i = 0; i < number.length() - k; i++) {
            char selectedMaxNum = '0';
            for (int j = index; j <= i + k; j++) {
                if (selectedMaxNum < number.charAt(j)) {
                    selectedMaxNum = number.charAt(j);
                    index = j + 1;
                }
            }
            sb.append(selectedMaxNum);
        }
        System.out.println(sb.toString());
    }
    /*
    * 1. 전체 수 중에서 K개의 수를 빼고 가장 큰 수 선택하기(결과 값이 k개가 아니라 전체 수 - k)
    * 2. 뽑은 수 이후 인덱스 부터 k개를 뽑으면 됨.
    * 3. 그럼 최종 결과값이 (전체 수 - k)개가 되기 때문
    * 4. 실전에서 사고하기 힘드니 그리디문제는 수열마냥 규칙찾는 느낌으로 접근하자.
    * */



}
