package day17.평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] items = new int[n+1][2];
    for (int i=1; i<=n; i++) {
      st = new StringTokenizer(br.readLine());
      items[i][0] = Integer.parseInt(st.nextToken()); // 무게
      items[i][1] = Integer.parseInt(st.nextToken()); // 가치
    }

    int[][] dp = new int[n+1][k+1]; // 물건/배낭무게
    // 지금 보는 물건을 무게보고 넣을지말지, 그때의 최대가치
    for (int i=1; i<=n; i++) { // 체크 중인 물건
      int[] item = items[i];

      for (int j=0; j<=k; j++) { // 현재 가능한 무게
        if (j-item[0] >= 0) { // 담을 수 있는 경우
          // 담는다, 안 담는다 중 최대값
          dp[i][j] = Math.max(item[1] + dp[i-1][j-item[0]], dp[i-1][j]);
        } else { // 못 담는 경우
          dp[i][j] = dp[i-1][j];
        }
      }
    }

//    int max = 0;
//    for (int i=0; i<=n; i++) {
//      for (int j=0; j<=k; j++) {
//        if (max < dp[i][j]) {
//          max = dp[i][j];
//        }
//      }
//    }
//    System.out.println(max);

    System.out.println(dp[n][k]);
  }
}
