package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15686 {
    /*사고 및 문제 정리하기
     * 1. 0은 벽 1은 집 2는 치킨집
     * 2. 전체 치킨집 중에서 M개를 선택하고, 집들과 선택된 치킨집 사이의 최소거리를 구한다.
     * 3. 여러 치킨집이 있고 그중 M개만 택한 후 집과의 최소거리 측정(백트랙킹),
     *  집의 위치는 변하지 않지만, 치킨집은 for문을 순회하면서 달라질 수 있다.(완전탐색)
     * */
    static int n, m;
    static int[][] arrMap;

    //집들
    static List<int[]> houses = new ArrayList<>();
    //치킨 가게들
    static List<int[]> markets = new ArrayList<>();
    static List<int[]> selectedMarkets = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrMap = new int[n][n];
        //맵 초기화 및 house랑 markets 분리하여 ArrayList에 담기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arrMap[i][j] = Integer.parseInt(st.nextToken());
                //맵을 초기화함과 동시에 그값이 1이라면 house에 추가
                //맵을 초기화함과 동시에 그값이 2라면 markets에 추가
                if (arrMap[i][j] == 1) houses.add(new int[]{i, j});
                if (arrMap[i][j] == 2) markets.add(new int[]{i, j});
            }
        }
        visited = new boolean[markets.size()];
        findMinDist(0,0);
        System.out.println(answer);

    }

    static void findMinDist(int selectedMarket, int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int[] house : houses) {
                int minDis = Integer.MAX_VALUE;
                for (int[] selected : selectedMarkets) {
                    int dist = Math.abs(house[0] - selected[0]) + Math.abs(house[1] - selected[1]);
                    minDis= Math.min(minDis, dist);
                }
                sum+=minDis;
            }
            answer = Math.min(answer, sum);
        }
        for (int i = selectedMarket; i < markets.size(); i++) {
            if (!visited[i]) {
                visited[i]=true;
                selectedMarkets.add(markets.get(i));
                findMinDist(selectedMarket+1, depth+1);
                visited[i]=false;
                selectedMarkets.remove(selectedMarkets.size()-1);
            }
        }
    }
}
