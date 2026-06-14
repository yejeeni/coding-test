package day20.작업스케줄러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String args[]) throws IOException {
    // 작업 {마감시간, 보상}
    // 하루에 작업 하나만
    // 마감시간 d일 내 처리시 보상
    // 마감시한 넘긴 작업은 버림

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] works = new int[n][2];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      works[i][0] = Integer.parseInt(st.nextToken()); // 마감시한 d
      works[i][1] = Integer.parseInt(st.nextToken()); // 보상 w
    }

    // 마감시간 빠른순, 보상 큰 순 정렬
    Arrays.sort(works, (a, b) -> {
      if (a[0] != b[0]) {
        return a[0] - b[0];
      }
      return b[1] - a[1];
    });

    // 하루에 작업 하나만 가능... 마감시간이 같은 것중엔 보상 큰것만 가능.
    int reward = 0;

    // 처리할 작업들.. 가치 작은 순으로 해서, 가치가 떨어지는건 버리기
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    for (int work[] : works) {
      pq.offer(work); // pq에 추가

//      if (!pq.isEmpty()) {
        // 현재 작업의 디데이보다 많은 작업이 담김
        if (pq.size() > work[0]) {
          pq.poll(); // 가치 낮은 작업 제거
        }
//      }
    }

    while (!pq.isEmpty()) {
      reward += pq.poll()[1];
    }

    System.out.println(reward);
  }
}