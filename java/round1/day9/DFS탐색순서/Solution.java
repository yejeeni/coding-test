package day9.DFS탐색순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    int n = Integer.parseInt(stringTokenizer.nextToken()); // 노드 수
    int m = Integer.parseInt(stringTokenizer.nextToken()); // 간선 수
    graph = new ArrayList[n+1]; // 그래프 배열
    visited = new boolean[n+1]; // 방문 노드 목록 배열

    for (int i=1; i<n+1; i++) { // 노드 1번부터
      graph[i] = new ArrayList<>();
    }

    for (int i=0; i<m; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      // 간선의 노드 a, b
      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());

      graph[a].add(b);
      graph[b].add(a); // 무방향
    }

    // 1번 노드에서 시작하는 DFS 탐색 순서를 출력하라. 깊이 우선.
    // 인접한 노드가 여러 개일 때는 번호가 작은 노드부터 방문한다.
    for (int i=1; i<n+1; i++) {
      Collections.sort(graph[i]); // 인접 노드 오름차순으로 정렬
    }

    dfs(1, stringBuilder);
    System.out.println(stringBuilder);
  }

  public static void dfs(int node, StringBuilder stringBuilder) {
    // 1. 현재 노드 방문 처리
    visited[node] = true;

    // 2. 현재 노드 출력
    stringBuilder.append(node).append(" ");

    // 3. 인접 노드를 순서대로 순회하면서
    for (int n : graph[node]) {
      // 아직 방문 안 했으면 dfs 재귀 호출
      if (!visited[n]) {
        dfs(n, stringBuilder);
      }
    }

  }

}
