package day19.최대공약수와최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int gcd = gcd(a, b);
    System.out.println(gcd);
    System.out.println((a*b) / gcd);

  }

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
