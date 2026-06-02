package day15.친구관계전이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());

    parent = new int[n+1];
    for (int i=0; i<=n; i++) {
      parent[i] = i;
    }

    for (int i=0; i<q; i++) {
      st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (cmd == 1) {
        // 친구로 연결
        union(a, b);
      } else {
        // 같은 그룹이면 YES, 아니면 NO 출력
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    }

    System.out.print(sb);
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
