package day1.수열역출력;

import java.io.*;
import java.util.*;

public class 수열역출력 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // n 입력받기
    int n = Integer.parseInt(br.readLine().trim());

    // N개의 정수 입력받기
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

    // 반복문을 통해 배열에 N개의 정수 저장
    int[] arr = new int[n];
    for (int i=0; i<n; i++) {
      arr[i] = (Integer.parseInt(stringTokenizer.nextToken()));
    }

//    for (int i=n-1; i>=0; i--) {
//      System.out.print(arr[i] + " ");
//    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int i=n-1; i>=0; i--) {
      if (i < n-1) {
        stringBuilder.append(' ');
      }
      stringBuilder.append(arr[i]);
    }

    System.out.print(stringBuilder);
  }
}
