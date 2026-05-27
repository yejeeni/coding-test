package day13.선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<List<Integer>> graph = new ArrayList<>();
    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }
    int[] degree = new int[n+1]; // 노드별 필요한 수강과목 수

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken()); // a -> b

      graph.get(a).add(b);
      degree[b]++; // b의 선수과목이 a. b를 듣기 위한 선수과목 수 ++
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // 차수가 0인 과목부터 pq에 offer
    for (int i=1; i<=n; i++) {
      if (degree[i] == 0) {
        pq.offer(i);
      }
    }


    while(!pq.isEmpty()) {
      // 큐에서 꺼내기
      int c = pq.poll();
      sb.append(c).append(" ");

      // 다음 이수 과목 찾기
      for (int nextC : graph.get(c)) {
        degree[nextC]--;
        if (degree[nextC] == 0) {
          pq.offer(nextC);
        }
      }
    }

    System.out.println(sb);

  }

}
