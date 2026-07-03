package day18.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] meeting = new int[n][2];

    for (int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      meeting[i][0] = Integer.parseInt(st.nextToken());
      meeting[i][1] = Integer.parseInt(st.nextToken());
    }

    // 일찍 끝나는 순, 같다면 일찍 시작하는 순
    Arrays.sort(meeting, (a, b) -> {
      if (a[1] != b[1]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });

    int count = 0;
    int latest = -1;
    for (int[] meet : meeting) {
      if (latest <= meet[0]) { // 시작시간이 마지막 종료시간 이후
        count++; // 회의
        latest = meet[1];
      }
    }

    System.out.println(count);
  }
}
