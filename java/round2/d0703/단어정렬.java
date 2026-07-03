package round2.d0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class 단어정렬 {

//  길이가 짧은 단어 먼저
//  길이가 같으면 사전순
//  중복 제거 (같은 단어는 한 번만 출력)
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    TreeSet<String> words = new TreeSet<>((a, b) -> {
      if (a.length() != b.length()) {
        return a.length() - b.length();
      } else {
        return a.compareTo(b);
      }
    });

    for (int i=0; i<n; i++) {
      String word = br.readLine();
      words.add(word);
    }

    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      sb.append(word).append("\n");
    }

    System.out.print(sb);
  }
}
