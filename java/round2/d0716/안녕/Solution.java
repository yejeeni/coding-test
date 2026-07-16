package round2.d0716.안녕;

import java.io.*;
import java.util.*;

public class Solution {

  // 99까지 쓸수있음
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n+1][100]; // [0]번째 사람까지 탐색했을때, 체력을 [1] 썼을 때의 최대 기쁨

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] hits = new int[n+1];
    for (int i=1; i<=n; i++) {
      hits[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int[] joys = new int[n+1];
    for (int i=1; i<=n; i++) {
      joys[i] = Integer.parseInt(st.nextToken());
    }

    for (int i=1; i<=n; i++) {
      int hit = hits[i]; // 지금 사람이랑 인사하면 잃는 체력
      int joy = joys[i]; // 지금 사람이랑 인사하면 얻는 기쁨

      for (int j=0; j<100; j++) {
        if (hit > j) { // 인사못함
          dp[i][j] = dp[i-1][j];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-hit] + joy);
        }
      }
    }

    System.out.println(dp[n][99]);
  }
}
