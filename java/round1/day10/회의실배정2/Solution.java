package day10.회의실배정2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] list = new int[n][2];

    for (int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int si = Integer.parseInt(st.nextToken());
      int ei = Integer.parseInt(st.nextToken());
      list[i][0] = si;
      list[i][1] = ei;
    }

    // 시작시간 순으로 오름차순
    Arrays.sort(list, (a, b) -> {
      if (a[0] != b[0]) {
        return a[0] - b[0];
      } else {
        // 시작시간이 같으면 끝시간 순으로 오름차순
        return a[1] - b[1];
      }
    });

    // 회의를 모두 진행하기 위해 필요한 최소 회의실 수를 구하여라.

    PriorityQueue<Integer> eiPQ = new PriorityQueue<>(); // 지금 진행중인 회의의 종료시간 목록
    for (int[] meeting : list) {
      if (!eiPQ.isEmpty()) { // 진행중인 회의가 있음
        // 제일 빨리 끝나는 회의의 종료시간이, 현재 열릴 회의의 시작시간 이하인 경우
        if (eiPQ.peek() <= meeting[0]) {
          // 해당 회의 삭제
          eiPQ.poll();
        }
      }

      eiPQ.offer(meeting[1]); // 지금 진행중인 회의의 종료시간 추가
    }

    System.out.println(eiPQ.size());


  }
}
