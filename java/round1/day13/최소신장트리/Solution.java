package day13.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] parent = new int[n + 1]; // 루트 정보
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }

    int[][] edges = new int[m][3]; // 간선 목록
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()); // 노드 a
      int b = Integer.parseInt(st.nextToken()); // 노드 b
      int w = Integer.parseInt(st.nextToken()); // 가중치

      edges[i][0] = a;
      edges[i][1] = b;
      edges[i][2] = w;
    }
    // 간선 가중치 오름차순 정렬
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);

    long totalWeight = 0;
    int count = 0;
    // 간선을 순차적으로 union-find
    for (int[] edge : edges) {
      if (find(parent, edge[0]) == find(parent, edge[1])) {
        continue; // 사이클
      } else {
        union(parent, edge[0], edge[1]);
        totalWeight += edge[2];
        count++;
      }

      if (count == n-1) {
        break;
      }
    }

    System.out.println(totalWeight);
  }



  // 루트 찾기
  static int find(int[] parent, int x) {
    if (parent[x] != x) {
      return parent[x] = find(parent, parent[x]);
    }

    return parent[x];
  }

  // 합치기
  static void union(int[] parent, int a, int b) {
    int rootA = find(parent, a);
    int rootB = find(parent, b);

    if (rootA != rootB) {
      parent[rootA] = rootB;
    }
  }
}
