package day22.골드바흐의추측;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    // 소수 구해놓기
    boolean[] isComposite = new boolean[10001];
    isComposite[0] = isComposite[1] = true;

    for (int i=2; i*i<=10000; i++) {
      if (!isComposite[i]) { // 소수면
        // i*i부터 i의 배수들 전부 true
        for (int j=i*i; j<=10000; j+=i) {
          isComposite[j] = true;
        }
      }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i=0; i<t; i++) {
      int n = Integer.parseInt(br.readLine());
      
      // p+q = n 이 되는 값 찾기.
      for (int j=n/2; j<=n; j++) {
        if (!isComposite[j] && !isComposite[n-j]) { // 소수
          System.out.println((n-j) + " " + (j));
          break;
        }
      }
    }
  }
}
