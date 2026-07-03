package day4.실시간중앙값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // 중앙값 이하 숫자 모음. 큰 순으로 우선순위라 top이 항상 중앙값임
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 중앙값 초과 숫자 모음. 작은 것 우선순위. 작은 순으로 우선순위라 top은 중앙값보다 한 단계 더 큰 수

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      int num = Integer.parseInt(st.nextToken());

//  // 처음 값 들어오면 걍 max힙에 저장
      if (maxHeap.isEmpty()) {
        maxHeap.offer(num);
      } else {
        if (maxHeap.peek() > num) { // 중앙값보다 크면
          maxHeap.offer(num);
        } else {
          minHeap.offer(num);
        }
      }

//  // 개수정리
      while (maxHeap.size() < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
      while (maxHeap.size() > minHeap.size() + 1) {  // maxHeap이 2 이상 크면
        minHeap.offer(maxHeap.poll());
      }
      //print(maxHeap 마지막원소)
      if (i > 0) {
        sb.append(" ");
      }
      sb.append(maxHeap.peek());
    }
    System.out.println(sb);
  }
}
