package day7.단어빈도수;

import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) throws  IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    HashMap<String, Integer> hashMap = new HashMap<>(); // 단어-빈도수 저장할 해시맵

    int n = Integer.parseInt(br.readLine());
    for (int i=0; i<n; i++) {
      String word = br.readLine();
      hashMap.put(word, hashMap.getOrDefault(word, 0) + 1); // getOrDefault로 기존값이나 0을 반환하게 해서 +1
    }

    List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet()); // hashMap 정렬할 배열
    list.sort((a, b) -> {
      // 빈도수 내림차순, 알파벳 오름차순으로 하기
      int cmp = b.getValue() - a.getValue();
      if (cmp != 0) {
        return cmp; // b.getValue() - a.getValue();
      } else {
        return a.getKey().compareTo(b.getKey());
      }
    });

    // "단어 횟수" 형식으로 한 줄씩 출력
    for (Map.Entry<String, Integer> entry : list) {
      sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
    }

    System.out.println(sb);
  }

}
