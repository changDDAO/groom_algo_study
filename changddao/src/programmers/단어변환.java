package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class 단어변환 {
    static boolean [] visitedWord;
    static int answer = 0;
    static int wordLen;
    public int solution(String begin, String target, String[] words) {
        wordLen = words[0].length();
        visitedWord = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    static void dfs(String begin, String target, String[] words, int depth){
        //dfs가 종료될 조건
        if(begin.equals(target)){
            answer = depth;
            return;
        }
        //dfs가 수행할 동작
        for(int i =0; i<words.length; i++){
            if(visitedWord[i]) continue;

            int cnt = 0;
            for(int j = 0; j<wordLen; j++){
                if(begin.charAt(j)== words[i].charAt(j))
                    cnt++;
            }
            if(cnt == (wordLen-1)){
                visitedWord[i] = true;
                dfs(words[i],target, words, depth+1);
                visitedWord[i] = false;
            }
        }
    }
}
