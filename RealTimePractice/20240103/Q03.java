/**
 * 작업
 * https://www.acmicpc.net/problem/2056
 * 
 * 위상정렬 알고리즘 
 */
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
        
        int[] indegree = new int[N + 1];
		int[] time = new int[N + 1];
		
		StringTokenizer st;
        for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int temp = Integer.parseInt(st.nextToken());
				graph.get(temp).add(i); //선행 작업들 담기

				indegree[i]++;
			}
		}
		
		System.out.println(topologicalSort(N, graph, indegree, time));
    }
    
    public static int topologicalSort(int N, ArrayList<ArrayList<Integer>> graph, int[] indegree, int[] time) {
        Queue<Integer> q = new LinkedList<>();
        
        int[] result = new int[N + 1]; // 각 작업을 수행하는 데 걸리는 시간

        for (int i = 1; i <= N; i++) {
			result[i] = time[i];
			
			if (indegree[i] == 0) { //진입차수가 0인 노드 넣기
				q.offer(i);
			}
        }
        
        while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : graph.get(now)) {
				indegree[next]--;

				result[next] = Math.max(result[next], result[now] + time[next]); //이 부분 생각하기가 핵심임.

				if (indegree[next] == 0) { //새롭게 진입차수가 0이 된 노드 넣기
					q.offer(next);
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, result[i]);
		}

		return answer;
    }
}
