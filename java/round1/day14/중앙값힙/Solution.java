package day14.중앙값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 중앙값 이하. top을 뽑으면 중앙값이 나오도록 reverseOrder
    PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
    // 중앙값 초과
    PriorityQueue<Integer> upper = new PriorityQueue<>();

    int n = Integer.parseInt(br.readLine());
    for (int i=0; i<n; i++) {
      int num = Integer.parseInt(br.readLine());

      // 지금 중앙값보다 큰게 들어옴
      if (lower.isEmpty() || lower.peek() >= num) {
        lower.offer(num); // 초과 배열에 추가
      } else {
        upper.offer(num);
      }

      // 양쪽 갯수가 맞게 조정
      // lower가 upper보다 작다면, upper의 가장 작은 수를 lower에 옮기기
      while(lower.size() < upper.size()) {
        lower.offer(upper.poll());
      }

      // lower은 최대 upper + 1
      // lower의 가장 큰 수를 upper에 옮기기
      while(lower.size() > upper.size() + 1) {
        upper.offer(lower.poll());
      }

      sb.append(lower.peek()).append("\n");
    }

    System.out.print(sb);
  }
}
