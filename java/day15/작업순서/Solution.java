package day15.작업순서;

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
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<List<Integer>> graph = new ArrayList<>();
    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }
    
    int[] degree = new int[n+1];

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      graph.get(a).add(b);
      degree[b]++; // b의 선행작업 수 ++
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(); // 작업번호
    // 선행작업 없는 작업만 큐에 추가
    for (int i=1; i<=n; i++) {
      if (degree[i] == 0) {
        pq.offer(i);
      }
    }

    List<Integer> result = new ArrayList<>();

    while(!pq.isEmpty()) {
      int w = pq.poll();
      result.add(w);

      for (int next : graph.get(w)) {
        degree[next]--;
        if (degree[next] == 0) {
          pq.offer(next);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    if (result.size() < n) {
      sb.append("-1");
    } else {
      for (int r : result) {
        sb.append(r).append(" ");
      }
    }

    System.out.print(sb);
  }
}
