package day7.랜선자르기;

import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    // 이진탐색으로 풀기. low = 1, high = 랜선 길이 최댓값
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    long low = 1;
    long high = -1;
    long max = 0;
    int[] lengths = new int[k];

    for (int i=0; i<k; i++) {
      int length = Integer.parseInt(br.readLine());
      lengths[i] = length;

      if (length > high) {
        high = length;
      }
    }

    while (low <= high) {
      long mid = (low + high) / 2; // 오버플로우가 문제면 int mid = low + (high - low) / 2; 이렇게 하는 방법도 있음
     // 각 랜선 잘라서 길이 mid 랜선이 몇 개 나오는지 계산
      long sum = 0;
      for (int length : lengths) {
         sum += length / mid;
      }

      if (sum >= n) { // 잘린 랜선 개수가 n 이상
        max = mid;
        // 더 길게 자를 수 있는지 봐야함
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    System.out.println(max);
  }

}
