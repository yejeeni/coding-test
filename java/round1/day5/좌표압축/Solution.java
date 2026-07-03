package day5.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
N개의 수가 주어진다. 각 수를 0부터 시작하는 순위(같은 수는 같은 순위)로 변환해서 출력하라.
 */
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    // int[n]에 숫자 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // TreeSet으로 중복 제거, 정렬한 배열 생성
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int num : arr) {
      treeSet.add(num);
    }

    // int[] 순회하면서, TreeSet에서의 순서를 출력
    for (int i=0; i<n; i++) {
      SortedSet<Integer> integers = treeSet.headSet(arr[i]); // n번째 수보다 작은 원소들의 집합
      int rank = integers.size(); // 원소들 개수 = n의 순위

      sb.append(rank);
      if (i < n-1) {
        sb.append(" ");
      }
    }

    System.out.println(sb);
  }
}
