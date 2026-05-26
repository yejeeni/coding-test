package day12.특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 도시 수
    int M = Integer.parseInt(st.nextToken()); // 단방향 도로 수
    int K = Integer.parseInt(st.nextToken()); // 출발 도시
    int X = Integer.parseInt(st.nextToken()); // 찾는 최단거리

    List<List<Integer>> graph = new ArrayList<>();
    for (int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
    }

    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[K] = 0;

    // 누적비용, 노드번호
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[]{0, K});

    while(!pq.isEmpty()) {
      // pq에서 누적비용, 노드번호 꺼내기
      int[] cur = pq.poll();
      int d = cur[0];
      int u = cur[1];

      // 낡은 항목 스킵
      if (d > dist[u]) {
        continue;
      }

      for (int next : graph.get(u)) {
        int nd = d + 1;
        if (nd < dist[next]) {
          dist[next] = nd;
          pq.offer(new int[]{nd, next});
        }
      }
    }

//    최단거리가 X인 도시 번호를 오름차순으로 한 줄씩 출력. 없으면 -1
    StringBuilder sb = new StringBuilder();
    for (int i=1; i<dist.length; i++) {
      if (dist[i] == X) {
        sb.append(i).append("\n");
      }
    }

    if (sb.isEmpty()) {
      sb.append("-1");
    }

    System.out.print(sb);
  }
}
