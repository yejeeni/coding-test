package round1.day26.격자탈출;

import java.util.*;
import java.io.*;

public class Solution {

  // 격자 밖으로 나가면 탈출. 이미 이동한 칸에 다시 도달하면 -1.
  // 탈출까지 이동한 횟수
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    String[][] commend = new String[n][m];
    boolean[][] isVisited = new boolean[n][m];
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        commend[i][j] = st.nextToken();
      }
    }

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    isVisited[r][c] = true;

    int d;
    boolean isLoop = false;
    int cnt = 0;

    while (true) {
      String cmd = commend[r][c];
      if (cmd.equals("U")) {
        d = 0;
      } else if (cmd.equals("D")) {
        d = 1;
      } else if (cmd.equals("L")) {
        d = 2;
      } else { // R
        d = 3;
      }

      r += dr[d];
      c += dc[d];
      cnt++;

      if (r < 0 || r >= n || c < 0 || c >= m) {
        break;
      } else if (isVisited[r][c]) {
        isLoop = true;
        break;
      }

      isVisited[r][c] = true;
    }

    if (isLoop) {
      System.out.println("-1");
    } else {
      System.out.println(cnt);
    }
  }
}
