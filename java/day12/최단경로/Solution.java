package day12.최단경로;

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

    int V = Integer.parseInt(st.nextToken()); // 노드 수
    int E = Integer.parseInt(st.nextToken()); // 간선 수

    int K = Integer.parseInt(br.readLine()); // 시작 노드 번호

    List<List<int[]>> graph = new ArrayList<>(); // 그래프 graph.get(u) = {next, weight} 리스트
    for (int i = 0; i<=V; i++) {
      graph.add(new ArrayList<>());
    }

    int[] dist = new int[V+1]; // 거리 배열
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[K] = 0; // 시작 노드 초기화

    // PQ: {누적비용: 노드번호} 오름차순
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[]{0, K});

    for (int i=0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()); // 시작 노드
      int v = Integer.parseInt(st.nextToken()); // 도착 노드
      int w = Integer.parseInt(st.nextToken()); // 가중치

      graph.get(u).add(new int[]{v, w}); // {도착노드, 가중치} 입력
    }

    // i번 노드까지 최단 거리, 도달 불가면 INF
    while(!pq.isEmpty()) {
//      1. PQ에서 {비용 d, 노드 u} 꺼냄
      int[] cur = pq.poll();
      int d = cur[0]; // 비용
      int u = cur[1]; // 노드

      if (d > dist[u]) {
        continue; // 낡은 항목 스킵
      }

//      2. u의 인접 노드들을 순회
      for (int[] edge : graph.get(u)) {
        int next = edge[0]; // 인접노드
        int weight = edge[1]; // 비용

        int nd = d + weight; // 인접노드로 갔을 때의 총 비용
//      3. "d + 간선비용 < dist[인접노드]" 이면 → 더 짧은 경로 발견!
        if (nd < dist[next]) {
//         → dist[인접노드] 갱신 + PQ에 추가
          dist[next] = nd;
          pq.offer(new int[]{nd, next});
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= V; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        sb.append("INF");
      } else {
        sb.append(dist[i]);
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
