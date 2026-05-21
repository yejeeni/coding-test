package day10.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
  static int[][] map;
  static boolean[][] visited;
  static ArrayList<Integer> complex;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visited = new boolean[n][n];
    complex = new ArrayList<>();

    for (int i=0; i<n; i++) {
      String readLine = br.readLine();
      for (int j=0; j<n; j++) {
        map[i][j] = readLine.charAt(j) - '0';
      }
    }

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        int count = dfs(i, j, n); // 탐색 시작
        if (count > 0) {
          complex.add(count);
        }
      }
    }
    Collections.sort(complex);

    sb.append(complex.size()).append("\n");
    for (int i=0; i<complex.size(); i++) {
      sb.append(complex.get(i));
      if (i<complex.size()-1) {
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }

  static int dfs(int x, int y, int n) {
    int count = 0;
    if (map[x][y] != 0) { // 집 있음
      if (!visited[x][y]) { // 탐색한 적 없음
        visited[x][y] = true; // 현재노드 방문 처리
        count += 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
          // 다음 이동할 좌표
          int nx = x + dx[i];
          int ny = y + dy[i];

          if (0 <= nx && nx < n && 0 <= ny && ny < n) { // 다음 좌표가 범위 내에 있는 경우
            count += dfs(nx, ny, n);
          }
        }
      }
      return count;
    }
    return 0;
  }

}
