package day16.격자최대합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] matrix = new int[n+1][m+1]; // 0은 안 씀

    for (int i=1; i<=n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=1; j<=m; j++) {
        int x = Integer.parseInt(st.nextToken());
        matrix[i][j] = x;
      }
    }

    // 1열의 값들은 위에서만 오기 가능
    for (int i=1; i<=n; i++) {
      matrix[i][1] += matrix[i-1][1];
    }
    // 1행의 값들은 왼쪽에서만 오기 가능
    for (int j=1; j<=m; j++) {
      matrix[1][j] += matrix[1][j-1];
    }

    // 왼쪽에서 오거나, 위에서 내려오거나 중 큰 값
    for (int i=2; i<=n; i++) {
      for (int j=2; j<=m; j++) {
        matrix[i][j] += Math.max(matrix[i][j-1], matrix[i-1][j]);
      }
    }

    System.out.println(matrix[n][m]);
  }
}
