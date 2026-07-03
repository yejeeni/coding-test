package day14.섬연결하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 섬 수
    int m = Integer.parseInt(st.nextToken()); // 다리 수

    int[] parent = new int[n+1];
    for (int i=0; i<=n; i++) {
      parent[i] = i;
    }

    int[][] edges = new int[m][3]; // 섬1, 섬2, 가중치
    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()); // 섬 a
      int b = Integer.parseInt(st.nextToken()); // 섬 b
      int w = Integer.parseInt(st.nextToken()); // 비용 w

      edges[i][0] = a;
      edges[i][1] = b;
      edges[i][2] = w;
    }

    Arrays.sort(edges, (a, b) -> a[2] - b[2]);

    int weight = 0;
    int cnt = 0;
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];

      if (find(parent, a) == find(parent, b)) {
        continue;
      } else {
        union(a, b, parent);
        weight += edge[2];
        cnt++;
      }

      if (cnt == n-1) {
        break;
      }
    }

    if (cnt == n-1) {
      System.out.println(weight);
    } else {
      System.out.println("-1");
    }

  }

  static int find(int[] parent, int n) {
    if (parent[n] != n) {
      return find(parent, parent[n]);
    }

    return parent[n];
  }

  static void union(int a, int b, int[] parent) {
    int rootA = find(parent, a);
    int rootB = find(parent, b);

    if (rootA != rootB) {
      parent[rootA] = rootB;
    }
  }
}
