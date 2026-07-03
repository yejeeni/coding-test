package day8.NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

//  N×N 체스판에 N개의 퀸을 서로 공격하지 못하도록 배치하는 경우의 수를 구하라.
//  퀸은 같은 행, 열, 대각선 위의 다른 퀸을 공격한다.

  static int n;
  static int count; // 배치 가능한 경우의 수

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    // 행마다 퀸은 무조건 하나만 위치 가능.
    // 인덱스가 행, col[행]에 저장할 값이 퀸이 위치한 열.
    int[] col = new int[n];
    nQueen(0, col); // 0행부터 퀸 놓으러 가기

    System.out.println(count);
  }

  public static void nQueen(int row, int[] col) {
    if (row == n) { // n행까지 도달한 경우, 모든 행에 퀸을 놓았음. 경우의 수 하나 끝.
      count++;
      return;
    }
    // 퀸은 같은 행, 열, 대각선 위의 다른 퀸을 공격한다.

    for (int c=0; c<n; c++) { // 이 행의 어느 열에 놓을지 탐색
      boolean conflict = false; // 충돌 점검 flag

      for (int r=0; r<row; r++) { // 0행~(row-1)행까지 점검. row뒤는 어차피 배치해두지 않아서 점검할 필요가 없음
        // 만약 '같은 행/열/대각선 에 퀸이 없다면'
        if ((col[r] == c) || (Math.abs(row - r) == Math.abs(c - col[r]))) {
          // r행의 퀸은 col[r]열에 있음. col[r]열이 지금 탐색 중인 c열이면 놓을 수 없음
          // 대각선에 퀸이 있으면 놓을 수 없음. (r1, c1)과 (r2, c2)가 대각선이면 |r1-r2| == |c1-c2|
          conflict = true; // 충돌 발생
          break;
        }
      }

      if (!conflict) { // 이미 놓인 퀸들과 충돌이 없는 경우
        // 지금 탐색 중인 row행의 퀸을 지금 탐색 중인 c열에 배치
        col[row] = c;
        // 다음 행으로 이동
        nQueen(row+1, col);
      }
    }
  }
}
