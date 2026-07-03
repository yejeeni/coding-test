package day11.집합판별기;

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
      parent[i] = i; // 자기 자신을 루트로 저장
    }

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (cmd == 0) { // a와 b를 같은 집합으로 합친다
        union(a, b, parent);

      } else { // a와 b가 같은 집합이면 "YES", 아니면 "NO" 출력
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    }
    System.out.print(sb);
  }

  // 루트 찾기
  static int find(int x, int[] parent) {
    if (parent[x] != x) {
      parent[x] = find(parent[x], parent);
    }
    return parent[x];
  }

  // 합치기
  static void union(int a, int b, int[] parent) {
    int rootA = find(a, parent);
    int rootB = find(b, parent);

    if (rootA != rootB) {
      parent[rootA] = rootB;
    }
  }

}
