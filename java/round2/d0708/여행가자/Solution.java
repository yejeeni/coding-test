package round2.d0708.여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int[] plan = new int[m];

    parent = new int[n+1];
    for (int i=0; i<=n; i++) {
      parent[i] = i;
    }

    int[][] map = new int[n+1][n+1];
    for (int i=1;i<=n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j=1;j<=n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      plan[i] = Integer.parseInt(st.nextToken());
    }

    for (int i=1;i<=n; i++) {
      for (int j = 1; j <= n; j++) {
        if (map[i][j] == 1) {
          union(i, j);
        }
      }
    }

    String result = "YES";
    int root = find(plan[0]);
    for (int i=1;i<m; i++) {
      if (root != find(plan[i])) {
        result = "NO";
      }
    }

    System.out.println(result);
  }

  static void union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);

    if (rootA != rootB) {
      parent[rootA] = rootB;
    }
  }

  static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
}
