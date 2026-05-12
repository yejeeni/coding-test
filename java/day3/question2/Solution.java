package day3.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1. 큐에 1~N enqueue
//2. 큐가 빌 때까지:
//   - K-1번 → dequeue해서 다시 enqueue (앞→뒤로 패스)
//   - 1번 → dequeue하고 결과에 추가
//3. 결과 출력

public class Solution {
  public static void main(String args[]) throws IOException {
//    ArrayDeque를 직접 구현한 원형 큐로 풀기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 앉은 사람 번호 수
    int k = Integer.parseInt(st.nextToken()); // 1번부터 시작해서 제거할 k번째 타겟 번호

    StringBuilder sb = new StringBuilder("<"); // 출력값

    int[] queue = new int[n+1]; // 크기 n+1 원형큐
    int front = 0; // 반환 지점
    int rear = 0; // 삽입 지점
    
    for (int i = 1; i <= n; i++) {
      // enqueue
      queue[rear] = i;
      rear = (rear + 1) % (n + 1); // rear을 1 증가시키고, 순회를 위해 (n+1)의 나머지를 저장
      // 원형 큐는 항상 % capacity로 움직임
    }

    while (front != rear) {  // isEmpty 조건
      // K-1번: 앞에서 꺼내서 뒤에 다시 넣기
      for (int i = 0; i < k - 1; i++) {
        // dequeue 한 값을 enqueue하기
        int val = queue[front]; // front 위치의 값을 꺼내기
        front = (front + 1) % (n + 1); // front 증가
        queue[rear] = val; // rear 위치에 값 넣기
        rear = (rear + 1) % (n + 1); // rear 증가
      }
      // K번째: 꺼내서 결과에 저장
      int val = queue[front]; // front 위치의 값을 꺼내기
      front = (front + 1) % (n + 1); // front 증가
      sb.append(val).append(", ");
    }

    sb.setLength(sb.length() - 2);  // 마지막 ", " 두 개 제거
    sb.append(">");
    System.out.println(sb);
  }

}
