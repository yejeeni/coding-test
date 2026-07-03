package day16.LCS길이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String a = br.readLine();
    String b = br.readLine();

    int[][] dp = new int[a.length()+1][b.length()+1]; // 0 안씀

    for (int i=1; i<=a.length(); i++){
      for (int j=1; j<=b.length(); j++) {
        // 문자가 같음
        if (a.charAt(i-1) == b.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1] + 1; // 공통부분+
        } else {
          // 문자가 다름
          // a나 b 중 컸던 거로 선택
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    System.out.println(dp[a.length()][b.length()]);
  }

}
