package round2.d0716.배달;

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
    int c = Integer.parseInt(st.nextToken()); // 한번 무게한도

    int[] w = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      w[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(w);

    int left = 0;
    int right = n - 1;

    // 무거운거 먼저 담고, 무게 남으면 가벼운거 넣기
    // 포인터가 만나면 운송 끝
    int result = 0;
    while (left <= right) {
      if (w[right] + w[left] <= c) { // 가벼운거 더넣을수있음
        left++;
      }
      right--; // 무거운거 처리
      result++;
    }
    System.out.println(result);
  }

}
