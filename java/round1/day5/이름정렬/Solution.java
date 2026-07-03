package day5.이름정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
//    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(br.readLine());
    String[] names = new String[n];
    for (int i=0; i<n; i++) {
      String name = br.readLine();
      names[i] = name;
    }

    Arrays.sort(names, (a, b) -> {
//    이름 길이 오름차순
      if (a.length() != b.length()) {
        return a.length() - b.length();
      } else {
//    길이가 같으면 알파벳 오름차순
        return a.compareTo(b);
      }
    });

    for (String name : names) {
      sb.append(name).append("\n");
    }

    System.out.print(sb);
  }

}
