package day16.BOJ9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int[] dp = new int[11];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i=4; i<=10; i++) {
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    for (int i=0; i<t; i++) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(dp[n]);
    }
  }
}


// n을 1, 2, 3의 합으로 나타내는 방법의 수...
/**
 * 2:        3            4           5
 * 1 1       1 1 1        1 1 1 1     1 1 1 1 1
 * 2         2 1          1 1 2       1 1 1 2
 *           1 2          1 2 1       1 1 2 1
 *           3            2 1 1       1 2 1 1
 *                        1 3         2 1 1 1
 *                        2 2         2 1 2
 *                        3 1         2 2 1
 *                                    1 2 2
 *                                    2 3
 *                                    3 1 1
 *                                    1 3 1
 *                                    1 1 3
 *                                    3 2
 *
 *1 2          4            7          13
 * dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
 */
