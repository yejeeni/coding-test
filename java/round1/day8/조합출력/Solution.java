package day8.조합출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int[] arr = new int[m];

    // 재귀로 탐색
    combination(0, 1, arr);
  }

  // 1부터 N까지의 수 중에서 M개를 골라 오름차순으로 출력하라.
  // 같은 수를 여러 번 고를 수 없고, 고른 수는 오름차순이어야 한다.
  public static void combination(int size, int start, int[] arr) {
    if (size == m) { // m개를 모두 고른 경우
      StringBuilder sb = new StringBuilder();
      for (int num : arr) {
        sb.append(num).append(" ");
      }
      System.out.println(sb);
      // 탐색 종료
      return;
    }

    for (int i=start; i<=n; i++) {
      arr[size] = i;
      combination(size+1, i+1, arr);
    }
  }
}
