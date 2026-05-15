package day2.question1;

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int[] nums = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    long sum = 0;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      sum += num;

      if (num > max) {
        max = num;
      }
    }

    System.out.print(sum + " " + max);
  }
}
