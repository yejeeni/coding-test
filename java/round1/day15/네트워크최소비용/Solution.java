package day15.네트워크최소비용;

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

    int n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
    int m = Integer.parseInt(st.nextToken()); // 케이블 수

    parent = new int[n+1];
    for (int i=0; i<=n; i++) {
      parent[i] = i;
    }

    // 간선목록 2차원 배열
    int[][] edges = new int[m][3];
    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      edges[i][0] = a;
      edges[i][1] = b;
      edges[i][2] = w;
    }

    // 가중치순 정렬
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);

    int w = 0;
    int cnt = 0;
    for (int[] edge : edges) {
      int rootA = find(edge[0]);
      int rootB = find(edge[1]);

      if (rootA != rootB) {
        union(edge[0], edge[1]);
        w += edge[2];
        cnt++;
      }
    }

    if (cnt != n-1) {
      System.out.println("-1");
    } else {
      System.out.println(w);
    }


  }

  static int find(int x) {
    if (parent[x] != x) {
      return parent[x] = find(parent[x]);
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
