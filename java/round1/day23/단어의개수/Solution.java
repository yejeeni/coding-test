package round1.day23.단어의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    System.out.println(st.countTokens());

    String[] arr = br.readLine().trim().split("\\s+");
    // trim() - 공백제거, \\s+ — 정규식으로 "하나 이상의 공백"
    System.out.println(arr.length);
  }
}
