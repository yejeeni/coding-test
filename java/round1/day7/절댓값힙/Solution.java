package day7.절댓값힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 절대값 기준 오름차순 해두고, 절댓값이 같으면 음수를 먼저 출력한다.
    // if |a| != |b| ? |a| - |b| 중 작은 수 : a - b
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
      if (Math.abs(a) != Math.abs(b)) {
        return Math.abs(a) - Math.abs(b);
      } else {
        return a - b;
      }
    });

    int n = Integer.parseInt(br.readLine());
    for (int i=0; i<n; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x != 0) { //      x ≠ 0이면 힙에 x 삽입
        priorityQueue.offer(x);

      } else {     //      x == 0이면 절댓값 최솟값 출력·제거
        if (priorityQueue.isEmpty()) {//        힙이 비어있을 때 출력 연산이 들어오면 0을 출력한다.
          sb.append("0").append("\n");

        } else {
          int num = priorityQueue.poll();
          sb.append(num).append("\n");
        }
      }
    }
    System.out.println(sb);
  }
}
