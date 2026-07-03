package day13.건물건설순서;

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 건물 수
    int m = Integer.parseInt(st.nextToken());

    int[] t = new int[n+1]; // 각 건물의 건설시간 t[1] ~ t[N]
    st = new StringTokenizer(br.readLine());
    for (int i=1; i<=n; i++) {
      t[i] = Integer.parseInt(st.nextToken());
    }

    List<List<Integer>> graph = new ArrayList<>();
    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    int[] degree = new int[n+1]; // 필요 완공 건물 수
    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b); // a->b
      degree[b]++; // 필요 완공 건물 수 ++
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

    // degree 0인 건물부터
    for (int i=1; i<=n; i++) {
      if (degree[i] == 0) {
        pq.offer(new int[]{i, t[i]}); // {건물번호, 완공시간}
      }
    }

    int[] result = new int[n+1];
    // 건물별 최대 완공 시간
    int[] earliest = new int[n+1]; // earliest[b] = b가 시작 가능한 가장 빠른 시간
    while(!pq.isEmpty()) {
      // pq에서 뽑기 (=완공)
      int[] nowBuilding = pq.poll();
      int idx = nowBuilding[0];
      int spentTime = nowBuilding[1]; // 이 건물 완공에 든 시간
      result[idx] = spentTime;


      // 다음 건설 건물 찾기
      for (int b : graph.get(idx)) {
        // 방금 완공된 건물 시간 vs 지금까지 완공된 건물 중 최댓값
        // 더 늦게 끝나는 쪽을 기다려야 함
        earliest[b] = Math.max(spentTime, earliest[b]);
        degree[b]--; // 완공 필요 건물 수 하나 감소
        if (degree[b] == 0) { // 완공 필요 건물 다 지음
          pq.offer(new int[]{b, earliest[b] + t[b]});
        }
      }
    }

    for (int i=1; i<=n; i++) {
      sb.append(result[i]).append("\n");
    }

    System.out.print(sb);
  }

}
