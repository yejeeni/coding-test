package day19.격자경로수;

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

    int[][] matrix = new int[n+1][m+1];

    for (int i=1; i<=n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=1; j<=m; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dp = new int[n+1][m+1];
    dp[1][1] = 1; // 시작점

    for (int i=1; i<=n; i++) {
      for (int j=1; j<=m; j++) {
        if (i==1 && j==1) {
          continue;
        }
        if (matrix[i][j] == 1) {
          dp[i][j] = 0; // 장애물
        } else {
          dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
      }
    }

    System.out.println(dp[n][m]);
  }
}
