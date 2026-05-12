package day2.question2;

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    Map<String, Integer> words = new HashMap<>(); // 단어, 빈도수
    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      Integer cnt = words.getOrDefault(s, 0); // getOrDefault(): 키가 있다면 값을 가져오고, 없다면 0을 뱉음
      words.put(s, cnt+1); // 단어가 추가되므로 +1
    }

    int max = 0;
    String word = "";
    for (Map.Entry<String, Integer> entry : words.entrySet()) { // entrySet(): key-value 쌍을 동시에 꺼내기
      String key = entry.getKey();
      Integer val = entry.getValue();
      if (val > max) {
        max = val;
        word = key;
        }
    }

    System.out.print(word + " " + max);
  }
}
