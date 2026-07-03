package day8.팀나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int size;
  static int totalStatus;
  static int[] statuses;
  static int min = Integer.MAX_VALUE;
  static int n;
  int[] teamA;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    statuses = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      int status = Integer.parseInt(st.nextToken());
      statuses[i] = status;
      totalStatus += status;
    }

    size = n / 2;

    // 재귀로 팀 고르기
    makeTeam(0, new int[size], 0);
    System.out.println(min);
  }

  /**
   *
   * @param start 탐색 시작점
   * @param team 지금 팀
   * @param depth 현재 팀에 추가한 인원 수
   */
  public static void makeTeam(int start, int[] team, int depth) {
    if (depth == size) { // 모집 끝
      int teamATotal = 0;
      for (int status : team) {
        teamATotal += status; // 팀 A의 능력치 합 계산
      }

      int teamBTotal = totalStatus - teamATotal; // 팀 B의 능력치 합
      int diff = Math.abs(teamATotal - teamBTotal); // 두 팀의 능력치의 차
      
      if (diff < min) {
        min = diff; // 최솟값 갱신
      }

      return;
    }

    // 모집해야 함
    for (int i=start; i<n; i++) {
      team[depth] = statuses[i]; // 수 추가
      // 다시 재귀
      makeTeam(i+1, team, depth+1);
    }
  }
}
