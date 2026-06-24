package day24.정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solve {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] triangle = new int[n][n];
    for (int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j=0; j<i+1; j++) {
        triangle[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 좌측부모타고옴 vs 우측부모타고옴
    // dp[i][j] = triangle[i][j] + max(dp[i-1][j-1], dp[i-1][j])

    int[][] dp = new int[n][n];
    dp[0][0] = triangle[0][0];

    int max = dp[0][0];
    for (int i=1; i<n; i++) {
      for (int j=0; j<n; j++) {
        // j=0이면 왼쪽 부모 없음
        if (j==0) {
          dp[i][j] = triangle[i][j] + dp[i-1][j];
        } else {
          dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
        }
        if (dp[i][j] > max) {
          max = dp[i][j];
        }
      }
    }

    System.out.println(max);
  }
}
