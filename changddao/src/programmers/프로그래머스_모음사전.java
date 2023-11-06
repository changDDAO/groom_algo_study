package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class 프로그래머스_모음사전 {
    static char[] alphabets = {'A','E','I','O','U'};
    static List<String> wordList = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        System.out.print("찾으려고 하는 word를 입력하시오 >>  ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        dfs("", 0);
        Collections.sort(wordList);
        answer = wordList.indexOf(word)+1;//"A"가 0부터 시작하기 때문에 +1
        System.out.println(answer);

    }
    static void dfs(String temp, int depth){
        if(depth>=5) return;
        for (int i = 0; i < alphabets.length; i++) {
            wordList.add(temp+alphabets[i]);
            dfs(temp+alphabets[i],depth+1);
        }
    }
}
