package day16.비상탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
  // 1 -> k -> n
  static List<List<int[]>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 건물
    int m = Integer.parseInt(st.nextToken()); // 단방향 도로 수
    int k = Integer.parseInt(st.nextToken()); // 경유지

    // 최단거리. 가중치 ㅇ. 다익스트라?
    graph = new ArrayList<>();
    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()); // 출발
      int v = Integer.parseInt(st.nextToken()); // 도착
      int w = Integer.parseInt(st.nextToken()); // 가중치

      graph.get(u).add(new int[]{v, w});
    }

    int pathK = dijkstra(1, k, n);
    int pathN = dijkstra(k, n, n);

    if (pathK == Integer.MAX_VALUE || pathN == Integer.MAX_VALUE) {
      System.out.println("-1");
    } else {
      System.out.println(pathK + pathN);
    }

  }

  static int dijkstra(int start, int end, int n) {
    // 출발지점 추가
    // 노드번호, 누적가중치
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[]{start, 0});

    // 누적 가중치 배열 생성하고 출발점 초기화
    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    // 경로탐색
    while(!pq.isEmpty()) {
      // 추출
      int[] cur = pq.poll();
      int c = cur[0];
      int d = cur[1];

      if (d > dist[c]) {
        continue; // skip
      }

      for (int[] edge : graph.get(c)) {
        int next = edge[0]; // 다음 노드
        int weight = edge[1]; // 다음 가중치
        int nw = weight + d;

        if (nw < dist[next]) {
          dist[next] = nw;
          pq.offer(new int[]{next, nw});
        }
      }
    }

    return dist[end]; // 목적지까지의 최단 거리
  }

}
