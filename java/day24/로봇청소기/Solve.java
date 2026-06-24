package day24.로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solve {

  static int n;
  static int m;
  static int[][] room;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // 방 크기
    m = Integer.parseInt(st.nextToken());
    room = new int[n][m];
    boolean[][] cleaning = new boolean[n][m];

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken()); // 시작 행
    int c = Integer.parseInt(st.nextToken()); // 열
    int d = Integer.parseInt(st.nextToken()); // 방향

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
        if (room[i][j] == 1) {
          cleaning[i][j] = true;
        }
      }
    }

    int cnt = 0;
    while (true) {
      // 1. 현재 칸이 청소되지 않은 경우 청소한다.
      if (!cleaning[r][c]) {
        cleaning[r][c] = true;
        cnt++;
      }

      // 2. 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우:
      if (cleaning[r - 1][c] && cleaning[r + 1][c] && cleaning[r][c - 1] && cleaning[r][c + 1]) {
        // 바라보는 방향 유지한 채로 한 칸 후진 → 1번으로
        int nr = r + dr[(d + 2) % 4];
        int nc = c + dc[(d + 2) % 4];

        // 후진도 불가능하면 작동 멈춤
        if (!check(nr, nc)) {
          break;
        } else {
          r = nr;
          c = nc;
        }

      } else { // 3. 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우:
        // 반시계 방향으로 90° 회전
        d = (d + 3) % 4;

        // 앞쪽 칸이 청소되지 않은 빈 칸이면 전진
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (check(nr, nc) && !cleaning[nr][nc]) {
          r = nr;
          c = nc;
        }
      }
    }

    System.out.println(cnt);
  }

  static boolean check(int r, int c) {
    if (r < 0 || r >= n || c < 0 || c >= m || room[r][c] == 1) {
      return false;
    } else {
      return true;
    }
  }

}
