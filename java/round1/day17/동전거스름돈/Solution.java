package day17.동전거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] coins = new int[n+1];
    for (int i=1; i<=n; i++) {
      coins[i] = Integer.parseInt(st.nextToken());
    }

    // dp[i][j] = i번째 동전까지 사용할 때, 금액 j를 만드는 최소 동전 수
    int[][] dp = new int[n+1][m+1];
    for (int[] row : dp) {
      Arrays.fill(row, Integer.MAX_VALUE); // 못만듦 표시
    }
    for (int i=0; i<=n; i++) {
      dp[i][0] = 0;
    }

    for (int i=1; i<=n; i++) {
      int coin = coins[i]; // 지금 보는 코인
      
      for (int j = 1; j <= m; j++) {
        if (j >= coin) { // 코인을 사용 가능한 경우
          if (dp[i][j - coin] != Integer.MAX_VALUE) { // j-coin 금액을 만들어놓았음
            // 쓰는 경우(dp[i][j-coin]+1) 와 안 쓰는 경우(dp[i-1][j]) 중 최솟값
            dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
          } else { // j-coin 금액을 만들 수가 없음
            dp[i][j] = dp[i - 1][j];
          }

        } else { // 이 동전 너무 커서 못 씀
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    if (dp[n][m] == Integer.MAX_VALUE) {
      System.out.println("-1");
    } else {
      System.out.println(dp[n][m]);
    }
  }
}
