package day11.사이클감지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] parent = new int[n+1];
    for (int i=0; i<=n; i++) {
      parent[i] = i;
    }

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // a의 루트와 b의 루트가 같은지 확인 -> 같으면 사이클
      if (find(parent, a) == find(parent, b)) {
        sb.append("YES\n");
      } else {
        // 다르면 union해서 합치기
        union(parent, a, b);
        sb.append("NO\n");
      }
    }
    System.out.print(sb);
  }

  // 루트 찾기
  static int find(int[] parent, int x) {
    if (parent[x] != x) {
      parent[x] = find(parent, parent[x]);
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
