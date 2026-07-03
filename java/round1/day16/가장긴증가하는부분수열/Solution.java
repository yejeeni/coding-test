package day16.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n];
    Arrays.fill(dp, 1); // 자기자신만 넣은 크기로 부분수열 길이 초기화

    for (int i=0; i<n; i++) {
      for (int j=0; j<i; j++) { // j: 0 ~ i-1
        if (arr[i] > arr[j]) {
          // arr[i] > arr[j]면, j로 끝나는 수열 뒤에 i를 붙일 수 있음 -> dp[i] 갱신 가능
          dp[i] = Math.max(dp[i], dp[j]+1); // 붙인게 길이가 긴지, 그냥 i만 둔게 긴지
        }
      }
    }

    int result = 0;
    for (int i=0; i<n; i++) {
      if (result < dp[i]) {
        result = dp[i];
      }
    }

    System.out.println(result);
  }
}
