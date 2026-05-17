package day6.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // 개수
    int m = Integer.parseInt(st.nextToken()); // 필요 길이
    int h = 0;

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int low = 0;
    int high = 0;
    for (int height : arr) {
      if (height > high)  {
        high = height;
      }
    }

    int mid = 0;
    while (low <= high) {
      mid = (low + high) / 2;

      // 잘린합 구하기
      long sum = 0;
      for (int heights : arr) {
        if (heights > mid) { // 높이가 mid보다 큰 나무만 잘림
          sum += (heights - mid);
        }
      }

      if (sum >= m) { // 잘린합이 m 이상임
        h = mid;
        // 더 큰 h가 존재할 수 있으므로 low 증가
        low = mid + 1;
      } else { // 잘린합이 필요한 나무길이보다 작음
        // h를 줄여야 함
        high = mid - 1;
      }
    }

    System.out.println(h);
  }

}
