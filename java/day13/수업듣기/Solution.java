package day13.수업듣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] list = new int[n][2];
    for (int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      list[i][0] = start;
      list[i][1] = end;
    }

    Arrays.sort(list, (a, b) -> {
      if (a[1] != b[1]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    int count = 0;
    int lastEnd = -1;
    for (int i=0; i<n; i++) {
      if (lastEnd <= list[i][0]) {
        count++;
        lastEnd = list[i][1];
      }
    }

    System.out.println(count);
  }

}
