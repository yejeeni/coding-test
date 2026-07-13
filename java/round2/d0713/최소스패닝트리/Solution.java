package round2.d0713.최소스패닝트리;

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
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int[][] edges = new int[E][3]; // {u, v, w}
    parent = new int[V+1];
    for (int i=0; i<=V; i++) {
      parent[i] = i;
    }

    for (int i=0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      edges[i] = new int[]{A, B, C};
    }
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);

    int result = 0;
    for (int i=0; i<E; i++) {
      int[] edge = edges[i];
      if (union(edge[0], edge[1])) {
        result += edge[2];
      }
    }

    System.out.println(result);
  }

  static boolean union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    if (rootA != rootB) {
      parent[rootA] = rootB;
      return true;
    } else {
      return false;
    }
  }

  static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }

    return parent[x];
  }
}
