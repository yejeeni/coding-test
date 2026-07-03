package day12.빈도수TOPK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> map = new HashMap<>();
    for (int i=0; i<n; i++) {
      String word = br.readLine();
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
    list.sort((a, b) -> {
      if (!a.getValue().equals(b.getValue())) {
        // 등장횟수 높은 순
        return b.getValue() - a.getValue();
      } else {
        // 등장횟수가 같으면 알파벳 오름차순
        return a.getKey().compareTo(b.getKey());
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<k; i++) {
      Entry<String, Integer> entry = list.get(i);
      sb.append(entry.getKey() + " " + entry.getValue() + "\n");
    }

    System.out.println(sb);
  }
}
