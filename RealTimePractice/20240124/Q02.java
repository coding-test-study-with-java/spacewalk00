/**
 * 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 * 
 */
import java.util.*;
import java.io.*;

public class MyClass {
    public static int N;
    public static List<Integer>[] connec; //idx 노드
    public static int[] parents; //idx 자식 - 2부터 ~
    public static boolean[] visited;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        connec = new ArrayList[N+1];
        parents = new int[N+1];
        visited = new boolean[N+1];
        
        for(int i=1; i<=N; i++) {
            connec[i] = new ArrayList<>();
            visited[i] = false;
        }
       
        for(int i=0; i<N-1; i++) { //n-1개 간선
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            connec[n1].add(n2);
            connec[n2].add(n1); //트리 : 순환 없는 양방향 그래프 
        }
        
        dfs(1);
        for(int i=2; i<=N; i++) {
            System.out.println(parents[i]);
        }
    }
    
    public static void dfs(int index) {
        visited[index] = true;
        for(int n : connec[index]) {
            if(!visited[n]) {
                parents[n] = index;
                dfs(n);
            }
        }
    }    
}