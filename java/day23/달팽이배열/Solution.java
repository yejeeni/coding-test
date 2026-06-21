package day23.달팽이배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    // 오른쪽, 아래, 왼쪽, 위
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    int r = 0, c = 0, d = 0;
    for (int v=1; v<= n*n; v++) {
      arr[r][c] = v; // 값 채우기
      int nr = r + dr[d];
      int nc = c + dc[d];

      if (nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] != 0) {
        // 범위 이탈 또는 이미 채워진 칸
        d = (d + 1) % 4;
        nr = r + dr[d];
        nc = c + dc[d];
      }

      r = nr;
      c = nc;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}