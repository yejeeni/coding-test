package day9.사이클감지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
  // 무방향 그래프에서 사이클(cycle)이 존재하면 YES, 없으면 NO를 출력하라.
  // 사이클이란 한 노드에서 출발해 자기 자신으로 돌아오는 경로가 존재하는 것이다.

  static ArrayList<Integer>[] graph;
  static boolean flag = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n+1];
    for (int i=1; i<=n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    // 노드를 순회하면서 시작 노드가 나오는지 봐야함
    for (int i=1; i<=n; i++) {
      boolean[] visited = new boolean[n+1];
      dfs(i, i, visited);
    }

    if (flag) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  public static void dfs(int node, int parent, boolean[] visited) { // 지금 있는 노드, 직전에 방문했던 노드, 방문목록
    // 노드 방문 처리
    visited[node] = true;

    // 연결된 노드가 있다면 탐색
    for (int n : graph[node]) {
      // 다음 노드가 parent면 왔던 길이므로 건너뛰기
      if (n == parent) {
        continue;
      }
      // visited 처리되어 있으면 사이클 발생
      if (visited[n]) {
        flag = true;
        break;
      }

      // 미방문이면 더 탐색
      dfs(n, node, visited);
    }

  }
}
