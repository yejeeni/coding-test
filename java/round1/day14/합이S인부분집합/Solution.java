package day14.합이S인부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int s;
  static int n;
  static int count;
  static int[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken()); // 배열의 자연수 개수
    s = Integer.parseInt(st.nextToken()); // 합이 s가 되는 부분집합 구하기

    list = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    subSet(0, 0);
    System.out.print(count);
  }

  static void subSet(int index, int sum) {
    if (sum == s) { // 합이 s가 됐으면
      count++;
      return;
    }

    if (index < n) {
      subSet(index + 1, sum); // 집합에 추가 안한 재귀
      subSet(index + 1, sum + list[index]); // 집합에 추가한 재귀
    }


  }
}
