package day19.여행짐싸기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 짐 개수
    int w = Integer.parseInt(st.nextToken()); // 배낭 무게
    int[][] items = new int[n+1][2];

    for (int i=1; i<=n; i++) {
      st = new StringTokenizer(br.readLine());
      items[i][0] = Integer.parseInt(st.nextToken()); // 무게
      items[i][1] = Integer.parseInt(st.nextToken()); // 필요도
    }

    int[][] dp = new int[n+1][w+1];

    //          무게
    //          --------
    // 아이템  | 최대가치 = 지금본거 넣거나 안넣거나...
    for (int i=1; i<=n; i++) { // 지금 보는 아이템
      int[] item = items[i];

      for (int j=1; j<=w; j++) { // 가방 무게 1~w
        // 넣을 수 있는 경우
        if (j - item[0] >= 0) {
          // 넣은것 vs 안넣은것
          dp[i][j] = Math.max(dp[i-1][j-item[0]] + item[1], dp[i-1][j]);
        } else { // 못 넣는 경우
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    System.out.println(dp[n][w]);
  }
}
