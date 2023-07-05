import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
//import java.util.ArrayList;

//미래 도시 - <플로이드 워셜 알고리즘>
public class Q9_1 {
    static final int Max = 1000000000;
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken()); //노드 개수
      int M = Integer.parseInt(st.nextToken()); //간선 개수
      
      /* 
      //그냥 해본 거: 그래프 리스트형태로 저장하기기
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
      for(int i=0; i<=N; i++) {
          graph.add(new ArrayList<>());
      }
      for(int i=0; i<M; i++) {
          String[] nearV = br.readLine().split(" ");
          int n1 = Integer.parseInt(nearV[0]);
          int n2 = Integer.parseInt(nearV[1]);
          
          graph.get(n1).add(n2);
          graph.get(n2).add(n1);
      }
      for(int i=1; i<=N; i++) {  //확인용
          System.out.println(graph.get(i).toString());
      }*/
      
      //최단 경로 2차원 배열 초기화
      int[][] arr = new int[N+1][N+1];
      for(int i=1; i<=N; i++) {
          for(int j=1; j<=N; j++) {
              arr[i][j] = Max;
          }
      }
      
      for(int i=0; i<M; i++) {
         String[] nearV = br.readLine().split(" ");
         int n1 = Integer.parseInt(nearV[0]);
         int n2 = Integer.parseInt(nearV[1]);
         
         arr[n1][n2] = 1;
         arr[n2][n1] = 1; //비용 1
      }
      
      StringTokenizer xk = new StringTokenizer(br.readLine()); //도착노드, 거쳐가는 노드
      int X = Integer.parseInt(xk.nextToken());
      int K = Integer.parseInt(xk.nextToken());

      
      //플로이드 워셜 알고리즘 (다이나믹 프로그래밍)
      for(int k=1; k<=N; k++) {
          for(int a=1; a<=N; a++) {
              for(int b=1; b<=N; b++) {
                 arr[a][b] = Math.min(arr[a][b], arr[a][k] + arr[k][b]);
              }
          }
      }
      
      int distance = arr[1][K] + arr[K][X];
      if (distance >= Max) {
        System.out.println(-1);
      } else {
        System.out.println(distance); 
      }

    }
}