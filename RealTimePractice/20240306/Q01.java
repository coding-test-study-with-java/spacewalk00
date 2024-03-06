/**
 * [바이러스]
 * https://www.acmicpc.net/problem/2606
 * 
 * 연결리스트
 */

import java.io.*;
import java.util.*;

public class MyClass {
    
    static List<Integer>[] A;
    static boolean visited[];
    static int N, E, S;
    static int count = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        S = 1; //시작 노드 고정.
        
        A = new ArrayList[N+1]; //인접 리스트
        visited = new boolean[N+1]; //방문여부
        
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            A[u].add(v);
            A[v].add(u);
        }
        
        System.out.println(DFS(S));
    }
    
    
    static int DFS(int v) {
        visited[v] = true;
        
        for(int i : A[v]) { //연결 노드 중 방문하지 않은 노드로 DFS 실행.
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        
        return count;
    }
}