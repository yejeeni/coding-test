package round2.d0707.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 수빈 위치
    int k = Integer.parseInt(st.nextToken()); // 동생 위치

    dist = new int[100000 + 1];
    Arrays.fill(dist, -1);
    dist[n] = 0;

    bfs(n);
    System.out.println(dist[k]);
  }

  static void bfs(int x) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.offer(x);

    while(!queue.isEmpty()){
      int node = queue.poll();
      int[] nx = {node-1, node+1, 2*node};

      for (int next : nx) {
        if (next >= 0 && next <= 100000 && dist[next] == -1) {
          dist[next] = dist[node] + 1;
          queue.offer(next);
        }
      }
    }
  }
}
