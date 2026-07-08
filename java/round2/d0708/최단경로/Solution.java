package round2.d0708.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(br.readLine());

    List<List<int[]>> graph = new ArrayList<>();
    for (int i=0; i<=V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.get(u).add(new int[]{v, w}); // next, weight
    }

    int[] dist = new int[V+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[K] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[]{K, 0});

    while(!pq.isEmpty()) {
      int[] cur = pq.poll();
      int u = cur[0];
      int d = cur[1];

      if (d > dist[u]) {
        continue;
      }

      for (int[] node : graph.get(u)) {
        int next = node[0];
        int weight = node[1];

        if (weight + d < dist[next]) {
          dist[next] = weight + d;
          pq.offer(new int[]{next, weight + d});
        }
      }
    }

    for (int i=1; i<=V; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else {
        System.out.println(dist[i]);
      }
    }

  }

}
