package day17.동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 동전 수
    int k = Integer.parseInt(st.nextToken()); // 만들 금액

    int[] coins = new int[n];
    for (int i=0; i<n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    // 동전들로 금액 k 만들기. 동전은 무한히 사용 가능...
    int[][] dp = new int[n+1][k+1];
    for (int i=0; i<=n; i++) {
      dp[i][0] = 1;
    }

    for (int i=1; i<=n; i++) {
      int coin = coins[i-1];
      for (int j=1; j<=k; j++) {
        if (coin <= j) {
          dp[i][j] = (dp[i][j - coin]) + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    System.out.println(dp[n][k]);
  }
}
