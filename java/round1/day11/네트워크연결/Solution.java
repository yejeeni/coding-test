package day11.네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
    int m = Integer.parseInt(st.nextToken()); // 현재 케이블 수
    int[] parent = new int[n+1];
    for (int i=0; i<=n; i++) {
      parent[i] = i;
    }

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // 입력받으면서 합쳐주기
      union(parent, a, b);
    }

    HashSet<Integer> roots = new HashSet<>();
    for (int i=1; i<=n; i++) {
      int root = find(parent, i);
      roots.add(root);
    }

    System.out.println(roots.size()-1); // 루트끼리 연결시키는 데에 드는 케이블 수
  }

  static int find(int[] parent, int x) {
    if (parent[x] != x) {
      parent[x] = find(parent, parent[x]);
    }
    return parent[x];
  }

  static void union(int[] parent, int a, int b) {
    int rootA = find(parent, a);
    int rootB = find(parent, b);

    if (rootA != rootB) {
      parent[rootA] = rootB;
    }
  }
}
