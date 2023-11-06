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
    //https://www.acmicpc.net/problem/15686 문제링크
    static int n, m;
    static int[][] arrMap;

    //집들
    static List<int[]> houses = new ArrayList<>();
    //치킨 가게들
    static List<int[]> markets = new ArrayList<>();
    //선택된 치킨 가게들
    static List<int[]> selectedMarkets = new ArrayList<>();
    // 완전탐색을 수행할 때, 방문했던 치킨집인지 체크할 변수
    static boolean[] visited;
    //완전탐색을 수행하고 최솟값을 담을 answer 변수
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrMap = new int[n][n];
        //맵 초기화 및 houses랑 markets 분리하여 ArrayList에 담기
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

    static void findMinDist(int idx, int depth) {
        //남길 치킨집의 갯수와 같아질 때, 수행
        if (depth == m) {
            int sum = 0;
            //arrMap에 표시된 집의 위치정보를 각각 가지고온다.
            for (int[] house : houses) {
                int minDis = Integer.MAX_VALUE;
                //여러 치킨집중 m개만큼 선택된 치킨집의 위치정보를 각각 가지고 온다.
                for (int[] selected : selectedMarkets) {
                    //거릿값 계산
                    int dist = Math.abs(house[0] - selected[0]) + Math.abs(house[1] - selected[1]);
                    //현재 집에서 여러 치킨집과의 거리를 비교 후, 최솟값을 minDis에 저장
                    minDis= Math.min(minDis, dist);
                }
                //각 집과 선택된 치킨집 중에서 가장 가까운 최소거리를 합한다.
                sum+=minDis;
            }
            answer = Math.min(answer, sum);
            return; // 종료
        }
        for (int i = idx; i < markets.size(); i++) {
            if (!visited[i]) {
                visited[i]=true;
                selectedMarkets.add(markets.get(i));
                findMinDist(i+1, depth+1);
                visited[i]=false;
                selectedMarkets.remove(selectedMarkets.size()-1);
            }
        }
    }
}
