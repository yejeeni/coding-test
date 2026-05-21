package day5.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int[][] times = new int[n][2];

    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      times[i][0] = Integer.parseInt(st.nextToken());
      times[i][1] = Integer.parseInt(st.nextToken());
    }

    // 시작시간 기준 오름차순 정렬
    Arrays.sort(times, (a, b) ->{
      if (a[1] != b[1]) {
        return a[1] - b[1];
      }
      // 끝시간이 같으면 시작시간 오름차순
      return a[0] - b[0];
    });

    int count = 0;
    int endTime = -1;
    // 겹치지 않게 최대한 많은 회의를 배정
    // 이번타임 시작시간 >= 전타임 종료시간 이면 가능
    for (int i=0; i<n; i++) {
      if (times[i][0] >= endTime) {
        count++;
        endTime = times[i][1];
      }
    }

    System.out.println(count);
  }
}
