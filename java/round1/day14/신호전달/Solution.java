package day14.신호전달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 단반향 네트워크.
 * 서버 k에서 신호 보낼 때 모든 서버에 신호 도달하기까지의 시간
 * 도착시간...
 * 가중치가 있는 최소 -> 다익스트라?
 */

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 서버 수
    int m = Integer.parseInt(st.nextToken()); // 연결 수
    int k = Integer.parseInt(st.nextToken()); // 시작점

    List<List<int[]>> graph = new ArrayList<>();
    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()); // 출발
      int v = Integer.parseInt(st.nextToken()); // 도착
      int w = Integer.parseInt(st.nextToken()); // 가중치

      graph.get(u).add(new int[]{v, w}); // {도착지, 가중치}
    }

    int[] dist = new int[n+1]; // 거리 저장 배열
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[k] = 0;

    // 누적가중치, 노드번호
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[]{0, k});

    while(!pq.isEmpty()) {
      // 꺼내기
      int[] cur = pq.poll();
      int d = cur[0]; // 비용
      int u = cur[1]; // 노드

      if (d > dist[u]) {
        continue;
      }

      // 순회
      for (int[] edge : graph.get(u)) {
        int next = edge[0]; // 다음 노드
        int weight = edge[1]; // 간선 가중치

        int nextD = weight + d;
        if (nextD < dist[next]) { // 다음노드에 이 간선으로 갔을 때, 지금 저장해둔 것보다 가중치가 적은 경우
          // 갱신
          dist[next] = nextD;
          pq.offer(new int[]{nextD, next}); // 다시 추가
        }
      }
    }

    int result = -1;
    for (int i=1; i<=n; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        result = -1;
        break;
      }

      if (dist[i] > result) {
        result = dist[i];
      }
    }
    System.out.println(result);

  }

}
