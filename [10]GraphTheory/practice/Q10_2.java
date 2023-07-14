import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

//도시 분할 계획 - 신장 트리
//최소 비용 출력하기 -> 크루스칼 알고리즘
//2개의 최소 비용 신장 트리 만들기

class Edge implements Comparable<Edge> {
    private int weight;
    private int v1;
    private int v2;
    
    public Edge(int weight, int v1, int v2) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public int getWeight() {
        return weight;
    }
    public int getV1() {
        return v1;
    }
    public int getV2() {
        return v2;
    }
    @Override
    public int compareTo(Edge target) {
        return this.weight - target.weight;
    }
    @Override
    public String toString() {
        return weight + " " + v1 + " " + v2;
    }
}

public class Q10_2 {
    public static int[] parent;
    
    //특정 원소가 속한 집합을 찾기
    public static int find_parent(int n1) {
        if (parent[n1] != n1) { //루트노드가 아니라면
            parent[n1] = find_parent(parent[n1]);
        }
        return parent[n1];
    }

    //두 원소가 속한 집합을 합치기
    public static void union_parent(int n1, int n2) {
        int a = find_parent(n1);
        int b = find_parent(n2);
        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        int N = Integer.parseInt(st.nextToken()); //노드 개수
        int M = Integer.parseInt(st.nextToken()); //간선 개수
      
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        int cost = 0;

        for(int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]); //비용
            edges.add(new Edge(C, A, B));
        }
        Collections.sort(edges);
        int last = 0; //정렬된 상태에서 마지막.. 비용 가장 큰 것.
        
        for(Edge e : edges) {
            int c = e.getWeight();
            int a = e.getV1();
            int b = e.getV2();

            if(find_parent(a) != find_parent(b)) { //사이클 안 될때 (루트노드가 다를때)
                union_parent(a, b);
                cost += c;
                last = c;             
            }
        }
        System.out.println(cost - last); //비용 큰 거 빼주면 2개의 마을로 분리됨.
    }

}
