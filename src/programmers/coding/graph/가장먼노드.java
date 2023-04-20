package programmers.coding.graph;

import java.util.*;

public class 가장먼노드 {

    static ArrayList<Edge>[] adj;
    static int[] dist;

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight =weight;
        }
    }

    static class Info {
        int index;
        int dist;

        public Info(int to, int dist) {
            this.index = to;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {

        solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }
    public static int solution(int n, int[][] edge) {

        // vertex와 edge를 연결한다.
        input(n, edge);

        int answer = pro();

        return answer;
    }

    public static void input(int n, int[][] edge) {

        adj = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int[] arr : edge) {

            int x = arr[0];
            int y = arr[1];

            adj[x].add(new Edge(y, 1));
            adj[y].add(new Edge(x, 1));
        }
    }

    public static int pro() {

        dijkstra(1);

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < dist.length; i++) {
            list.add(dist[i]);
        }

        // 역정렬
        Collections.sort(list, (o1, o2) -> o2 - o1);

        int count = 1;
        int target = list.get(0);
        for(int i = 1; i < list.size(); i++){

            if(target == list.get(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void dijkstra(int start) {

        // 최소힙을 구한다.
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        pq.add(new Info(start , 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Info info = pq.poll();
            // 최신정보가 아니다
            if(info.dist != dist[info.index]) continue;

            for(Edge e : adj[info.index]) {

                // 최소값이 아니면
                if((dist[info.index] + e.weight) >= dist[e.to]) continue;

                dist[e.to] = dist[info.index] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }
}
