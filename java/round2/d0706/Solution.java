package round2.d0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // 1~N까지의 수 중
    int m = Integer.parseInt(st.nextToken()); // M개 고른 순열 사전순 출력

    boolean[] visited = new boolean[n+1];
    int[] arr = new int[m];

    per(0, visited, n, m, arr);
  }

  static void per(int depth, boolean[] visited, int n, int m, int[] arr) {
    if (depth == m) {
      for (int i=0; i<arr.length; i++) {
        System.out.print(arr[i] + " ");

      }
      System.out.println();
      return;
    }

    for (int i=1; i<=n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        per(depth+1, visited, n, m, arr);

        visited[i] = false;
      }
    }
  }
}

