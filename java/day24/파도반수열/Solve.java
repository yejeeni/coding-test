package day24.파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve {
  // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12
  static long[] seq = new long[101];

  public static void main(String[] args) throws IOException {
    seq[0] = 0;
    seq[1] = 1;
    seq[2] = 1;
    seq[3] = 1;

    for (int i=4; i<101; i++) {
      seq[i] = seq[i-2] + seq[i-3];
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i=0; i<t; i++) {
      int n = Integer.parseInt(br.readLine());

      System.out.println(seq[n]);
    }
  }
}
