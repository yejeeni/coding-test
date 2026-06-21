package day23.로봇이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  // 상, 하, 좌, 우
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken()); // 초기 위치
    int c = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(br.readLine());

    String cmds = br.readLine();
    for (int i = 0; i < k; i++) {
      char cmd = cmds.charAt(i);

      if (cmd == 'U') {
        if (coordinatesCheck(r + dr[0], c + dc[0])) {
          r += dr[0];
          c += dc[0];
        }
      } else if (cmd == 'D') {
        if (coordinatesCheck(r + dr[1], c + dc[1])) {
          r += dr[1];
          c+= dc[1];
        }
      } else if (cmd == 'L') {
        if (coordinatesCheck(r + dr[2], c + dc[2])) {
          r += dr[2];
          c += dc[2];
        }
      } else if (cmd == 'R') {
        if (coordinatesCheck(r + dr[3], c + dc[3])) {
          r += dr[3];
          c +=  dc[3];
        }
      }
    }

    System.out.println(r + " " + c);
  }

  static boolean coordinatesCheck(int a, int b) {
    if (0 < a && a <= n && 0 < b && b <= m) {
      return true;
    } else {
      return false;
    }
  }
}