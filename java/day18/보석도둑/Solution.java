package day18.보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] jewelries = new int[n][2];
    // 보석 n개의 무게, 가치
    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      jewelries[i][0] = w;
      jewelries[i][1] = v;
    }

    // 가방 용량
    // 배낭에는 보석을 1개만 넣을 수 있음
    int[] bags = new int[k];
    for (int i=0; i<k; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    // 가벼운 가방부터, 제일 비싼 보석 넣기
    Arrays.sort(bags);
    Arrays.sort(jewelries, (a, b) ->{
      // 가벼운 순, 가치높은 순
      if (a[0] != b[0]) {
        return a[0] - b[0];
      }
      return b[1] - a[1];
    });

    // 지금 가방 무게 이하인 보석들만, 가치 내림차순으로 추가할 pq
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    int j = 0; // 보석 탐색 포인터
    long total = 0;
    for (int bag : bags) {
      // 지금 가방 무게 이하인 보석들 모두 추가
      while((j < n) && (jewelries[j][0] <= bag)) {
        pq.offer(jewelries[j]);
        j++;
      }

      // 넣을 보석이 있다면
      if (!pq.isEmpty()) {
        // 이중 가장 가치 높은 보석 넣기
        total += pq.poll()[1];
      }
    }

    System.out.println(total);
  }
}
