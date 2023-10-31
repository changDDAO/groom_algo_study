import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수열과_구간쿼리_2 {
    static int[] arr = {0, 1, 2, 4, 3};
    static int [][]queries = new int[1000][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        while (queries[index++][0] != -1) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            //BinarySearch로 풀고싶은 욕구가 생기나... 처음사고대로 풀어보자
            int answer = 0;
            int [] copiedArr = Arrays.copyOfRange(arr, start, end+1);
            Arrays.sort(copiedArr);
            for (int i = start; i <= end; i++) {
                if (copiedArr[i] > target) {
                    answer = copiedArr[i];
                    break;
                }
                else{
                    answer=-1;
                }
            }
            System.out.println(answer);
        }
        }
        //https://school.programmers.co.kr/learn/courses/30/lessons/181923

    }

