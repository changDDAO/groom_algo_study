import org.w3c.dom.ls.LSOutput;

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
        number = st.nextToken();
        k = Integer.parseInt(st.nextToken());
        int index = 0; //처음에 가장 큰 수를 담을 변수.




    }



}
