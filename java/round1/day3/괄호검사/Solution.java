package day3.괄호검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// int[] + top 인덱스로 스택 구현: push = ++top, pop = top--
// ) 나왔을 때 top==-1이면 즉시 NO (닫을 괄호 없음)
// 루프 종료 후 top != -1이면 NO (안 닫힌 괄호 남음)

//배열 스택과 ArrayDeque는 로직 동일, 표현만 다름
//  - top == -1       ↔  stack.isEmpty()
//  - stack[++top]=x  ↔  stack.push(x)
//  - top--           ↔  stack.pop()

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String str = st.nextToken();
    String result = "YES";

    int[] stack = new int[str.length()];
    int top = -1; // 비어있음

    for (int i=0; i<str.length(); i++) {
      char c = str.charAt(i);
      // ( 이면 push, ) 이면 pop
      if (c == '(') {
        // push: stack[++top];
        ++top;
      } else { // c == ')'
        if (top == -1) { // 닫을 괄호가 없는데 ) 가 나옴
          result = "NO";
          break;
        }
        // pop:  stack[top--];
        top--;
      }
    }

    if (top != -1) { // 닫을 괄호가 아직 남은 경우
      result = "NO";
    }

    System.out.println(result);
  }
}
