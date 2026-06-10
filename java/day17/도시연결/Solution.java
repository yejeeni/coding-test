package day17.도시연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 도시
    int m = Integer.parseInt(st.nextToken()); // 도로

    parent = new int[n+1]; // union-find용
    for (int i=0; i<=n; i++) {
      parent[i] = i;
    }

    int[][] edges = new int[m][3]; // 간선
    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      edges[i][0] = a;
      edges[i][1] = b;
      edges[i][2] = c;
    }
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);

    int cost = 0;
    int cityCount = 0;
    for (int[] edge : edges) {
      int rootA = find(edge[0]);
      int rootB = find(edge[1]);

      if (rootA != rootB) {
        union(edge[0], edge[1]);
        cost += edge[2];
        cityCount++;
      }
    }

    if (cityCount < n-1) {
      System.out.println("-1");
    } else {
      System.out.println(cost);
    }
  }

  static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  static void union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);

    if (rootA != rootB) {
      parent[rootA] = rootB;
    }
  }
}
