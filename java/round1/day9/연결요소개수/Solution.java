package day9.연결요소개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

  static ArrayList<Integer>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 노드 수
    int m = Integer.parseInt(st.nextToken()); // 간선 수

    // 그래프 생성
    boolean[] visited = new boolean[n+1];
    graph = new ArrayList[n + 1];
    for (int i=1; i<=n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i=0; i<m; i++) {
      // 간선의 양 끝 노드 A B
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // 무방향 그래프 연결
      graph[a].add(b);
      graph[b].add(a);
    }

    int count = 0;
    for (int i=1; i<=n; i++) {
      // 노드 1부터 n까지, 탐색 안 한 노드만 dfs 탐색
      if (!visited[i]) {
        dfs(i, visited);
        count++; // 탐색 끝났으니 연결노드 끝
      }
    }

    System.out.println(count);

  }

  public static void dfs(int node, boolean[] visited) {
    // 현재 노드 방문 처리
    visited[node] = true;

    // 연결된 노드 순회
    for (int n : graph[node]) {
      if (!visited[n]) {
        dfs(n, visited);
      }
    }

  }

}
