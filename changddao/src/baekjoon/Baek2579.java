package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2579 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dpTable = new int[n + 1];
        int[] numArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numArr[i]=Integer.parseInt(br.readLine());
        }
        //dp Table 초기화 해주기
        dpTable[1] = numArr[1];
        //n 입력 수에대한 제한이 없기 때문에 제약걸어주기
        if (n >= 2) {
            dpTable[2] =numArr[1]+numArr[2];
        }
        /*1.경우 생각해주기 dpTable 인덱스는 i번째 계단까지의 최댓값을 나타낸다
        //총 2개의 경우의 수가 존재한다.
        * 2. i번째 계단의 최댓값의 경우 numArr[i-1]+numArr[i]+dpTable[i-3] (하나의 경우)
        * 2-1. i번째 계단의 최댓값의 경우 numArr[i]+dpTable[i-2] (두번째의 경우)
           이 두값을 비교하여 더 큰값을 dpTable[i]에 넣어준다면 최종적으로 원하는 결과를 얻을 수 있을 것이다.
        * */
        for (int i = 3; i <= n; i++) {
            dpTable[i] = Math.max(dpTable[i-3]+numArr[i-1], dpTable[i-2]) +numArr[i];
        }
        System.out.println(dpTable[n]);

    }
}
