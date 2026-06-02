package day15.최단경로복원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<List<int[]>> graph = new ArrayList<>();
    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    int[] dist = new int[n+1];
    for (int i=0; i<=n; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[1] = 0; // 1에서 출발

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken()); // 단방향

      graph.get(u).add(new int[]{v, w});
    }

    int[] prev = new int[n + 1];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {번호, 비용}
    pq.offer(new int[]{1, 0});

    while(!pq.isEmpty()) {
      int[] cur = pq.poll();
      int u = cur[0];
      int d = cur[1];

      // 오래된 거면 스킵
      if (d > dist[u]) {
        continue;
      }

      // 순회
      for (int[] edge : graph.get(u)) {
        int next = edge[0];
        int weight = edge[1];
        int nd = d + weight;

        if (nd < dist[next]) {
          dist[next] = nd;
          prev[next] = u; // 이전에 거친 곳이 어딘지 저장
          pq.offer(new int[]{next, nd});
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    if (dist[n] != Integer.MAX_VALUE) {
      sb.append(dist[n]).append("\n");

      List<Integer> path = new ArrayList<>();
      path.add(n);
      while(path.getLast() != 1) {
        int next = path.getLast();
        path.add(prev[next]);
      }

      Collections.reverse(path);
      for (int p : path) {
        sb.append(p).append(" ");
      }
    } else {
      sb.append("-1");
    }

    System.out.print(sb);
  }
}
