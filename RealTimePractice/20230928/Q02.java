import java.util.*;
class Solution {
    static int[] connected;
    static void DFS(int i, int computers[][], int n) {
        connected[i] = 1;
        for(int j=0; j<n; j++) {
            if(connected[j] == 0 && computers[i][j] == 1) {
                DFS(j, computers, n);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0; 
        connected = new int[n];
        Arrays.fill(connected, 0);
        
        for(int i=0; i<n; i++) {
            if(connected[i] == 0) {
                answer++;
                DFS(i, computers, n);
            }
        }       
        return answer;
    }
}