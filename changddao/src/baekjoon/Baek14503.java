package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14503 {
    //북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, row, col, seeDir;
    static int[][] map;
    static int clean = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        seeDir = Integer.parseInt(st.nextToken());
        //map 초기화 해주기
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(row, col, seeDir);
        System.out.println(clean);
    }

    /*로봇 청소기는 다음과 같이 작동한다.

1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
2.현재 칸의 주변4칸 중 청소되지 않은 빈 칸이 없는 경우,
    1.바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
    2.바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
    1.반시계 방향으로 90도 회전한다.
    2.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
    3.1번으로 돌아간다.*/
    static void dfs(int x, int y, int seeDirection) {
        map[x][y] = 10; //방문표시

        for (int i = 0; i < 4; i++) {
            seeDirection -= 1; //왼쪽 방향으로 회전
            if (seeDirection == -1) seeDirection = 3;

            int nx = x + dx[seeDirection];
            int ny = y + dy[seeDirection];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0) {
                    clean++;
                    dfs(nx, ny, seeDirection);
                    return;
                }
            }
        }

        int backDir = (seeDirection + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];
        if (bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            dfs(bx, by, seeDirection);
        }
    }


}

