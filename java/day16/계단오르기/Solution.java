package day16.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=1; i<=n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n+1];
    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];
    dp[3] = Math.max(arr[3] + arr[1], arr[3] + arr[2]);

    for (int i=4; i<=n; i++) {
      // 직전칸 점프, 직전칸 밟기
      dp[i] = Math.max(arr[i] + dp[i-2], arr[i] + arr[i-1] + dp[i-3]);
    }

    System.out.println(dp[n]);
  }

}
