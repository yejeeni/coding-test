package day23.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solve {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // 격자 사이즈
    int k = Integer.parseInt(br.readLine()); // 사과 수

    boolean[][] apple = new boolean[n + 1][n + 1];
    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      // 사과 위치 r c
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      apple[r][c] = true;
    }

    int l = Integer.parseInt(br.readLine()); // 방향전환 수
    HashMap<Integer, String> cmd = new HashMap<>();
    for (int i = 0; i < l; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      // X초 후, 방향
      int x = Integer.parseInt(st.nextToken());
      String d = st.nextToken();
      cmd.put(x, d);
    }

    int time = 0;
    // 오른쪽, 아래, 왼쪽, 위
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int d = 0;
    // 머리 위치
    int headR = 1;
    int headC = 1;

    ArrayDeque<int[]> snake = new ArrayDeque<>(); // 뱀 좌표 순서대로 저장
    snake.addFirst(new int[]{1, 1}); // 시작 위치

    boolean[][] body = new boolean[n + 1][n + 1]; // 좌표에 뱀 몸통이 있는지 저장
    body[1][1] = true; // 시작 위치

    while (true) {
      time++; // 시간 증가
      int nr = headR + dr[d]; // 다음 위치
      int nc = headC + dc[d];

//    벽 충돌 종료
//    자기 몸 충돌 종료
      if (nr < 1 || nr > n || nc < 1 || nc > n || body[nr][nc]) {
        break;
      }

//      새 머리 추가
      snake.addFirst(new int[]{nr, nc});
      body[nr][nc] = true;

//      사과 있으면 -> false (사과 제거), 꼬리 유지
      if (apple[nr][nc]) {
        apple[nr][nc] = false; // 사과 제거
      } else {
//      사과 없으면 -> 꼬리 제거 (pollLast)
        int[] tail = snake.pollLast();
        body[tail[0]][tail[1]] = false;
      }

      // 머리 다음 칸으로 이동
      headR = nr;
      headC = nc;

      // 방향 전환
      if (cmd.containsKey(time)) {
        String distance = cmd.get(time);
        if (distance.equals("D")) { // 왼쪽 회전
          d = (d + 1) % 4;
        } else {
          d = (d - 1 + 4) % 4; // d가 0이면 음수가 돼서 +4로 조정
        }
      }
    }

    System.out.println(time);
  }
}
