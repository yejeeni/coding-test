package day1.구간합;

import java.util.*;
import java.io.*;

public class 구간합 {
  public static void main(String args[]) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    // 첫 줄에 정수 N과 Q가 주어진다.
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int q = Integer.parseInt(stringTokenizer.nextToken());

    long[] arr = new long[n+1];

    // 둘째 줄에 N개의 정수가 공백으로 주어진다.
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i=1; i<n+1; i++){
      long num =  Long.parseLong(stringTokenizer.nextToken());

      // 누적합을 저장
      arr[i] = arr[i-1] + num;
    }

    StringBuilder stringBuilder = new StringBuilder();
    // 다음 Q줄에는 두 정수 l, r이 주어진다.
    for (int i=0; i<q; i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int l = Integer.parseInt(stringTokenizer.nextToken());
      int r = Integer.parseInt(stringTokenizer.nextToken());

      // l번째부터 r번째 수 합 출력
      stringBuilder.append(arr[r] - arr[l-1]).append('\n');
    }
    System.out.print(stringBuilder);
  }
}
