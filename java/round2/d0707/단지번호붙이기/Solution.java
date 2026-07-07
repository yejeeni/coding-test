package round2.d0707.단지번호붙이기;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

  static char[][] map;
  static boolean[][] visited;
  static ArrayList<Integer> complex = new ArrayList<>();

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    map = new char[n][n];
    visited = new boolean[n][n];

    for (int i=0; i<n; i++) {
      String s = br.readLine();
      for (int j=0; j<n; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == '1' && !visited[i][j]) {
          bfs(i, j, n);
        }
      }
    }

    Collections.sort(complex);
    System.out.println(complex.size());
    for (int c : complex) {
      System.out.println(c);
    }
  }

  static void bfs(int x, int y, int n) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;
    int cnt = 1;

    while(!queue.isEmpty()) {
      int[] apt = queue.poll();

      for (int i=0; i<4; i++) {
        int nx = apt[0] + dx[i];
        int ny = apt[1] + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == '1' && !visited[nx][ny]) {
          cnt++;
          visited[nx][ny] = true;
          queue.offer(new int[]{nx, ny});
        }
      }
    }
    complex.add(cnt);
  }
}
