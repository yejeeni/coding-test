package day16.값1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n+1];

    /**
     *  * dp[i] = 1 + dp[i-1]
     *  * if (i%3 == 0) 1 + dp[i/3]과도 비교
     *  * if (i%2 == 0) 1 + dp[i/2]과도 비교
     */
    for (int i=2; i<=n; i++) {
      dp[i] = 1 + dp[i-1];

      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], 1 + dp[i/3]);
      }

      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], 1 + dp[i/2]);
      }
    }

    System.out.println(dp[n]);
  }
}
