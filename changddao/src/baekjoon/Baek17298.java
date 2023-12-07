package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek17298 {

    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }
        int lastIdx = numList.size()-1;
        //완전탐색으로 찾아볼까? 시간초과 날것 같긴한데 ..
        for (int i = 0; i < n - 1; i++) {
            int target = numList.get(i);
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                int compare = numList.get(j);
                if (compare > target) {
                    sb.append(compare).append(" ");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append(-1 + " ");
            }
        }
        sb.append(-1);
        System.out.println(sb.toString());
    }
    //여윽시 시간초과*/
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N; i++) {

            /*
             * 스택이 비어있지 않으면서
             * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
             * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
             * 해당 인덱스의 값을 현재 원소로 바꿔준다.
             */
            while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }

            stack.push(i);
        }

        /*
         * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
         * -1로 초기화한다.
         */
        while(!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(seq[i]).append(' ');
        }

        System.out.println(sb);
    }

}



