package day10.미로탐색;

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
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] maze = new int[n][m];
    int[][] dist = new int[n][m]; // 각 좌표마다 시작위치에서 얼마나 이동해왓는지 저장

    for (int i=0; i<n; i++) {
      String line = br.readLine();

      for (int j=0; j<m; j++) {
        maze[i][j] = line.charAt(j) - '0';
      }
    }

    int[][] result = bfs(n, m, maze, dist);
    System.out.println(result[n-1][m-1]);
  }

  static int[][] bfs(int n, int m, int[][] maze, int[][] dist) {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    dist[0][0] = 1; // 시작좌표부터 1칸

    Queue<int[]> q = new ArrayDeque<>(); // FIFO
    q.offer(new int[]{0, 0}); // 시작 노드 추가

    while(!q.isEmpty()) {
      // 탐색 출발할 좌표 꺼내기
      int[] xy = q.poll();

      for (int i=0; i<4; i++) {
        // 다음 이동할 좌표
        int nx = xy[0] + dx[i];
        int ny = xy[1] + dy[i];

        if (0 <= nx && nx <  n && 0 <= ny && ny < m) { // 다음 좌표가 범위 내에 있는 경우
          if (maze[nx][ny] == 1) { // 1 (이동가능)인 경우
            if (dist[nx][ny] == 0) { // 방문하지 않은 좌표인 경우
              // 이동거리 기록
              dist[nx][ny] = dist[xy[0]][xy[1]] + 1; // 하나 이동했으니 하나 증가
              // q에 해당 좌표 추가
              q.offer(new int[]{nx, ny});
            }
          }
        }
      }
    }
    return dist;
  }
}
