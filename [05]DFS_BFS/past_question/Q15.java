import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;

//특정 거리의 도시 찾기 - BFS(가까운 노드부터 탐색하기)
public class Q15 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        int X = Integer.parseInt(str.nextToken());
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); //그래프 저장 ArrayList
        int[] d = new int[300001]; //최단거리 저장 배열
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1; //초기화
        }
        
        for(int i=0; i<M; i++) { //간선 정보
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            
            graph.get(start).add(end);
        }
        
        d[X] = 0; //시작 지점 최단 거리값
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int i=0; i<graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if(d[next] == -1) {
                    d[next] = d[now] + 1;
                    q.offer(next); //아직 checking 필요해서 queue에 넣음.
                }
            }
        }
        
        boolean check = false;
        for(int i=1; i<=N; i++) {
            if(d[i] == K) {
                System.out.println(i);
                check = true;
            }
        }
        if(check == false) {
            System.out.println(-1);
        }
    }
}

