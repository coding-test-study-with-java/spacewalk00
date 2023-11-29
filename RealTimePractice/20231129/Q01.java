/**
 * 네트워크 연결
 * https://www.acmicpc.net/problem/1922
 */
import java.io.*;
import java.util.*;
public class Main {
    static class Edge implements Comparable<Edge> {
        int c1;
        int c2;
        int w;
        
        Edge(int c1, int c2, int w) {
            this.c1 = c1;
            this.c2 = c2;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.w - e.w; //비용이 가장 작은거
        }
    }

    static int[] parent;
    static List<Edge> edgeList;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i; 
        }
        
        edgeList = new ArrayList<Edge>();
        for(int i=0; i<M; i++) {
            String[] str = br.readLine().split(" ");
            int c1 = Integer.parseInt(str[0]);
            int c2 = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);
            edgeList.add(new Edge(c1, c2, w));
        }
        
        Collections.sort(edgeList);
        
        int answer = 0;
        for(Edge e : edgeList) {
            if(find(e.c1) != find(e.c2)) {
                answer += e.w;
                union(e.c1, e.c2);
            }
        }
        
        System.out.println(answer);
    }
    
    
    public static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot != bRoot) {
            parent[aRoot] = b;
        }
    }
}