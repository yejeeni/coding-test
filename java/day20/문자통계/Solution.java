package day20.문자통계;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int upperCnt = 0, lowerCnt = 0, num = 0, space = 0;

    for (int i=0; i<str.length(); i++) {
      char c = str.charAt(i);
      if (isUpperCase(c)) {
        upperCnt++;
      } else if (isLowerCase(c)) {
        lowerCnt++;
      } else if (isDigit(c)) {
        num++;
      } else {
        space++;
      }
    }

    System.out.println(upperCnt + " " + lowerCnt + " " + num + " " + space);
  }
}
