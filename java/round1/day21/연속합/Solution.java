package day21.연속합;

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

    int dp[] = new int[n+1];
    dp[1] = arr[1];
    int max = arr[1];
    for (int i=1; i<=n; i++) {
      dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
