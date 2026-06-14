package day20.단어뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i=0; i<t; i++) {
      String str = (br.readLine());
      String[] word = str.split(" ");

      StringBuilder sb = new StringBuilder();
      for (int j=0; j<word.length; j++) {
        sb.append(new StringBuilder(word[j]).reverse().toString());
        if (j < word.length-1) {
          sb.append(" ");
        }
      }
      System.out.println(sb);
    }

  }
}
