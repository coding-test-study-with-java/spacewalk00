import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

//전보 문제 - <다이젝스트라> //파이썬과 다르게 weight 설정필요.
class Edge implements Comparable<Edge> {
    private int weight;
    private int v;
    
    public Edge(int weight, int v) {
        this.weight = weight;
        this.v = v;
    }
    
    public int getWeight() {
        return weight;
    }
    public int getV() {
        return v;
    }
    @Override
    public int compareTo(Edge target) {
        return this.weight <= target.weight ? -1 : 1;
    }
    @Override
    public String toString() {
        return weight + " " + v;
    }
}

public class Q9_2 {
    static final int Max = 1000000000;
    
    public static void dijkstra(ArrayList<ArrayList<Edge>> graph, int start, int[] distance) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Edge(0, start));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int w = e.getWeight();
            int nowV = e.getV();
            
            if(distance[nowV] < w) {
                continue;
            }
            
            //인접 노드들 확인
            for(Edge near: graph.get(nowV)) { //리스트 탐색할 때 for문 대신
                int cost = w + near.getWeight(); 
                if(cost < distance[near.getV()]) { //현재 노드 거쳐서, 다른 노드로 이동하는 거리가 더 짧을 때
                    distance[near.getV()] = cost;
                    pq.add(new Edge(cost, near.getV()));
                }
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken()); //노드 개수
      int M = Integer.parseInt(st.nextToken()); //간선 개수
      int C = Integer.parseInt(st.nextToken()); //시작점
      
      ArrayList<ArrayList<Edge>> graph = new ArrayList<>(); //그래프 저장~
      for(int i=0; i<=N; i++) {
          graph.add(new ArrayList<Edge>());
      }
      
      for(int i=0; i<M; i++) {
          String[] part = br.readLine().split(" ");
          int n1 = Integer.parseInt(part[0]);
          int n2 = Integer.parseInt(part[1]);
          int weight = Integer.parseInt(part[2]);
          
          graph.get(n1).add(new Edge(weight, n2)); //한 방향으로만
      }
      
      /*for(int i=1; i<=N; i++) {
          System.out.println(graph.get(i).toString());
      }*/
      
      int[] distance = new int[N+1]; //최단 경로 테이블 초기화
      for(int i=1; i<=N; i++) {
          distance[i] = Max;
      }
      dijkstra(graph, C, distance);
      
      int cnt = 0, max_distance = 0;
      
      for(int d=1; d<=N; d++) {
          if(distance[d] != Max) {
              cnt++;
              max_distance = Math.max(max_distance, distance[d]);
          }
      }
      System.out.println(cnt-1+" "+ max_distance);
    }
}