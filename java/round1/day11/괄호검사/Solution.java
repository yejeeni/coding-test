package day11.괄호검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i=0; i<t; i++) {
      ArrayDeque<Character> deque = new ArrayDeque<>();
      String readLine = br.readLine();
      String result = "YES";

      for (int j=0; j<readLine.length(); j++) {
        char c = (readLine).charAt(j);

        if (c == '(') {
          deque.push('(');

        } else { // 닫기 괄호 들어옴
          if (deque.isEmpty()) {
            result = "NO";
            break;
          }
            deque.pop();
        }
      }
      if (!deque.isEmpty()) {
        result = "NO";
      }
      System.out.println(result);

    }
  }

}
