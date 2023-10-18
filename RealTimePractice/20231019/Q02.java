import java.util.*;
/**
 * 정확성: 50.0
 * 효율성: 45.0
 * 합계: 95.0 / 100.0
 * 등굣길
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
*/
class Solution {
    //기록
    int[][] visited;
    int[][] map;
    
    //경로 개수 반환
    public int move(int m, int n) {
        if(m < 1 || n < 1 || map[n][m] == -1) {
            return 0;
        }
        //재귀의 종료 부분
        if (m == 1 && n == 1) {  
            return 1;  
        }  
        if(visited[n][m] != -1) { 
            return visited[n][m];
        }
        visited[n][m] = (move(m-1,n) + move(m,n-1)) % 1000000007;
        
        return visited[n][m];
    }
    
    public int solution(int m, int n, int[][] puddles) {
        //int answer = 0;
        visited = new int[n+1][m+1];
        map = new int[n+1][m+1];
        
        for(int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }
        for(int[] r : visited) {
            Arrays.fill(r, -1);
        }
        return move(m, n);
        //return answer;
    }
}