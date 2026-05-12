package day3.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();

    int[] inStack = new int[100000 + 1];
    int[] outStack = new int[100000 + 1];
    int inTop = -1, outTop = -1;

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();

      if (cmd.equals("push")) { // 값 v를 큐에 삽입
        int val = Integer.parseInt(st.nextToken()); // 삽입할 값
        inStack[++inTop] = val; // inTop 증가시키고 삽입

      } else if (cmd.equals("pop")) { // 큐의 맨 앞 값을 제거하고 출력. 큐가 비어있으면 -1 출력
        if (inTop == -1 && outTop == -1) { // 넣은 개수 == 꺼낸 개수면 비어있음
          sb.append("-1").append("\n");
          continue;
        }

        if (outTop == -1) {
          // outStack이 비어있으면, FIFO 형식으로 꺼낼 수 있게 inStack의 값을 뒤에서부터  outStack에 저장
          while (inTop >= 0) { // inStack이 빌 때까지 반복
            outStack[++outTop] = inStack[inTop--];
          }
        }

        int val = outStack[outTop--]; // outStack에서 값 반환
        sb.append(val).append("\n");

      } else { // 현재 큐에 들어있는 원소 수 출력
        sb.append(inTop + outTop + 2).append("\n");
      }
    }
    System.out.print(sb);
  }
}
