import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//커리큘럼 - 위상정렬알고리즘
//동시에 여러 개의 강의를 들을 수 있음.
//N개의 강의를 수강하기까지 걸리는 최소 시간을 각각 출력
//푸는중

public class Q10_3 {
    public static int N;
    public static int[] lectureTime;
    public static int[] indegree;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void topologySort() {
        int[] result = new int[501];
        for(int i=1; i<=N; i++) {
            result[i] = lectureTime[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) { // 진입차수 0인 노드 큐에 삽입
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int n = q.poll(); //큐에서 노드 꺼내기

            for(Integer i : graph.get(n)) {
                result[i] = Math.max(result[i], result[n]+lectureTime[i]);
                indegree[i]--; 
                if(indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        //위상 정렬을 수행한 결과 출력
        for(int i=1; i<=N; i++) {
            System.out.println(result[i]);
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        N = Integer.parseInt(st.nextToken()); //강의 수 (1~N)
        lectureTime = new int[N+1];
        indegree = new int[N+1];
        for(int i=1; i<=N; i++) {
            indegree[i] = 0;
        }
        graph = new ArrayList<>(); 
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=N; i++) {
            String[] input = br.readLine().split(" ");
            lectureTime[i] = Integer.parseInt(input[0]);
            
            //선수 과목들
            int k = 1;
            while(k < input.length) {
                graph.get(i).add(Integer.parseInt(input[k]));
                indegree[i]++;
                k++;
            }
        }

        topologySort();
    }
}
