package day20.문서검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String doc = br.readLine();
    String word = br.readLine();

    int cnt = 0;
    int i = 0;
    while (i <= doc.length()-word.length()) {
      if (doc.substring(i, i+word.length()).equals(word)) {
        cnt++;
        i += word.length();
      } else {
        i++;
      }
    }

    System.out.println(cnt);
  }
}
