package day19.나머지합;

import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // n개의 수들에서, 연속된 부분 구간의 합이 m으로 나누어떨어지는 구간의 수
    // 누적합을 구하기
    int[] prefix = new int[n+1];
    int sum = 0;
    for (int i=1; i<=n; i++) {
      sum += arr[i-1];
      prefix[i] = sum;
    }

    int[] cnt = new int[m]; // 0~m-1. 누적합을 m으로 나눳을 때 나올 수 있는 나머지 카운트할 배열
    for (int i=0; i<=n; i++) {
      cnt[prefix[i] % m]++; // 누적합의 나머지를 종류별로 카운트
    }

    long result = 0;
    // 누적합끼리 빼는데, 나머지가 같은것들끼리 빼주면 그 구간은 m으로 나누어떨어짐
    // 나머지 같은 수들의 조합 개수
    for (int i=0; i<m; i++) {
      result += ((long) cnt[i] * (cnt[i]-1)) / 2;
    }

    System.out.println(result);
  }
}
