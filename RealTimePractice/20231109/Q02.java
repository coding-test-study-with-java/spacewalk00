import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [행성 터널] 미완성 -> 개념 정리만 함.....
 * https://www.acmicpc.net/problem/2887
 * 
 * 신장 트리
 * : 그래프 중 모든 정점이 간선으로 연결되어 있되, 
 * 간선 간의 사이클이 없는 그래프
 * : 정점의 수 = 간선의 수 + 1
 * 
 * 최소 신장 트리 (MST)
 * : 간선에 비용이 있을 때, 이 비용을 최소화하는 신장 트리
 * 
 * 대표적인 알고리즘 2가지
 * 
 * 1. 크루스칼 알고리즘(간선을 중심으로 탐색, 노드는 확인용)
 *   a. 존재하는 모든 간선을 대상으로 가장 비용이 작은 간선을 선택
 *   b. 현재 선택된 노드들끼리 사이클이 생기지 않는지 확인
 *      => Disjoint Set : 사이클을 찾기 위한 대표적인 방법
 * 2. 프림 알고리즘(노드를 중심으로 간선을 탐색)
 *   a. 정점 중 아무 시작 정점을 고른다.
 *   b. 해당 정점에 연결된 모든 간선 중 가장 최소 비용을 가진 간선을 선택해서 연결한다.
 *   c. 처음 고른 정점과 선택된 간선에 연결된 정점까지 모든 연결된 정점에 연결된 
 *      간선 중 가장 비용이 작은 간선을 선택해 정점을 연결
 *   d. 모든 정점이 연결될 때 까지 2, 3번을 반복
 * 
 * 
 * 
 */

 class Planet {
    int x;
    int y;
    int z;

    public Planet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
 }

 public class Q02 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Planet> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new Planet(x, y, z));
        }

    }
 }

/*
1. 크루스칼 알고리즘 코드 예시

class A implements Comparable<A> {
    int s;
    int e;
    int v;

    public A(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(A a) {//minheap을 위한 우선순위 큐용 메서드
        return a.v >= this.v ? -1 : 1;
    }
}

public class Q02 {
    //find 함수
    public static int find(int a) {
        if(a == parent[a]) {
            return a; //초기화된 상태 : 처음 등장한 상태는 자기 자신이 부모
        }
        parent[a] = find(parent[a]); //find 할 때마다 부모는 최상위 부모로 설정
        return parent[a];
    }
    //union 함수
    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }


    static int N; //정점의 개수
    static int E; //간선의 개수
    static PriorityQueue<A> pq;
    static int[] parent;
    static boolean[] visit;
    static int result;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        visit = new boolean[N+1];
        result = 0;

        pq = new PriorityQueue<A>();
        String[] tempStr;
        for(int i=0; i<E; i++) {
            tempStr = br.readLine().split(" ");
            pq.add(new A(Integer.parseInt(tempStr[0]), Integer.parseInt(tempStr[1]), Integer.parseInt(tempStr[2])));
            //모든 간선에 대해 [시작, 끝, 비용]을 가진 클래스로 우선순위 큐에 add
        }

        for(int i=0; i<E; i++) {
            parent[i] = i;
        } //union-find 초기화는 일단 자기 자신의 부모노드는 자기로 설정

        for(int i=0; i<E; i++) {
            A oneNode = pq.poll(); //현재 큐에 있는 인스턴스 중 비용이 가장 낮은 간선이 poll
            int start = oneNode.s;
            int end = oneNode.e;
            int a = find(start);
            int b = find(end);
            if(a == b) { //만약 간선을 선택해서 연결한다고 했을 때, 사이클이 생기면 안되므로 최상위 노드 확인 후 같으면 넘어간다.
                continue;
            }
            union(start, end); //한쪽의 최상위 부모를 다른 한쪽의 부모로 설정
            result += oneNode.v; //선택된 간선이므로 간선의 비용을 더 함.
        }

        System.out.println(result);


    }
    
}*/
