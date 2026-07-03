package day21.이친수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    // 시작은 무조건 1. 1*** ****
    // 1은 두번연속 X
    // 1, 10, 100, 1000, 10000, 100000
    //        101, 1001, 10001, 100001
    //             1010, 10010, 100010
    //                   10100, 100100
    //                   10101, 100101
    //                          101000
     //                         101001
     //                         101010

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[n+1];
    dp[1] = 1;

    for (int i=2; i<=n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }

    System.out.println(dp[n]);
  }
}
