package day18.타일채우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    /**
     * 세로로 하나 채우거나, 가로로 두개 채워놓거나
     * -> 2*(N-1)이 됨      -> 2*(N-2)이 됨
     */

    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i=2; i<=n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }

    System.out.println(dp[n]);
  }

}
