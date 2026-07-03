package day12.경유지를거치는최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 노드 수

    List<List<int[]>> graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    int M = Integer.parseInt(st.nextToken());
    int b = 0;
    int a = 0;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      // 양방향 간선
      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }

    st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken()); // 출발지
    int V1 = Integer.parseInt(st.nextToken()); // 경유지 1
    int V2 = Integer.parseInt(st.nextToken()); // 경유지 2
    int E = Integer.parseInt(st.nextToken()); // 목적지

    int[] distS = dijkstra(N, S, graph); // S에서 다익스트라
    int[] distV1 = dijkstra(N, V1, graph); // V1에서 다익스트라
    int[] distV2 = dijkstra(N, V2, graph); // V2에서 다익스트라

    long result1 = (long)distS[V1] + distV1[V2] + distV2[E];
    long result2 = (long)distS[V2] + distV2[V1] + distV1[E];

    long result = Math.min(result1, result2);
    System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
  }

  static int[] dijkstra(int n, int start, List<List<int[]>> graph) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[0] - pq2[0]);
    pq.offer(new int[]{0, start});

    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    while(!pq.isEmpty()) {
      int cur[] = pq.poll();
      int d = cur[0]; // 비용
      int u = cur[1]; // 노드

      if (d > dist[u]) {
        continue;
      }

      for (int[] edge : graph.get(u)) {
        int next = edge[0];
        int weight = edge[1];
        int nd = weight + d;
        if (nd < dist[next]) {
          dist[next] = nd;
          pq.offer(new int[]{nd, next});
        }

      }
    }
    return dist;
  }

}
