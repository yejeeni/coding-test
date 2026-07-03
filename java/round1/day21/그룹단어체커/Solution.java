package day21.그룹단어체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String[] args) throws IOException {
    // 한 번 나온 문자는 연속 이외엔 재등장 하면 X
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int result = 0;

    for (int i=0; i<n; i++) {
      String str = br.readLine();
      Set<Character> set = new HashSet<>(); // 나왔던 문자들 모음
      char prev = str.charAt(0); // 직전 문자 비교용
      boolean isGroupWord = true;

      for (int j=0; j<str.length(); j++) {
        char c = str.charAt(j);
        if (set.contains(c)) { // 이미 나왔던 문자인 경우
          // 직전 문자와 다르다면 그룹단어 X
          if (prev != c) {
            isGroupWord = false;
            break;
          }

        } else { // 처음 등장한 문자
          set.add(c);
          prev = c;
        }
      }

      if (isGroupWord) {
        result++;
      }

    }

    System.out.println(result);
  }
}
