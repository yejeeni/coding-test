package day10.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    Queue<int[]> q = new ArrayDeque<>();
    int[][] box = new int[n][m];

    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j=0; j<m; j++) {
        int tomatoStatus = Integer.parseInt(st.nextToken());
        box[i][j] = tomatoStatus;

        if (tomatoStatus == 1) {
          // 토마토가 있으면 바로 bfs 큐에 추가
          q.offer(new int[]{i, j});
        }
      }
    }

    System.out.println(dfs(m, n, box, q));
  }

  static int dfs(int m, int n, int[][] box, Queue<int[]> q) {
    int day = -1;
    int[] dm = {0, 0, -1, 1};
    int[] dn = {-1, 1, 0, 0};

    while(!q.isEmpty()) { // 큐가 빌 때까지 반복
      int[] mn = q.poll(); // 지금 익은 토마토 좌표

      for (int i = 0; i < 4; i++) {
        // 익게 할 수 있는 토마토 좌표
        int nr = mn[0] + dm[i];
        int nc = mn[1] + dn[i];

        if (0 <= nr && nr < n && 0 <= nc && nc < m) { // 다음 좌표가 범위 내에 있는 경우
          if (box[nr][nc] == 0) { // 안 익은 토마토가 있는 경우
            box[nr][nc] = box[mn[0]][mn[1]] + 1; // 하루 지나 익음 표시
            q.offer(new int[]{nr, nc});

            if (box[nr][nc] > day) {
              day = box[nr][nc];
            }
          }
        }
      }
    }

    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        if (box[i][j] == 0) { // 안 익은 토마토 존재
          return -1;
        }
      }
    }

    if (day == -1) { // 처음부터 다 익어있는 토마토라 아무것도 X
      return 0;
    }

    return day - 1; // 일수를 1부터 시작해서 하나 빼줌
  }
}
