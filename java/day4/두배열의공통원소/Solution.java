package day4.question1;

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    // 배열 a를 hashset으로 저장해놓고, 배열 b를 입력받으면서 contains로 들어있는지 확인하고 저장
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken()); // 배열 A의 원소 개수
    HashSet<Integer> aHashSet = new HashSet<>(); // 배열 a를 저장할 해시 set

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int aNum = Integer.parseInt(st.nextToken());
      aHashSet.add(aNum);
    }

    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken()); // 배열 B 원소 개수

    ArrayList<Integer> result = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int bNum = Integer.parseInt(st.nextToken());
      if (aHashSet.contains(bNum)) { // 중복 숫자인 경우
        result.add(bNum);
      }
    }

    // 오름차순 정렬
    Collections.sort(result);
    for (int i = 0; i < result.size(); i++) {
      if (i > 0) {
        sb.append(" ");
      }
      sb.append(result.get(i));
    }

    System.out.println(sb);
  }

}
