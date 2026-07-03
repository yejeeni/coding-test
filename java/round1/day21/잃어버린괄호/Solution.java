package day21.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    // -가 나오면, 다음 -가 나올 때까지 괄호에 포함시키기 (없으면 걍 끝까지만 하고)
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] groups = str.split("-"); // 마이너스단위로 끊기
    // 묶음 요소들끼리는 다 더하고, 묶음끼리는 빼주고...

    int result = 0;
    for (int i=0; i<groups.length; i++) {
      String[] nums = groups[i].split("\\+"); // +로 연결된 수식에서 숫자만 분리

      int sum = 0;
      for (String num : nums) {
        sum += Integer.parseInt(num);
      }

      if (i == 0) {
        result += sum;
      } else {
        result -= sum;
      }
    }

    System.out.println(result);
  }
}
