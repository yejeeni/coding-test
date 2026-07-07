package round2.d0707.연결요소개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
  static List<List<Integer>> graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 정점 수
    int m = Integer.parseInt(st.nextToken()); // 간선 수
    graph = new ArrayList<>();
    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }
    visited = new boolean[n+1];
    int cnt = 0;

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    for (int i=1; i<=n; i++) {
      if (!visited[i]) {
        dfs(i);
        cnt++;
      }
    }

    System.out.println(cnt);
  }

  static void dfs(int node) {
    visited[node] = true;

    for (int n : graph.get(node)) {
      if (!visited[n]) {
        dfs(n);
      }
    }

  }
}
