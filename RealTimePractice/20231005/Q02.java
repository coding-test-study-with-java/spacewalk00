import java.util.*;

class Solution {
    //북동남서
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public void bfs(int[][] maps, int[][] visited) {
        //1) 범위, 2)이미 방문, 3) 벽        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >=0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if(visited[nx][ny] == 0) {
                        if(maps[nx][ny] == 1) {
                            visited[nx][ny] = visited[x][y] + 1;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }                  
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        //방문 체크를 위한 배열 
        int[][] visited = new int[maps.length][maps[0].length];
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length; j++) {
                visited[i][j] = 0;
            }
        }
        visited[0][0] = 1; //시작 위치
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer == 0) {
            answer = -1; //갈 수 없을 때
        }        
        return answer;
    }
}