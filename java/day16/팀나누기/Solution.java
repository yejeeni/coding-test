package day16.팀나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

  static int[] parent; // 그룹 저장용
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    parent = new int[n+1];
    for (int i=1; i<=n; i++) {
      parent[i] = i;
    }

    // 그룹이 몇개인지 -> union find로 하기
    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      union(a, b);
    }

    HashSet<Integer> set = new HashSet<>();
    for (int i=1; i<=n; i++) {
      set.add(find(parent[i]));
    }

    System.out.println(set.size());
  }

  static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]); // 경로압축
    }
    return parent[x];
  }

  static void union(int a, int b) {
    int groupA = find(a);
    int groupB = find(b);

    if (groupA != groupB) {
      parent[groupA] = groupB;
    }
  }
}
