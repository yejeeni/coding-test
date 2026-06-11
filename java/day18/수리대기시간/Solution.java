package day18.수리대기시간;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] times = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      times[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(times);

    long t = 0;
    long result = 0;
    for (int time : times) {
      t += time;
      result += t;
    }

    System.out.println(result);
  }
}
