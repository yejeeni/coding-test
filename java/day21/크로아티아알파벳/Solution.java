package day21.크로아티아알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  static String[] cAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String croatia = br.readLine();

    for (String c : cAlphabet) {
      croatia = croatia.replace(c, "0");
    }

    System.out.println(croatia.length());
  }


}
